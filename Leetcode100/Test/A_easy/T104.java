package Test.A_easy;


import static java.lang.Math.max;
/**
 * 104. 二叉树的最大深度
 *
 * 给定一个二叉树 root ，返回其最大深度。
 * 二叉树的 最大深度 是指从根节点到最远叶子节点的最长路径上的节点数。
 * 提示：
 * * 树中节点的数量在 [0, 104] 区间内。
 * * -100 <= Node.val <= 100
 *
 * 链接：https://leetcode.cn/problems/maximum-depth-of-binary-tree/
 */

public class T104 {
    public int maxDepth(TreeNode root) {
        // 看结束条件
        if(root == null) return 0;
        return Math.max(maxDepth(root.left),maxDepth(root.right))+1;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);

        T104 t104 = new T104();
        int i = t104.maxDepth(root);
        System.out.println(i);
    }
}