package Test.B_medium;

import org.w3c.dom.ls.LSInput;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class T102 {
    public List<List<Integer>> levelOrder(TreeNode root) {
        LinkedList<TreeNode> queue = new LinkedList<>();  //声明队列
        ArrayList<List<Integer>> res = new ArrayList<>();
        if (root!=null){
            queue.offer(root);
        }
        while(!queue.isEmpty()){
            int size = queue.size();
            ArrayList<Integer> list = new ArrayList<>();
            while (size!=0){
                // 取一层的元素
                TreeNode first = queue.getFirst();
                queue.pop();
                list.add(first.val);

                size--;
                //如果该元素有左右孩子？
                if (first.left!=null){
                    queue.offer(first.left);
                }
                if (first.right!=null){
                    queue.offer(first.right);
                }
            }
            res.add(list);
        }
        return res;
    }


}
