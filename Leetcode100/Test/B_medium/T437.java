package Test.B_medium;

import java.util.List;

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
