

### 1. 题目讲解

如果你已经理解了题目，这个视频可以跳过

![15_四数之和题目讲解.mp4](0ef0618d-1556-4c5d-86d5-aa1730cf8077)

### 2. 双指针

![16_四数之和代码实现.mp4](ba83aacb-a3c8-4e02-986d-cd0695eba47d)

代码如下：
```java
public List<List<Integer>> fourSum(int[] nums, int target) {
    if (nums == null || nums.length < 4)
        return new ArrayList<>();

    Arrays.sort(nums);

    List<List<Integer>> res = new ArrayList<>();

    // O(n^3)
    for (int i = 0; i < nums.length - 3; i++) {
        // 忽略后面与前面重复的元素
        if (i > 0 && nums[i] == nums[i - 1]) continue;

        for (int j = i + 1; j < nums.length - 2; j++) {
            // 忽略后面与前面重复的元素
            if (j > i + 1 && nums[j] == nums[j - 1]) continue;

            int partSum = nums[i] + nums[j];
            int left = j + 1;
            int right = nums.length - 1;

            while (left < right) {
                int sum = partSum + nums[left] + nums[right];

                if (sum > target) {
                    right--;
                } else if (sum < target) {
                    left++;
                } else {
                    res.add(Arrays.asList(nums[i], nums[j], nums[left], nums[right]));
                    while (left < right && nums[left] == nums[++left]);
                    while (left < right && nums[right] == nums[--right]);
                }
            }
        }
    }

    return res;
}
```


**类似的题目最好是一起刷，这样可以提高刷题效率：**
1. [leetcode 1 号算法题：两数之和](https://leetcode-cn.com/problems/two-sum/solution/zhu-jian-you-hua-yi-zhi-dao-zui-you-pei-sexli/)
2. [leetcode 167 号算法题：两数之和Ⅱ - 输入有序数组](https://leetcode-cn.com/problems/two-sum-ii-input-array-is-sorted/solution/suan-fa-si-wei-yang-cheng-ji-shuang-zhi-rqju0/)
2. [leetcode 170 号算法题：两数之和Ⅲ - 数据结构设计](https://leetcode-cn.com/problems/two-sum-iii-data-structure-design/solution/suan-fa-si-wei-yang-cheng-ji-er-fen-cha-pz31j/)
3. [leetcode 653 号算法题：两数之和Ⅳ - 输入 BST](https://leetcode-cn.com/problems/two-sum-iv-input-is-a-bst/solution/suan-fa-si-wei-yang-cheng-ji-er-fen-cha-1vttm/)
4. [leetcode 15 号算法题：三数之和](https://leetcode-cn.com/problems/3sum/solution/suan-fa-si-wei-yang-cheng-ji-er-fen-cha-5bk43/)
5. [leetcode 18 号算法题：四数之和](https://leetcode-cn.com/problems/4sum/solution/suan-fa-si-wei-yang-cheng-ji-shuang-zhi-539ll/)
