### 解题思路
![IMG_0236(20201219-142020).PNG](https://pic.leetcode-cn.com/1608358887-qPHMYs-IMG_0236\(20201219-142020\).PNG)
看图大家应该都能理解核心思路了,只需遍历整个数组一遍即可完成交换
那补充下具体细节
1.如何确定一组4个是哪些点?
![IMG_0237(20201219-142921).PNG](https://pic.leetcode-cn.com/1608359753-gyALpl-IMG_0237\(20201219-142921\).PNG)

2.如何确定锚点?
每圈四个顶点即可
![IMG_0238(20201219-143128).PNG](https://pic.leetcode-cn.com/1608359496-zqatIc-IMG_0238\(20201219-143128\).PNG)
我的代码不用看了,相信大家写的代码都比我的优雅~
### 代码

```csharp
public class Solution {
    public void Rotate(int[][] matrix) {
        int row=matrix.Length;
        if(row<=1)return;
        int[] leftUp=new int[]{0,0};
        int[] rightUp=new int[]{0,row-1};
        int[] leftDown=new int[]{row-1,0};
        int[] rightDown=new int[]{row-1,row-1};
        while(true){
            int Value=0;
            for(int i=0;i<rightUp[1]-leftUp[1];i++){
                int mid=matrix[leftUp[0]][leftUp[1]+Value];
                matrix[leftUp[0]][leftUp[1]+Value]=matrix[leftDown[0]-Value][leftDown[1]];//左上等于左下
                matrix[leftDown[0]-Value][leftDown[1]]= matrix[rightDown[0]][rightDown[1]-Value];//左下等于右下
                matrix[rightDown[0]][rightDown[1]-Value]=matrix[rightUp[0]+Value][rightUp[1]];//右下等于右上
                matrix[rightUp[0]+Value][rightUp[1]]=mid;//右上等于左上
                Value++;
            }
            leftUp[0]++;
            leftUp[1]++;
            rightUp[0]++;
            rightUp[1]--;
            if(rightUp[1]<=leftUp[1])break;
            leftDown[0]--;
            leftDown[1]++;
            rightDown[0]--;
            rightDown[1]--;
        }
    }
}
```