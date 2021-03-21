### 解题思路
如果你会94题用迭代的方法inorder traverse BST的话，那么你就会这个方法。
因为Inorder traverse 是从小到大。
所以我们只需要比较当前出栈的值是否大于上一个值就好，如果不是则返回false；

### 代码

```cpp
/**
 * Definition for a binary tree node.
 * struct TreeNode {
 *     int val;
 *     TreeNode *left;
 *     TreeNode *right;
 *     TreeNode() : val(0), left(nullptr), right(nullptr) {}
 *     TreeNode(int x) : val(x), left(nullptr), right(nullptr) {}
 *     TreeNode(int x, TreeNode *left, TreeNode *right) : val(x), left(left), right(right) {}
 * };
 */
class Solution {
public:
    bool isValidBST(TreeNode* root) {
        long pre = LONG_MIN;
        stack<TreeNode*> stk;
        while(!stk.empty() || root)
        {
            while(root)
            {
                stk.push(root);
                root = root->left;
            }
            root = stk.top();
            stk.pop();
            if(root->val <= pre) return false;
            pre = root->val;
            root = root->right; 
        }
        return true;

    }
};
```