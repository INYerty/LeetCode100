package Test.B_medium;

import java.util.ArrayList;
import java.util.LinkedList;

public class T236 {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        LinkedList<TreeNode> leftPath = new LinkedList<>();
        LinkedList<TreeNode> rightPath = new LinkedList<>();

        if (dfs(root,p.val,leftPath)){
            System.out.println(leftPath);
        }
        if (dfs(root,q.val,rightPath)){
            System.out.println(rightPath);
        }
        //检查两个queue的倒数 头一个一样的元素
        for (int i = leftPath.size()-1;i>=0;i--){
            for (int j = rightPath.size()-1;j>=0;j--){
                if (leftPath.get(i) == rightPath.get(j))
                    return rightPath.get(j);
            }
        }

        return null;
    }

    public boolean dfs(TreeNode node, int targetNum ,LinkedList<TreeNode> path){
        if (node == null) return false;
        path.add(node);
        if (node.val == targetNum) return true;
        if (dfs(node.left, targetNum,path)||dfs(node.right,targetNum,path)){
            return true;
        }
        path.removeLast();
        return false;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(5);
        root.right = new TreeNode(1);
        root.left.left = new TreeNode(6);
        root.left.right = new TreeNode(2);
        root.right.left = new TreeNode(0);
        root.right.right = new TreeNode(8);
        root.left.right.left = new TreeNode(7);
        root.left.right.right = new TreeNode(4);
        T236 t236 = new T236();
        TreeNode treeNode = t236.lowestCommonAncestor(
                root,
                root.left.right.right,
                root.right.right
        );
    }
}
