package main;

import main.utils.TreeNode;

/**
 * 二叉树的镜像
 *
 * 操作给定的二叉树，将其变换为源二叉树的镜像
 *
 * @author Guishan Wan
 * @date 2020/4/14 4:45 下午
 */
public class Solution_27 {

    /**
     * 有返回值
     *
     * @param root
     * @return
     */
    public TreeNode mirrorTree(TreeNode root) {
        if (root == null) {
            return null;
        }

        TreeNode l = mirrorTree(root.left);
        TreeNode r = mirrorTree(root.right);
        root.left = r;
        root.right = l;
        return root;
    }

    /**
     * 无返回值
     * 将根节点的左右子节点互换，之后递归左右子节点
     *
     * @param root
     */
    public void mirror(TreeNode root) {
        if (root == null) {
            return;
        }

        TreeNode tmp = root.left;
        root.left = root.right;
        root.right = tmp;

        mirror(root.left);
        mirror(root.right);
    }

}
