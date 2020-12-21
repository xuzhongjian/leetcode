本文尝试顺序、层次、`螺旋遍历`和翻转矩阵，测试`解构赋值`交换数组元素的性能
## 一 顺序遍历 · 拷贝
### 解题思路
- `顺序遍历`矩阵，坐标`[i, j]`旋转90度`[j, n - 1 - j]`，值拷贝至`新矩阵`
### 代码
```javascript
var rotate = function(matrix) {
    let n = matrix.length, m = Array.from({length: n}, _ => Array(n))
    for(let i = 0; i < n; i++)
        for(let j = 0; j < n; j++)
            m[j][n - 1 - i] = matrix[i][j]
    for(let i = 0; i < n; i++)
        for(let j = 0; j < n; j++)
            matrix[i][j] = m[i][j]
};
```
![顺序遍历 + 拷贝解法运行结果](https://pic.leetcode-cn.com/1608356530-uKdqDV-1.png)

## 二 层次遍历 · 旋转
### 解题思路
- 每旋转1格，`上` `右` `下` `左`四格值，存`1`换`4`
- 第`0`层：`0` ~ `n - 1`
    - 第`1`层：`1` ~ `n - 1 - 1`
        - ...  
        - 直到第`n / 2`取整层：`i` ~ `n - 1 - i` 


![层次遍历](https://pic.leetcode-cn.com/1608357572-JEAytu-image.png)

### 代码
```javascript
var rotate = function(matrix) {
    let n = matrix.length
    for(let i = 0; i < n >> 1; i++)
        for(let j = i; j < n - 1 - i; j++) {
            let tmp = matrix[i][j]
            matrix[i][j] = matrix[n - 1 - j][i]
            matrix[n - 1 - j][i] = matrix[n - 1 - i][n - 1 - j]
            matrix[n - 1 - i][n - 1 -j] = matrix[j][n - 1 - i]
            matrix[j][n - 1 - i] = tmp
        }
};
```
![层次遍历 + 旋转解法运行结果](https://pic.leetcode-cn.com/1608357806-piJkkl-2.png)

## 三 翻转
### 解题思路
- `垂直翻转` → 以`n / 2`取整为界，坐标`[i, j]`垂直翻转`[i, n - 1 -j]`
- `对角线翻转` → 以`右上到左下`为界，坐标`[i, j]`对角线翻转`[n - 1 - j, n - 1 - i]`
### 代码
解构赋值
```javascript
var rotate = function(matrix) {
    let n = matrix.length
    for(let i = 0; i < n; i++)
        for(let j = 0; j < n >> 1; j++) 
            [matrix[i][n - 1 - j], matrix[i][j]] = [matrix[i][j], matrix[i][n - 1 - j]]
    for(let i = 0; i < n - 1; i++)
        for(let j = 0; j < n - 1 - i; j++)
            [matrix[n - 1 - j][n - 1 - i], matrix[i][j]] = [matrix[i][j], matrix[n - 1 - j][n - 1 - i]]
};
```
![翻转解构赋值解法运行结果](https://pic.leetcode-cn.com/1608357905-dZowqM-3.png)


中间变量
```javascript
var rotate = function(matrix) {
    let n = matrix.length, tmp, i, j
    for(i = 0; i < n; i++)
        for(j = 0; j < n >> 1; j++) {
            tmp = matrix[i][j]
            matrix[i][j] = matrix[i][n - 1 - j]
            matrix[i][n - 1 - j] = tmp
        }
    for(i = 0; i < n - 1; i++)
        for(j = 0; j < n - 1 - i; j++) {
            tmp = matrix[i][j]
            matrix[i][j] = matrix[n - 1 - j][n - 1 - i]
            matrix[n - 1 - j][n - 1 - i] = tmp
        }
};
```
![翻转中间变量解法运行结果](https://pic.leetcode-cn.com/1608357943-BXoHhT-4.png)

## 四 螺旋遍历 · 队列
### 解题思路
- `螺旋遍历`矩阵，方向`d` `→` `↓` `←` `↑`循环
- 初始边界`b`[上，右，左，下] = [1, n - 1, 0, n - 1]
- 初始位置`i = 0` `j = 0`，遍历格数`k = 0`，直到`k = n * n - 1`所有格遍历完
    - `→` `j++` 到右边界转`↓`，`i++`，右边界收缩`-1`
    - `↓` `i++` 到下边界转`←`，`j--`，下边界收缩`-1`
    - `←` `j--` 到左边界转`↑`，`i--`，左边界收缩`+1`
    - `↑` `i--` 到上边界转`→`，`j++`，上边界收缩`+1`
- 队列`queue` `放入`遍历过的值
    - `→` `留空`。到右边界时，`弹出`赋值
    - `↑` `弹出`赋值
    - `←` `弹出`赋值 到左边界，如`[[1, 2], [3, 4]]`，判断到`3`已到头，`填空`
    - `↑` `弹出`赋值 到上边界，如`[[1, 2, 3],[4, 5, 6],[7, 8, 9]]`，到`5`已到头，`填空`

![螺旋遍历解法图示](https://pic.leetcode-cn.com/1608356149-iUbHqC-image.png)

![螺旋遍历解法填空图示](https://pic.leetcode-cn.com/1608356228-PTNRVH-image.png)
### 代码

```javascript
var rotate = function(matrix) {
    let n = matrix.length, queue = []
    let k = -1, i = 0, j = 0, b = [1, n - 1, 0, n - 1], d = '→'
    while(++k < n * n) {
        queue.push(matrix[i][j])
        switch(d) {
            case '→':
                if (j < b[1]) j++
                else {
                    matrix[i][j] = queue.shift()
                    i++
                    d = '↓'
                    b[1]--
                }
            break
            case '↓':
                matrix[i][j] = queue.shift()
                if (i < b[3]) i++
                else {
                    j--
                    d = '←'
                    b[3]--
                }
            break
            case '←':
                matrix[i][j] = queue.shift()
                if (j > b[2]) j--
                else {
                    if (k + 1 === n * n) {
                        for(let p = j; p <= b[1]; p++) 
                            matrix[b[0] - 1][p] = queue.shift()
                    }
                    i--
                    d = '↑'
                    b[2]++
                }
            break
            case '↑':
                matrix[i][j] = queue.shift()
                if (i > b[0]) i--
                else {
                    for(let p = j; p <= b[1]; p++) 
                        matrix[b[0] - 1][p] = queue.shift()
                    j++
                    d = '→'
                    b[0]++
                }
        }
    }
};
```
![螺旋遍历解法运行结果](https://pic.leetcode-cn.com/1608355272-RXWqwj-5.png)

## 排行
100*100矩阵100组，值在`安全整数范围`随机，每解法旋转100次，每秒操作数
![100*100矩阵100组测试结果](https://pic.leetcode-cn.com/1608359085-NwEwRd-image.png)
根据规范：`解构赋值`需要从被解构对象中（数组，对象）获取迭代器，迭代赋值
除`Safari`某些版本外，`Firefox`及`Chrome`都依规范实现，`解构赋值`速度 < `索引`取值
正如使用`异或`交换变量，某些环境下不能真正节省内存一样，获取迭代器赋值开销 > 变量
在交换`数组元素`而不是`变量`时，性能差距更甚。所以对于`JS`，临时变量依然较好选择
