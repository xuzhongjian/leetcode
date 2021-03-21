这道题最开始让我恐惧了很久， 源于恐惧来自于本身。
再次下定决心解决之后，发现每那么难。
分享下我刷题的 git, 目前完成了大部分简单题，每道题基本上有多种解法（***git@github.com:theDreamBear/algorithmn.git***）

```
/*
 * @lc app=leetcode.cn id=29 lang=cpp
 *
 * [29] 两数相除
 */
#include <string.h>

#include <algorithm>
#include <iostream>
#include <map>
#include <numeric>
#include <queue>
#include <set>
#include <stack>
#include <string>
#include <unordered_map>
#include <unordered_set>
#include <utility>
#include <vector>

using namespace std;

// @lc code=start
class Solution {
 public:
    long long abs(int val) {
        long long y = val >> 31;
        return y ^ (y + val);
    }

    int divide(int dividend, int divisor) {
        long long sign = 1;
        if ((dividend >> 31) != (divisor >> 31)) {
            sign = -1;
        }
        long long divd = abs(dividend);
        long long divr = abs(divisor);
        if (divr > divd) {
            return 0;
        }
        // i 存的是已经求得的值
        long long i = 0;
        // left 余数
        long long left = divd;
        int exp = 1;
        while (((long long)divr << exp) <= left) {
            ++exp;
        }
        --exp;
        // 判断余数是否大于除数
        while (left >= divr) {
            i += (1ll << exp);
            left -= (divr << exp);
            while (left >= divr && ((long long)divr << exp) > left) {
                --exp;
            }
        }
        if (sign == -1) {
            // i = -i -i应该也属于乘法
            i = ~(i - 1);
        }
        if (i > INT_MAX) {
            return INT_MAX;
        }
        return i;
    }
};
// @lc code=end

int main() {
    int d = -2147483648, r = -1;
    cout << Solution{}.divide(d, r);
}

```
