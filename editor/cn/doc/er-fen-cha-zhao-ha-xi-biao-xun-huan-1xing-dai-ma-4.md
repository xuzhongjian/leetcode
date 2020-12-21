本文我们一起从`O(n)`到`O(logn)`找更优解。借`纳兰性德`《木兰花令·拟古决绝词》说明解法特点
## 循环 · 人生若只如初见，何事秋风悲画扇
### 解题思路
- `遍历`初见`target`赋值`开始位`和`结束位`。再见`target`只更新`结束位`直到当前数`>`目标值
### 代码
```javascript
var searchRange = function(nums, target) {
    return nums.reduce((p, v, i) => v === target ? [p[0] === -1 ? i : p[0], i] : (v > target && (nums.length = 0), p), [-1, -1])
};
```

### 结果
![循环解法运行结果](https://pic.leetcode-cn.com/1606795346-JPJGvV-2.png)

## 哈希表 · 等闲变却故人心，却道故人心易变
### 解题思路
- 对象作哈希表`当前数`作`键名`。初见赋值。再见只更新`结束位`。终得所有数的`起止位置`
### 代码
```javascript
var searchRange = function(nums, target) {
    return nums.reduce((h, v, i) => (h[v] ? h[v][1] = i : h[v] = [i, i], h), Object.create(null))[target] || [-1, -1]
};
```

### 结果
![哈希表解法运行结果](https://pic.leetcode-cn.com/1606795478-VVeqmf-1.png)

### 评价
- 对比`循环`解法，未用到`升序`性质。虽`大材小用`，却求得`所有数`，是以`不变应万变`之解法

## 二分查找 · 中心扩散 · 骊山语罢清宵半，泪雨霖铃终不怨
### 解题思路
- 每轮取中间数。大于目标值，继续查找左边一半。小于目标值，继续查找右边一半
- 找不到，返回`-1`。找到，以其为中心`左右扩散`找`不等于目标值`且`不越界`的边界
### 代码
```javascript
var searchRange = function(nums, target) {
    var i = binarySearch(nums, target)
    if (i === -1) return [-1, -1]
    else {
        var l = i, r = i + 1
        while(nums[l] === target && l >= 0) l--
        while(nums[r] === target && r < nums.length) r++
    }
    return [l + 1, r - 1]
                                            
};
var binarySearch = (nums, target, l = 0, r = nums.length - 1, m = l + r >>> 1) => 
          l  >  r      ? -1 :
    nums[m] === target ?  m :
    nums[m]  >  target ? binarySearch(nums, target, l, m - 1)
                       : binarySearch(nums, target, m + 1, r)
```
### 结果
![二分查找 · 中心扩散运行结果](https://pic.leetcode-cn.com/1606796274-wvFZqN-3.png)
### 评价
- 候选减`半`，速度加快的二分法比较
    - 二分查找：查找复杂度稳定`O(logn)`。顺序存储，空间100%利用。删除插入难
    - 二叉搜索树：查找复杂度理想`O(logn)`，深度为`n`时为`O(n)`
    　　　　　　链式存储，`指针`占额外空间。删除插入只用移动指针

## 二分查找 · 直达边界 · 何如薄幸锦衣郎，比翼连枝当日愿
### 解题思路
- `区别`在于当`nums[m] === target`时，上解法，直接返回值
- 本解法，寻`左边界`时，继续`向左查找`。寻`右边界`时，继续`向右查找`，如图
- `l > r`时返回`右边界`。这样`左边界`会到初见`目标值`左侧，`右边界`会到`目标值`最后出现位

![二分查找 · 直达边界的查找过程](https://pic.leetcode-cn.com/1606799656-HWGQug-image.png)
### 代码

```javascript
var searchRange = function(nums, target) {
    var l = binarySearch(nums, target, true), r = binarySearch(nums, target, false)
    return l === r ? [-1, -1] : [l + 1, r]                            
};
var binarySearch = (nums, target, isL, l = 0, r = nums.length - 1, m = l + r >>> 1) => 
    l  >  r ? r : (isL ? nums[m] >= target : nums[m] > target)
            ? binarySearch(nums, target, isL, l, m - 1)
            : binarySearch(nums, target, isL, m + 1, r)
```
### 结果
![二分查找直达边界运行结果](https://pic.leetcode-cn.com/1606797695-WskDjD-4.png)

### 评价
- `[2,2,2,2,2,2...] target = 2`该例在上解法`左右扩散`时，会退化成`O(n)`
- `比翼`鸟只有`一目一翼`，需`两两齐飞`。`2`个`二分查找`可稳定时间复杂度
- 为什么是`l > r`，为什么要返回`r`？因为要考虑`4种边界情况`，如图
![情况一：找8而8只有1个](https://pic.leetcode-cn.com/1606826452-YTBPnL-image.png)
![情况二：找8而8位于最右](https://pic.leetcode-cn.com/1606826496-SOGsyJ-image.png)
![情况三：找8而8位于最左](https://pic.leetcode-cn.com/1606826750-FFTLzD-image.png)
![情况四：找8而没有8](https://pic.leetcode-cn.com/1606803830-rabKgu-image.png)
- 以上`4种情况`即本题二分查找的`边界`情况，正是`边界`帮助我们确定了`条件`和返回`指针`
