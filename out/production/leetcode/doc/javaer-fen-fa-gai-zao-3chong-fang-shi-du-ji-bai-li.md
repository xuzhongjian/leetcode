
这题是让在**升序数组中找到目标值**，所以最容易想到的就是二分法查找，但这里数组中是有重复的元素，如果找到的是重复的就要返回重复元素的第一个和最后一个的位置，这题之前有过详细介绍，具体可以看下[421，在排序数组中查找元素的第一个和最后一个位置-对二分法查找的改造](https://mp.weixin.qq.com/s?__biz=MzU0ODMyNDk0Mw==&mid=2247487853&idx=1&sn=cf9e8cd0c19a539051953c3d8ba11d58&chksm=fb41824dcc360b5b31e71d95c1c8876556ae47ddd5f599e49eccaec071d9ad28ffd2ae18d6ca&token=124680171&lang=zh_CN#rd)


### 1，二分法查找
如果是做Android的并且经常看源码的可能知道，Android中有个类ArrayMap，他存储的时候hash值是排过序的，查找的时候也是通过二分法查找，但有可能hash值会有冲突，所以他查找之后也是分别往前和往后继续查找然后再比较key值，我这里截图看一下他的源码就找到了
![image.png](https://pic.leetcode-cn.com/1606785503-tMVkmf-image.png)
它是先通过二分法找hash值，如果没找到就返回，如果找到了并且key一样也会返回，如果找到了但key不一样，说明有hash冲突了，他会分别往前和往后再继续查找，然后比较key值，上面的方法binarySearchHashes的源码如下
![image.png](https://pic.leetcode-cn.com/1606785538-ZTxLrp-image.png)

ArrayMap的实现原理用在这里非常合适。我们来画个简图看一下，比如我们通过二分法查找7，然后还要往他的前面和后面继续查找，目的是要找到最开始7和最后7的位置，来看下代码
![image.png](https://pic.leetcode-cn.com/1606785726-yOfofI-image.png)


代码如下
```
public int[] searchRange(int[] nums, int target) {
    int find = searchRangeHelper(nums, target);
    //如果没找到，返回{-1, -1}
    if (find == -1)
        return new int[]{-1, -1};
    int left = find - 1;
    int right = find + 1;
    //查看前面是否还有target
    while (left >= 0 && nums[left] == target)
        left--;
    //查看后面是否还有target
    while (right < nums.length && nums[right] == target)
        right++;
    return new int[]{left + 1, right - 1};
}

//二分法查找
public int searchRangeHelper(int[] nums, int target) {
    int low = 0;
    int high = nums.length - 1;
    while (low <= high) {
        int mid = low + (high - low) / 2;
        int midVal = nums[mid];
        if (midVal < target) {
            low = mid + 1;
        } else if (midVal > target) {
            high = mid - 1;
        } else {
            return mid;
        }
    }
    return -1;
}
```
看一下运行结果
![image.png](https://pic.leetcode-cn.com/1606785819-hgBcMA-image.png)

<br>

### 2，二分法的另一种写法
二分查找一般我们找到某个值之后会直接返回。其实我们有时候还可以对二分法进行改造，当查找某个值的时候不直接返回，而是要继续查找，直到左右两个指针相遇为止。像下面这样，代码中有详细的注释，可以看一下
```
public int[] searchRange(int[] nums, int target) {
    //查找第一个出现的target
    int first = searchRangeHelper(nums, target);
    //判断有没有查找到
    if (first < nums.length && nums[first] == target) {
        //如果查找到了，说明有这个值，我们再来查(target + 1)，如果有这个值，
        //那么查找的结果也是第一次出现的(target + 1)的下标，我们减去1，就是target
        //最后一次出现的下标。如果没有(target + 1)这个值，那么查找的结果就是第一个
        // 大于target的下标，我们减去1也是target最后一次出现的下标。所以这里
        // 无论有没有(target + 1)这个值，都不影响
        int last = searchRangeHelper(nums, target + 1) - 1;
        return new int[]{first, last};
    } else {
        //没有找到这个值，直接返回{-1, -1}
        return new int[]{-1, -1};
    }
}

//如果数组nums中有多个target，那么返回值就是第一个出现的target的下标
//如果数组nums中没有target，那么返回的就是第一个大于target的下标
public static int searchRangeHelper(int[] nums, double target) {
    int low = 0, high = nums.length - 1;
    while (low <= high) {
        int m = low + (high - low) / 2;
        if (target > nums[m])
            low = m + 1;
        else
            high = m - 1;
    }
    return low;
}
```
看一下运行结果
![image.png](https://pic.leetcode-cn.com/1606785894-KkOxAt-image.png)

<br>

看到这里可能有的同学灵光乍现，通过二分法能找到target第一次出现的位置，那么通过二分法能不能找到target最后一次出现的位置。当然也是可以的，代码在下面给你准备好了

```
public int[] searchRange(int[] nums, int target) {
    int first = searchFirst(nums, target);
    //判断有没有查找到
    if (first < nums.length && nums[first] == target) {
        int last = searchLast(nums, target);
        return new int[]{first, last};
    } else {
        //没有找到这个值，直接返回{-1, -1}
        return new int[]{-1, -1};
    }
}

//如果数组nums中有多个target，那么返回值就是第一个出现的target的下标
//如果数组nums中没有target，那么返回的就是第一个大于target的下标
public static int searchFirst(int[] nums, double target) {
    int low = 0, high = nums.length - 1;
    while (low <= high) {
        int m = low + (high - low) / 2;
        if (target > nums[m])
            low = m + 1;
        else
            high = m - 1;
    }
    return low;
}

public static int searchLast(int[] nums, double target) {
    int low = 0, high = nums.length - 1;
    while (low <= high) {
        int m = low + (high - low) / 2;
        if (target >= nums[m])
            low = m + 1;
        else
            high = m - 1;
    }
    return high;
}
```
看一下运行结果
![image.png](https://pic.leetcode-cn.com/1606785948-cWIOGP-image.png)




<br>

**如果觉得有用就给个赞吧，你的赞是给我最大的鼓励，也是我写作的最大动力**


