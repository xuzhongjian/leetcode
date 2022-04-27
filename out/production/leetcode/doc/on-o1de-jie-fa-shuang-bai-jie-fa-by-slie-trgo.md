### 解题思路

此题暴力解想都不用想，必然超过10的8次方，而进阶要求的O(N) 对于数组而言无非就是从前往后，从后往前遍历俩种方式。此时解决问题就从重新定义问题入手
此时重新定义问题 假设答案存在 那么该子序列的第一个值一定小于右侧最大的俩个值，如果不成立 必然不存在。
所有过程就变成了从后往前遍历  记录最大的俩个值（次大值一定在下标上比最大值小）

### 代码

```java
class Solution {
    public boolean increasingTriplet(int[] nums) {
        if(nums.length<3) {
			 return false;
		 }
		 int first =Integer.MIN_VALUE;
		 int second = Integer.MIN_VALUE;
		 for(int i=nums.length-1;i>=0;i--) {
//tips  =号是防止相等的情况
			 if(nums[i]>=first) {
				 first = nums[i];
			 }else if(nums[i]>=second) {
				 second = nums[i];
			 }else {
				 return true;
			 }
		 }
		 return false;
	    }
    
}
```