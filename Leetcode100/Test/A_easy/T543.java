package Test.A_easy;
/**
 * 543. 二叉树的直径
 *
 * 给你一棵二叉树的根节点，返回该树的 直径 。
 * 二叉树的 直径 是指树中任意两个节点之间最长路径的 长度 。这条路径可能经过也可能不经过根节点 root 。
 * 两节点之间路径的 长度 由它们之间边数表示。
 * 提示：
 * * 树中节点数目在范围 [1, 104] 内
 * * -100 <= Node.val <= 100
 *
 * 链接：https://leetcode.cn/problems/diameter-of-binary-tree/
 */

public class T543 {

    int maxLength = 0;
    public int diameterOfBinaryTree(TreeNode root) {
        //理解成 找左子树最大深度 加上 右子树最大深度  使用递归来实现
        depth(root);
        return maxLength;

    }

    public int depth(TreeNode node) {

        if (node == null) return 0;
        int leftDepth = depth(node.left);
        int rightDepth = depth(node.right);

        maxLength = Math.max(maxLength,leftDepth+rightDepth);

        return Math.max(leftDepth,rightDepth)+1;

    }


    public static void main(String[] args) {

    }

}