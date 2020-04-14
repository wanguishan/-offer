package main;

import main.utils.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 从上到下打印二叉树（层次遍历）
 *
 * @author Guishan Wan
 * @date 2020/4/14 6:19 下午
 */
public class Solution_32 {

    /**
     * 同一层节点按照从左到右的顺序打印
     *
     * @param root
     * @return
     */
    public int[] levelOrder_1(TreeNode root) {
        if (root == null) {
            return new int[]{};
        }

        // 两种数据结构 Queue + ArrayList
        Queue<TreeNode> queue = new LinkedList<>();
        ArrayList<Integer> list = new ArrayList<>();

        // 核心方案：queue取出一个node，将节点值放到list，再把其左右子节点(如果存在)加入到queue
        queue.add(root);
        while (!queue.isEmpty()) {
            TreeNode node = queue.remove();
            list.add(node.val);
            if (node.left != null) {
                queue.add(node.left);
            }
            if (node.right != null) {
                queue.add(node.right);
            }             
        }
        // 把ArrayList类型转换为int[]数组
        int[] res = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            res[i] = list.get(i);
        }
        return res;
    }

    /**
     * 同一层的节点按从左到右的顺序打印，每一层打印到一行
     *
     * @param root
     * @return
     */
    public List<List<Integer>> levelOrder_2(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) return res;

        Queue<TreeNode> queue = new LinkedList<>();

        queue.add(root);
        while (!queue.isEmpty()) {
            int size = queue.size(); // 一定要先获得size，避免fast-fail
            List<Integer> temp = new ArrayList<>();

            for (int i = 0; i < size; i++) {
                TreeNode node = queue.remove();
                temp.add(node.val);
                if (node.left != null) queue.add(node.left);
                if (node.right != null) queue.add(node.right);
            }
            res.add(temp);
        }
        return res;
    }

    /**
     * 之字形顺序打印，每一层打印到一行
     *
     * @param root
     * @return
     */
    public List<List<Integer>> levelOrder_3(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) return res;

        Queue<TreeNode> queue = new LinkedList<>();

        queue.add(root);
        boolean flag = true;
        while (!queue.isEmpty()) {
            int size = queue.size();
            List<Integer> temp = new LinkedList<>();    // 改成LinkedList实现，可提高头部插入效率（双向链表）

            for (int i = 0; i < size; i++) {
                TreeNode node = queue.remove();
                if (flag == true) {
                    temp.add(node.val); // 奇数行，尾部追加
                } else{
                    temp.add(0, node.val);  // 偶数行，尾部插入
                }

                if (node.left != null) queue.add(node.left);
                if (node.right != null) queue.add(node.right);
            }
            flag = !flag;
            res.add(temp);
        }
        return res;
    }

}
