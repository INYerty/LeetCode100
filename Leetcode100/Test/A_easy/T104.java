package Test.A_easy;


import static java.lang.Math.max;

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
