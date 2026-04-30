package Test.A_easy;
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
