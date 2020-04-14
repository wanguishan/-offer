package main;

import main.utils.TreeNode;

/**
 * 二叉树的最近公共祖先
 *
 * @author Guishan Wan
 * @date 2020/4/14 9:34 下午
 */
public class Solution_69 {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        // 递归出口
        if (root == null || root == p || root == q) return root;

        // 后序遍历，也是树的套路
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);

        // 写边界条件，也是后序遍历
        if (left != null && right != null) return root;

        return left == null ? right : left;

/*        if (left == null && right == null) return null;
        if (left == null && right != null) return right;
        if (left != null && right == null) return left;
        return root;*/
    }
}
