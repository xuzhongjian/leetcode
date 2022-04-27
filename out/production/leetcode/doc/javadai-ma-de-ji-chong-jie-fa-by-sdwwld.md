
##### 1，暴力求解
这题最容易想到的是暴力求解，类似于使用两个指针，一个指向当前的字符，一个指向当前字符的下一个，然后再判断这两个指针之间的字符串是否是有效的。写出来之后发现超时了
```
    public static int longestValidParentheses(String s) {
        int max = 0;
        for (int i = 0; i < s.length() - 1; i++) {
            if (s.charAt(i) == ')')
                continue;
            for (int j = i + 1; j < s.length(); j++) {
                if (s.charAt(j) == '(' || ((j - i + 1) & 1) == 1)
                    continue;
                if (isValid(s.substring(i, j + 1))) {
                    max = Math.max(max, j - i + 1);
                }
            }
        }
        return max;
    }

    public static boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for (char c : s.toCharArray()) {
            if (c == '(')
                stack.push(')');
            else if (stack.isEmpty() || stack.pop() != c)
                return false;
        }
        return stack.isEmpty();
    }
```

##### 2，使用栈来解决
如果遇到左括号我们就把他的下标压栈，如果遇到右括号说明和栈顶元素匹配，那么栈顶元素比如m出栈，用当前元素的下标减去新的栈顶元素的值，为什么减去新的栈顶元素值，这是因为新的栈顶元素还没匹配成功，之前的栈顶元素m到现在元素的下标之间构成了有效的括号
```
    public int longestValidParentheses(String s) {
        int max = 0;
        Stack<Integer> stack = new Stack<>();
        stack.push(-1);
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                stack.push(i);
            } else {
                stack.pop();
                if (stack.empty()) {
                    stack.push(i);
                } else {
                    max = Math.max(max, i - stack.peek());
                }
            }
        }
        return max;
    }
```
##### 3,动态规划
我们用dp[i]表示字符串前i个字符的最长有效括号。
如果我们要想计算dp[i]就会有下面几种判断

- 第i个字符是左括号"("，那么以他结尾的是构不成有效括号的，所以dp[i]==0;
- 第i个字符是右括号")"，那么以他结尾的是有可能构成有效括号的，所以还需要判断
- - 类似于这种……()，我们需要判断第i-1个字符是不是"("，如果是的话，那么最长有效括号就是第i-2个字符之前构成的最长有效括号+2，也就是dp[i]=dp[i-2]+2。
- - 类似于这种……((……))，我们看一下下面的图来看下，所以我们要判断第i -1- dp[i - 1]个字符是否是"(",如果是，那么递推公式是dp[i]=dp[i] = dp[i - 1] + 2 + dp[i - dp[i - 1] - 2],这里dp[i - dp[i - 1] - 2]是第一个省略号构成的有效括号，这个不要忘了

![image.png](https://pic.leetcode-cn.com/8a1aac6d646ba6e03269c8ed48592521d0e953bb848b0c0f4ba2cc77538522a8-image.png)


```
    public int longestValidParentheses(String s) {
        int max = 0;
        s = " " + s;
        int dp[] = new int[s.length()];
        for (int i = 2; i < s.length(); i++) {
            if (s.charAt(i) == ')') {
                if (s.charAt(i - 1) == '(') {
                    dp[i] = dp[i - 2] + 2;
                } else if (s.charAt(i - dp[i - 1] - 1) == '(') {
                    dp[i] = dp[i - 1] + 2 + dp[i - dp[i - 1] - 2];
                }
                max = Math.max(max, dp[i]);
            }
        }
        return max;
    }
```
##### 4，根据括号的特性查找
在这篇文章中我写过[括号生成](https://mp.weixin.qq.com/s/Ikwz2HQy3IWNe56GUFws4A)，通过这篇文章我们可以知道有效括号的特性，就是长度一定是偶数，并且在任何位置左括号的数量都是大于等于右括号的数量的，如果在任何位置右括号大于左括号的数量，那么说明这个组成的括号是无效的。根据这个特性我们来看下代码
```
    public int longestValidParentheses(String s) {
        int left = 0, right = 0, max = 0;
        //从前往后右括号大于左括号，left和right都归0
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                left++;
            } else {
                right++;
            }
            //left大于right先不管
            if (left == right) {
                max = Math.max(max, 2 * right);
            } else if (right > left) {
                //right大于left重新记
                left = right = 0;
            }
        }
        left = right = 0;
        //从后往前左括号大于右括号，left和right都归0
        for (int i = s.length() - 1; i >= 0; i--) {
            if (s.charAt(i) == '(') {
                left++;
            } else {
                right++;
            }
            if (left == right) {
                max = Math.max(max, 2 * left);
            } else if (left > right) {
                left = right = 0;
            }
        }
        return max;
    }
```


##### 查看更多答案，可扫码关注我微信公众号“**[数据结构和算法](https://img-blog.csdnimg.cn/20190515124616751.jpg)**”