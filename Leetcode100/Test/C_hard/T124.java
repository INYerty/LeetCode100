package Test.C_hard;
/**
 * 124. 二叉树中的最大路径和
 *
 * 二叉树中的 路径 被定义为一条节点序列，序列中每对相邻节点之间都存在一条边。同一个节点在一条路径序列中 至多出现一次 。
 * 该路径 至少包含一个 节点，且不一定经过根节点。
 * 路径和 是路径中各节点值的总和。
 * 给你一个二叉树的根节点 root ，返回其 最大路径和 。
 * 提示：
 * * 树中节点数目范围是 [1, 3 * 104]
 * * -1000 <= Node.val <= 1000
 *
 * 链接：https://leetcode.cn/problems/binary-tree-maximum-path-sum/
 */

public class T124 {
    public int maxPathSum(TreeNode root) {
        traversal(root);
        return res;
    }
    int res = Integer.MIN_VALUE;

    public int traversal(TreeNode node){
        if (node == null) return 0;

        int leftMax = Math.max(0,traversal(node.left));
        int rightMax = Math.max(0,traversal(node.right));

        res = Math.max(res,node.val+leftMax+rightMax);

        return node.val+Math.max(leftMax,rightMax);

    }



}