package Test.B_medium;

import java.util.ArrayList;
import java.util.List;

public class T98 {

    public boolean isValidBST(TreeNode root) {
        ArrayList<Integer> list = new ArrayList<>();
        re(root,list);
        for (int i = 0; i < list.size()-1; i++) {
            if (list.get(i)>list.get(i+1)){
                return false;
            }
        }
        return true;
    }

    // 利用中序遍历的序列判断是不是升序
    public void re(TreeNode node, List<Integer> list){
        if (node == null) return;
        re(node.left,list);
        list.add(node.val);
        re(node.right,list);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(2);
        root.left = new TreeNode(2);
        root.right = new TreeNode(2);
        T98 t98 = new T98();
        boolean validBST = t98.isValidBST(root);
        System.out.println(validBST);
    }

}
