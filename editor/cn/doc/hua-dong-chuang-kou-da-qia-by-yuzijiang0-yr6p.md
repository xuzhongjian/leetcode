### 解题思路
详见注释

### 代码

```java
class Solution {
    public String minWindow(String s, String t) {
        if(s.equals(t)){return s;}
        HashMap<Character, Integer>requires = new HashMap<>();
        HashMap<Character, Integer>window = new HashMap<>();
        for(char c : t.toCharArray()){
            requires.put(c, requires.getOrDefault(c,0) + 1);
        }
        int left = 0, right = 0;    //滑动窗口的左右
        int cnt = 0;    //判断滑动窗口中的char是否已经足够构成t（即使这个数字出现多次，cnt也只增加1，cnt记录的是字符的种类）
        int start = 0, end = s.length() + 1;    //start与end用来记录最后子字符串的开头和结尾
        while(right < s.length()){
            char currentChar = s.charAt(right);
            if(requires.containsKey(currentChar)){  //如果当前字符是需要的
                window.put(currentChar, window.getOrDefault(currentChar, 0) + 1);   //同时把这个字符放入window中
                if(window.get(currentChar).intValue() == requires.get(currentChar).intValue()){
                    ++cnt;  //该类型的字符已经收集完成
                }
            }
            while(cnt == requires.size()) {  //这里不可以写cnt == t.length(), 始终牢记cnt记录的是字符的种类
                if(end - start > right - left){ //更新start end
                    start = left;
                    end = right;
                }
                //开始缩小这个滑动窗口
                char removingChar = s.charAt(left);
                if(!requires.containsKey(removingChar)){    //如果不需要这个字符，直接向右移动
                }
                else if(window.get(removingChar).intValue()>requires.get(removingChar).intValue()){ //虽然需要这个字符，但是数量比要求的多了
                    window.put(removingChar, window.get(removingChar) - 1);
                }
                else{   //删除需要的字符，要修改cnt
                    window.put(removingChar, window.get(removingChar) - 1);
                    cnt--;
                }
                ++left;
            }
            //确定left下一个位置
            while(left<=right && !requires.containsKey(s.charAt(left))){
                ++left;
            }
            right++;
        }
        return end == s.length() + 1?"":s.substring(start, end+1);  //有可能没找到
    }
}
```