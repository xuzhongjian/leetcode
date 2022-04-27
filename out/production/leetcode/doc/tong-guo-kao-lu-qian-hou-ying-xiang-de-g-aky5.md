### 解题思路
因为此题只让修改一次数组中的数字，所以我们设一个旗点flag = 1,表示这一次修改的机会还没有用。当nums中只有一个元素时，它是一个满足要求的序列。所以我们遍历数组时从下标1开始。如果nums[i]<nums[i-1]，说明此时违背了非递减原则，在flag = 1的情况下我们可以修改数组。

关键来了！！我们可以修改nums[i]使得nums[i] = nums[i-1],也可以修改nums[i-1]使得nums[i-1] = nums[i]。这时候我们到底该怎么做呢。如果修改了nums[i],那么它会影响后面的序列。比如（5，2，4）。而后面的序列我们还没有遍历到是未知的，所以尽量不要动nums[i]。那么我们首先考虑修改nums[i-1]并使得修改后的区间[0,i-1]仍是一个非递减序列。因此只要nums[i]>=nums[i-2]，那么修改nums[i-1] = nums[i]就没有问题。如果修改后区间[0,i-1]不是一个非递减序列，那么我们只能修改nums[i]了，后面就听天由命了。这种方法是贪心思想的完美体现！

### 代码

```java
class Solution {
    public boolean checkPossibility(int[] nums) {
        int flag = 1;
        for(int i = 1;i<nums.length;i++){
            if(nums[i]<nums[i-1]){
                if(flag == 0){
                    return false;
                }
                else{
                    flag = 0;
                    if(i-2>=0){
                        if(nums[i]>=nums[i-2]){
                            nums[i-1] = nums[i];
                        }
                        else{
                            nums[i] = nums[i-1];
                        }
                    }
                    else{
                        nums[i-1] = nums[i];
                    }
                }
            }
        }
        return true;
    }
}
```