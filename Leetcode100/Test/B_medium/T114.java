package Test.B_medium;

import java.util.LinkedList;
/**
 * 114. 二叉树展开为链表
 *
 * 给你二叉树的根结点 root ，请你将它展开为一个单链表：
 * * 展开后的单链表应该同样使用 TreeNode ，其中 right 子指针指向链表中下一个结点，而左子指针始终为 null 。
 * * 展开后的单链表应该与二叉树 先序遍历 [https://baike.baidu.com/item/%E5%85%88%E5%BA%8F%E9%81
 * %8D%E5%8E%86/6442839?fr=aladdin] 顺序相同。
 * 提示：
 * * 树中结点数在范围 [0, 2000] 内
 * * -100 <= Node.val <= 100
 * 进阶：你可以使用原地算法（O(1) 额外空间）展开这棵树吗？
 *
 * 链接：https://leetcode.cn/problems/flatten-binary-tree-to-linked-list/
 */

public class T114 {
    public void flatten(TreeNode root) {
        LinkedList<Integer> list = new LinkedList<>();
        re(root, list);
        list.poll();
        TreeNode treeNode = root;
        while (!list.isEmpty()){
            treeNode.left = null;
            treeNode.right = new TreeNode(list.poll());
            treeNode = treeNode.right;
        }
        System.out.println(list);
    }

    public void re(TreeNode node, LinkedList<Integer> list){
        if (node == null) return;
        list.add(node.val);
        re(node.left,list);
        re(node.right,list);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(5);
        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(4);
        root.right.right = new TreeNode(6);
        T114 t114 = new T114();
        t114.flatten(root);
    }
}