### 解题思路
本题本质就是进制转换，10进制转26进制，但有所不同的是正常转换成26进制的余数是0-25，
而本题的余数是1-26（对应A-Z），为了消除差距的这个`1`，有两种方法：
### ①让除数减一，那么余数自然就少一，原来余 1 的变成余 0，以此类推(详细见下表)。
    核心代码 `let remain = (n - 1) % 26;`

表1：
| n      | n / 26的余数 |  (n - 1)/26的余数 |
| :---   | :----:      |:-----     |
| 26     | 0           |    25(从没有余数变成了余25)    |
| 25     | 25          |    24    |
| 24     | 24          |    23    |
| 23     | 23          |    22    |
| ...... | ......      | ......   |
| 3      | 3           |    2     |
| 2      | 2           |    1     |
| 1      | 1           |    0(余1变成了没有余数)     |

### ②对值为 26 的倍数单独处理，保留为 26，而不取余
    核心代码 `let remain = n % 26 ? n % 26 : 26;`


### 代码

方法1：
```javascript
/**
 * @param {number} n
 * @return {string}
 */
var convertToTitle = function(n) {
    if(n <= 0) return "";

    let res = [];
    while(n) {
        n--; // 通过让 n - 1，使得余数 remain 减少 1 
        let remain = n % 26;
        res.unshift(String.fromCharCode(remain + 65));
        n = Math.floor(n / 26);
    }
    return res.join("");
};
```

方法2：
```javascript
/**
 * @param {number} n
 * @return {string}
 */
var convertToTitle = function(n) {
    if(n <= 0) return "";

    let res = [];
    while(n) {
        // if(n % 26 === 0) remain = 26;
        // else remain = n % 26;

        // 上面两行可以简写为下面一行
        let remain = n % 26 ? n % 26 : 26;
        res.unshift(String.fromCharCode(remain + 64));
        n = Math.floor((n - remain) / 26);
    }
    return res.join("");
};
```