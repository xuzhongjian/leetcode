### 解题思路

观察整数乘法可以发现，两个位上的数相乘，得到的结果会落到两个位上，等两个数上所有的位两两相乘得到的结果，同位相加，记得最终结果

例如：123 * 12
索引为0的1与索引为1的2相乘，得到2，会落在最终结果的 0+1位和0+1+1位上
故i位与j位相乘的结果会落在 i+j位和i+j+1位上
将两字符串循环遍历相乘，同位相加，最后考虑进位即得最终结果

### 代码

```javascript
/**
 * @param {string} num1
 * @param {string} num2
 * @return {string}
 */
var multiply = function (num1, num2) {
    let ret = new Array(num1.length + num2.length).fill(0);
    for (let i = 0; i < num1.length; i++) {
        for (let j = 0; j < num2.length; j++) {
            //x为个位，y为十位
            let x = Number(num1[i]) * Number(num2[j]);
            let y;
            if (x < 10) {
                y = 0;
            }
            else {
                let temp = x;
                x = x % 10;
                y = (temp - x) / 10;
            }
            //找到对应位，相加
            ret[i + j] = ret[i + j] + y;
            ret[i + j + 1] = ret[i + j + 1] + x;
        }
    }
    //考虑每个位上的满十进位
    for (let i = ret.length - 1; i > 0; i--) {
        if (ret[i] > 9) {
            let temp = ret[i];
            ret[i] = ret[i] % 10;
            ret[i - 1] = ret[i - 1] + (temp - ret[i]) / 10;
        }
    }
    //推出前导零
    while (ret[0] === 0) ret.shift();
    return ret.length ? ret.join('') : '0';
};
```