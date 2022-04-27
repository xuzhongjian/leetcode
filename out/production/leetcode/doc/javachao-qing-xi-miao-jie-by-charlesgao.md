这道题用到的知识点就是前缀和，类似这种要找相同数量的题目其实都可以用到前缀和，用一个count变量来计算出现的总次数，当出现1则++，出现0则--，相同count数之间的连续数组即为题意所指区间，用一个hashmap来保存count数的位置即可
```
class Solution {
    public int findMaxLength(int[] nums) {
        int len=nums.length;
        if(len<=1) return 0;
        int count=0;
        int maxLen=0;
        HashMap<Integer,Integer> map=new HashMap<>();
        map.put(0,-1);
        for(int i=0; i<len; i++){
            if(nums[i]==1) count++;
            else if(nums[i]==0) count--;

            if(map.containsKey(count)){
                maxLen=Math.max(maxLen,i-map.get(count));
            }else{
                map.put(count,i);
            }
        }
        return maxLen;
    }
}
```

