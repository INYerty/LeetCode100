package Test.A_easy;
/**
 * 110. 平衡二叉树
 *
 * 给定一个二叉树，判断它是否是 平衡二叉树
 * 提示：
 * * 树中的节点数在范围 [0, 5000] 内
 * * -104 <= Node.val <= 104
 *
 * 链接：https://leetcode.cn/problems/balanced-binary-tree/
 */

public class T110 {

    public boolean isBalanced(TreeNode root) {
        int height = get_height(root);
        return height != -1;
    }

    public int get_height(TreeNode node){
        if (node==null) {
            return 0;
        }
        int leftheight = get_height(node.left);
        if (leftheight == -1) return -1;
        int rightheight = get_height(node.right);
        if (rightheight == -1 || Math.abs(leftheight-rightheight)>1){
            return -1;
        }else{
            return Math.max(leftheight,rightheight)+1;
        }
    }

    public static void main(String[] args) {

    }
}