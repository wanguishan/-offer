package main;

import main.utils.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * 二叉搜索树的第k大节点
 *
 * 给定一棵二叉搜索树，请找出其中第k大的节点。
 *
 * 二叉搜索树（二叉查找树）定义：
 *      1. 左子树上 所有结点的值 < 根节点的值
 *      2. 右子树上 所有节点的值 >= 根节点的值
 *      3. 任意结点的左右子树也都是二叉搜索树
 *
 * 特点：二叉搜索树中序遍历结果是排序结果
 *
 * @author Guishan Wan
 * @date 2020/4/17 5:22 下午
 */
public class Solution_54 {

    private List<Integer> list = new ArrayList<>();

    public int kthLargest(TreeNode root, int k) {
        List<Integer> list = inorder(root);
        return list.get(list.size() - k);

    }

    /**
     * 递归进行树的中序遍历
     *
     * @param root
     * @return
     */
    private List<Integer> inorder(TreeNode root) {
        if (root == null) {
            return list;
        }
        inorder(root.left);
        list.add(root.val);
        inorder(root.right);
        return list;
    }
}
