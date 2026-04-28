package Test.B_medium;

import java.util.ArrayList;
import java.util.List;

public class T199 {
    public List<Integer> rightSideView(TreeNode root) {
        ArrayList<Integer> list = new ArrayList<>();
        re(root,0,list);
        return list;
    }

    public void re(TreeNode node,int depth,ArrayList<Integer> list){
        if (node == null) return;
        if (depth==list.size()){
            list.add(node.val);
        }
        re(node.right,depth+1,list);
        re(node.left,depth+1,list);
    }
}
