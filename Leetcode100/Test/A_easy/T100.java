package Test.A_easy;

public class T100 {

    public boolean isSameTree(TreeNode p, TreeNode q) {
        if(p==null || q==null){
            return p==q;
        }
        return p.val == q.val && isSameTree(p.left,q.left)&&isSameTree(p.right,q.right);
    }

    public static void main(String[] args) {
        TreeNode tree = new TreeNode(1);
        tree.left = new TreeNode(2);
        tree.right = new TreeNode(2);
        tree.left.left = new TreeNode(3);
        tree.left.right = new TreeNode(4);
        tree.right.left = new TreeNode(4);
        tree.right.right = new TreeNode(3);
        TreeNode tree2 = new TreeNode(1);
        tree2.left = new TreeNode(2);
        tree2.right = new TreeNode(2);
        tree2.left.left = new TreeNode(3);
        tree2.left.right = new TreeNode(4);
        tree2.right.left = new TreeNode(4);
        tree2.right.right = new TreeNode(3);
        T100 t100 = new T100();
        boolean same = t100.isSameTree(tree,tree2);
        System.out.println(same);
    }
}
