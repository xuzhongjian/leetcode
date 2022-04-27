### 解题思路
方法一：动态规划
时间复杂度O(n^2)
空间复杂度O(n)
### 代码
```python3
class Solution:
    def numTrees(self, n: int) -> int:
        #an = a0*a(n-1) + a1*a(n-2)+....a(n-1)*a0
        #a(n+1) = a0*a(n) + a1*a(n-1)
        #a(n-1) = (a1 + ... a(n-2))*2
        #an = 4*a(n-1)
        #时间复杂度为o(n*2)
        if n == 0:
            return 0
        if n == 1:
            return 1
        if n == 2:
            return 2
        k = 3
        output = []
        output.append(1)
        output.append(1)
        output.append(2)
        while k <= n:
            temp=0
            for i in range(k):
                temp += (output[i]*output[k-1-i])
            output.append(temp)
            k+=1
        return output[-1]        
```

方法二：卡特兰数推导
利用了级数和生成多项式
时间复杂度为O(n)
空间复杂度为O(0)
```python []
class Solution:
    def numTrees(self, n: int) -> int:
        def stratum(n,k):
            product=1
            for i in range(k,n+1):
                product*=i
            return product
        return int(stratum(2*n,n+1)/stratum(n,1)/(n+1))

        
```

