package main;

import main.utils.TreeNode;

/**
 * 树的子结构
 * 输入两棵二叉树A，B，判断B是不是A的子结构。（ps：我们约定空树不是任意一个树的子结构）
 *
 * @author Guishan Wan
 * @date 2020/4/14 4:11 下午
 */
public class Solution_26 {

    // 主函数功能：树A的子结构与B树结构相同
    public boolean hasSubtree(TreeNode rootA, TreeNode rootB) {
        if (rootA == null || rootB == null) {
            return false;
        }
        // 当前树结构相同，或左子树当中有相同，或右子树当中有相同
        return isSame(rootA, rootB) || isSame(rootA.left, rootB) || isSame(rootA.right, rootB);
    }

    // isSame()函数功能：树A结构和树B结构相同
    private boolean isSame(TreeNode rootA, TreeNode rootB) {
        if (rootB == null) {
            return true;
        }
        // B已经不是null，且A还是null
        if (rootA == null) {
            return false;
        }
        // 当前结点值相同，且左子树结构相同，且右子树结构相同
        return rootA.val == rootB.val && isSame(rootA.left, rootB.left) && isSame(rootA.right, rootB.right);
    }
}
