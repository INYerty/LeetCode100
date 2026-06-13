package Test.A_easy;
/**
 * 101. 对称二叉树
 *
 * 给你一个二叉树的根节点 root ， 检查它是否轴对称。
 * 提示：
 * * 树中节点数目在范围 [1, 1000] 内
 * * -100 <= Node.val <= 100
 * 进阶：你可以运用递归和迭代两种方法解决这个问题吗？
 *
 * 链接：https://leetcode.cn/problems/symmetric-tree/
 */

public class T101 {
    public boolean isSymmetric(TreeNode root) {
        return retreat(root.left,root.right);
    }

    boolean retreat(TreeNode left,TreeNode right){
        if (left==null|right==null){
            return left==right;
        }
        return left.val==right.val && retreat(left.left,right.right) && retreat(right.left,left.right);
    }


    public static void main(String[] args) {
        TreeNode tree = new TreeNode(1);
        tree.left = new TreeNode(2);
        tree.right = new TreeNode(2);
        tree.left.left = new TreeNode(3);
        tree.left.right = new TreeNode(4);
        tree.right.left = new TreeNode(4);
        tree.right.right = new TreeNode(3);
        T101 t101 = new T101();
        boolean symmetric = t101.isSymmetric(tree);
        System.out.println(symmetric);
    }
}