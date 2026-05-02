package Test.B_medium;

import java.util.ArrayList;
import java.util.List;

public class T230 {
    public int kthSmallest(TreeNode root, int k) {
        ArrayList<Integer> list = new ArrayList<>();
        re(root,list);
        //k从0开始
        return list.get(k-1);
    }


    public void re(TreeNode node , List<Integer> list){
        if (node == null) return;
        re(node.left,list);
        list.add(node.val);
        re(node.right,list);
    }
}
