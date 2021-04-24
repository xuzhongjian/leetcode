推荐查看 @windliang 对于本题的题解

以数字 486 为例示范 10 进制与其他进制的转换过程：

通过【除留余数法】将数字 486 由 10 进制转换为 10 进制
![10jinzhi.png](https://pic.leetcode-cn.com/1598244864-kuzcXA-10jinzhi.png)
10 的 3 次幂大于 486 循环结束
可拆解出 10 进制数的个位、十位、百位…，再反向罗列得到 486

同理，通过【除留余数法】将数字 486 由 10 进制转换为 2 进制
![2jinzhi.png](https://pic.leetcode-cn.com/1598244884-ToQXNd-2jinzhi.png)
2 的 9 次幂大于 486 循环结束
可拆解出 2 进制数 ***逻辑上的*** 个位、十位、百位…，再反向罗列得到 111100110

同理，本题是通过【除留余数法】将数字 486 由 10 进制转换为 26 进制

- 10 进制包括数字：0~9
- 2 进制包括：0、1
- 26 进制应包括：0~25

通过【除留余数法】将 10 进制转换为 10 进制时，可逐个获取到个位、十位、百位…，同理：

通过【除留余数法】将 10 进制转换为 26 进制时，也可逐个获取到 26 进制 ***逻辑上的*** 个位、十位、百位…

因为 Excel 取值范围为 1~26，故可将 26 进制 ***逻辑上的*** 个位、十位、百位…均减 1 映射到 0~25 即可，最后转换为字符


```
public static String convertToTitle(int n) {
	StringBuilder stringBuilder = new StringBuilder();
	while (n != 0) {
		n--; // 依次获取 26 进制逻辑上的个位、十位、百位…（虽然在 26 进制中不这么叫）
		stringBuilder.append((char) ('A' + n % 26));
		n /= 26;
	}
	return stringBuilder.reverse().toString();
}
```




