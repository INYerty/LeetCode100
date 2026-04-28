package Test.B_medium;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class T102 {
    public List<List<Integer>> levelOrder(TreeNode root) {
        LinkedList<TreeNode> queue = new LinkedList<>();
        if (root !=null) queue.offer(root);
        List<List<Integer>> lists = new ArrayList<>();
        while (!queue.isEmpty()){
            ArrayList<Integer> list = new ArrayList<>();
            int size = queue.size();
            while(size!=0){
                TreeNode node = queue.getFirst();
                queue.pop();
                list.add(node.val);
                size--;
                if (node.left!=null){
                    queue.offer(node.left);
                }
                if (node.right!=null){
                    queue.offer(node.right);
                }

            }
            lists.add(list);
        }
        return lists;
    }


}
