# 思路一
1，将除法转化为减法，循环相减，如果被除数和除数都是正数，代码如下
```
public int divide(int dividend, int divisor) {
		int result=0;
		while(dividend>=divisor) {
			dividend-=divisor;
			result+=1;
		}
		return result;
	}
```
2，由于被除数和除数可能异号，加一个标志位进行判断
```
boolean k=(dividend>0&&divisor>0)||(dividend<0&&divisor<0);
```
3，将被除数和除数都转成正数或负数进行计算，由于在Java中，当t=Integer.MIN_VALUE时（t取相反数依旧是它本身）此时可能存在越界问题，因此都用负数进行计算

4，此外，当dividend=Integer.MIN_VALUE，divisor=-1时，结果越界，将该情况特殊处理

完整代码如下
```
public int divide(int dividend, int divisor) {
		if(dividend==Integer.MIN_VALUE&&divisor==-1)
			return Integer.MAX_VALUE;
		
		boolean k=(dividend>0&&divisor>0)||(dividend<0&&divisor<0);
		int result=0;
		dividend=-Math.abs(dividend);
            divisor=-Math.abs(divisor);
		while(dividend<=divisor) {
			dividend-=divisor;
			result+=1;
		}
		return k?result:-result;
	}
```
该方法运行效率较低，时间复杂度为O(n)，在leetcode上测试超时
# 思路二
采用二分法的思想，dividend每次减去2^n个divisor（尽可能多），同时reslut每次加2^n
```
public int divide(int dividend, int divisor) {
		if(dividend==Integer.MIN_VALUE&&divisor==-1)
			return Integer.MAX_VALUE;
		
		boolean k=(dividend>0&&divisor>0)||(dividend<0&&divisor<0);
		int result=0;
		dividend=-Math.abs(dividend);
                divisor=-Math.abs(divisor);
		while(dividend<=divisor) {
			int temp=divisor;
			int c=1;
			while(dividend-temp<=temp) {
				temp=temp<<1;
				c=c<<1;
			}
			dividend-=temp;
			result+=c;
		}
		return k?result:-result;
	}
```
时间复杂度为O(logn)
