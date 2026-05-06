package Test.C_hard;

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
