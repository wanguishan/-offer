package main;

import main.utils.TreeNode;

/**
 * 二叉搜索树的最近公共祖先
 * (二叉搜索树BST的特点：左 < 根， 右 > 根，可以二分法进行计算)
 *
 * 给定一个二叉搜索树, 找到该树中两个指定节点的最近公共祖先
 * 百度百科中最近公共祖先的定义为：“对于有根树 T 的两个结点 p、q，最近公共祖先表示为一个结点 x，满足 x 是 p、q 的祖先且 x 的深度尽可能大（一个节点也可以是它自己的祖先）。”
 *
 * @author Guishan Wan
 * @date 2020/4/14 9:13 下午
 */
public class Solution_68 {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {

        // 边界条件，递归终止条件
        if (root == null) {
            return null;
        }

        // p, q都在左子树
        if (p.val < root.val && q.val < root.val) {
            return lowestCommonAncestor(root.left, p, q);
        }
        // p, q都在右子树
        if (p.val > root.val && q.val > root.val) {
            return lowestCommonAncestor(root.right, p, q);
        }
        // 如果p, q分别在根节点两边，则根节点即为最近公共祖先
        return root;
    }
}
