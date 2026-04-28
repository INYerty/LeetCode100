package Test.A_easy;

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
