package main;

import main.utils.TreeLinkNode;

/**
 * 二叉树的下一个节点
 * <p>
 * 给定一个二叉树和其中的一个结点，请找出中序遍历顺序的下一个结点并且返回
 * 注意，树中的结点不仅包含左右子结点，同时包含指向父结点的指针
 *
 * @author wanguishan
 * @date 2019年12月6日14:05:07
 */
public class Solution_8 {
    public TreeLinkNode getNext(TreeLinkNode pNode) {

        // 如果一个节点的右子树不为空，那么该节点的下一个节点是右子树的最左节点
        if (pNode.right != null) {
            TreeLinkNode node = pNode.right;
            while (node.left != null) {
                node = node.left;
            }
            return node;
        } else {
            while (pNode.next != null) {
                TreeLinkNode parentNode = pNode.next;
                // 如果一个节点没有右子树，并且是它父节点的左子节点，那么下一个节点就是它的父节点
                if (parentNode.left == pNode) {
                    return parentNode;
                }
                // 否则沿着父节点向上遍历，直到找到某节点是其父节点的左子节点，返回其父节点
                pNode = pNode.next;
            }
        }
        return null;
    }
}
