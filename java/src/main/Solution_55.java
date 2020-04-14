package main;

import main.utils.TreeNode;

/**
 * 二叉树的深度
 *
 * @author Guishan Wan
 * @date 2020/4/14 10:29 下午
 */
public class Solution_55 {
    /**
     * 求二叉树的深度
     * 从根节点到叶节点依次经过的节点（含根、叶节点）形成树的一条路径，最长路径的长度为树的深度
     *
     * @param root
     * @return
     */
    public int maxDepth(TreeNode root) {

        if (root == null) return 0;

        // 分别得到了root左右孩子的深度
        int l = maxDepth(root.left);
        int r = maxDepth(root.right);

        return Math.max(l, r) + 1;
    }

    /**
     * 判断一颗树是不是平衡二叉树
     * 如果某二叉树中任意节点的左右子树的深度相差不超过1，那么它就是一棵平衡二叉树
     *
     * @param root
     * @return
     */
    public boolean isBalanced(TreeNode root) {

        if (root == null) return true;

        int l = maxDepth(root.left);
        int r = maxDepth(root.right);

        return Math.abs(r - l) <= 1 && isBalanced(root.left) && isBalanced(root.right);
    }
}