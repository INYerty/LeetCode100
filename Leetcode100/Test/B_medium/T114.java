package Test.B_medium;

import java.util.LinkedList;

public class T114 {
    public void flatten(TreeNode root) {
        LinkedList<Integer> list = new LinkedList<>();
        re(root, list);
        list.poll();
        TreeNode treeNode = root;
        while (!list.isEmpty()){
            treeNode.left = null;
            treeNode.right = new TreeNode(list.poll());
            treeNode = treeNode.right;
        }
        System.out.println(list);
    }

    public void re(TreeNode node, LinkedList<Integer> list){
        if (node == null) return;
        list.add(node.val);
        re(node.left,list);
        re(node.right,list);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(5);
        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(4);
        root.right.right = new TreeNode(6);
        T114 t114 = new T114();
        t114.flatten(root);
    }
}
