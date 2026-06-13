package Test.B_medium;

import java.util.List;
/**
 * 437. 路径总和 III
 *
 * 给定一个二叉树的根节点 root ，和一个整数 targetSum ，求该二叉树里节点值之和等于 targetSum 的 路径 的数目。
 * 路径 不需要从根节点开始，也不需要在叶子节点结束，但是路径方向必须是向下的（只能从父节点到子节点）。
 * 提示:
 * * 二叉树的节点个数的范围是 [0,1000]
 * * -109 <= Node.val <= 109
 * * -1000 <= targetSum <= 1000
 *
 * 链接：https://leetcode.cn/problems/path-sum-iii/
 */

public class T437 {
    public int pathSum(TreeNode root, long targetSum) {
        if (root == null) return 0;

        int ret = rootSum(root,targetSum);
        ret+= pathSum(root.left,targetSum);
        ret+= pathSum(root.right,targetSum);
        return ret;
    }

    public int rootSum(TreeNode node, long targetSum ){
        int ret = 0;
        if (node == null) return 0;

        int val = node.val;
        if (val == targetSum) {
            ret++;
        }

        ret+=rootSum(node.left,targetSum-val);
        ret+=rootSum(node.right,targetSum-val);

        return ret;
    }

}