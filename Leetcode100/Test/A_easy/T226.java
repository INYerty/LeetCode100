package Test.A_easy;

import java.io.Flushable;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class T226 {
    public TreeNode invertTree(TreeNode root) {
        LinkedList<TreeNode> queue = new LinkedList<>();

        if (root == null) return null;

        queue.offer(root);

        while (!queue.isEmpty()){
            TreeNode node = queue.poll();

            TreeNode tmp = node.left;
            node.left = node.right;
            node.right = tmp;

            if (node.left!=null){
                queue.offer(node.left);
            }
            if (node.right!=null){
                queue.offer(node.right);
            }
        }
        return root;

    }


    public static void main(String[] args) {
        T226 t226 = new T226();
        TreeNode tree = new TreeNode(2);
        tree.left = new TreeNode(1);
        tree.right = new TreeNode(3);
        TreeNode treeNode = t226.invertTree(tree);
        System.out.println(treeNode);
    }

}
