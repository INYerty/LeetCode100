package Test.B_medium;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class T199 {
    /*public List<Integer> rightSideView(TreeNode root) {
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
    }*/

/*-----------------------如果用层序遍历呢? BFS--------------------------------*/

    public List<Integer> rightSideView(TreeNode root) {
        LinkedList<TreeNode> queue = new LinkedList<>(); //声明队列
        ArrayList<Integer> list = new ArrayList<>();
        if (root != null) {
            queue.offer(root);
        }
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                if (node.right != null) queue.offer(node.right);
                if (node.left != null) queue.offer(node.left);
                if (i == 0){
                    list.add(node.val);
                }
            }
        }
        return list;
    }
}
