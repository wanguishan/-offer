package main;

import main.utils.TreeNode;

/**
 * 对称的二叉树
 * 请实现一个函数，用来判断一颗二叉树是不是对称的。注意，如果一个二叉树同此二叉树的镜像是同样的，定义其为对称的。
 *
 * @author Guishan Wan
 * @date 2020/4/14 5:21 下午
 */
public class Solution_28 {
    public boolean isSymmetrical(TreeNode root) {
        if (root == null) {
            return true;
        }

        return isSymmetrical(root, root);
    }

    public boolean isSymmetrical(TreeNode A, TreeNode B) {
        // 边界条件，递归终止
        if (A == null && B == null) {
            return true;
        }
        if (A == null || B == null) {
            return false;
        }

        return A.val == B.val && isSymmetrical(A.left, B.right) && isSymmetrical(A.right, B.left);
    }
}
