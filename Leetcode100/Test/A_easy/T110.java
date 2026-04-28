package Test.A_easy;

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
