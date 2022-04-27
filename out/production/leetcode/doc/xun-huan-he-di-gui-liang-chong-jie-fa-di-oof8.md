&emsp;&emsp;我不是很理解为什么有时候递归写法比循环写法效率要高。如果有知道的大佬，希望您可以在评论区解释一下。

### 方法一：循环

* 执行用时：8 ms, 在所有 Java 提交中击败了36.13%的用户
* 内存消耗：36 MB, 在所有 Java 提交中击败了70.93%的用户

```
class Solution {
    public String countAndSay(int n) {
        StringBuilder result = new StringBuilder();
        result.append(1);
        for (int i = 1; i < n; i++) {
            // 记录当前行的字符串
            StringBuilder s = new StringBuilder();
            // 记录每个数字的开始索引
            int start = 0;
            for (int j = 1; j < result.length(); j++) {
                // 当数字发生改变时执行
                if (result.charAt(j) != result.charAt(start)) {
                    s.append(j - start).append(result.charAt(start));
                    start = j;
                }
            }
            // 字符串最后一个数字
            s.append(result.length() - start).append(result.charAt(start));
            result = s;
        }
        return result.toString();
    }
}
```

### 方法二：递归

* 执行用时：2 ms, 在所有 Java 提交中击败了91.78%的用户
* 内存消耗：36.2 MB, 在所有 Java 提交中击败了49.94%的用户

```
class Solution {
    public String countAndSay(int n) {
        // 递归终止条件
        if (n == 1) {
            return "1";
        }
        // 获取到上一层的字符串
        String s = countAndSay(n - 1);
        StringBuilder result = new StringBuilder();
        // 记录每个数字的开始索引
        int start = 0;
        for (int i = 1; i < s.length(); i++) {
            // 当数字发生改变时执行
            if (s.charAt(i) != s.charAt(start)) {
                result.append(i - start).append(s.charAt(start));
                start = i;
            }
        }
        // 字符串最后一个数字
        result.append(s.length() - start).append(s.charAt(start));
        return result.toString();
    }
}
```

**文中若有不恰当的地方，请您一定要告诉我。前路崎岖，望我们可以互相帮助，并肩前行！**

> 本人博客链接 [zyxwmj.top](http://zyxwmj.top/)