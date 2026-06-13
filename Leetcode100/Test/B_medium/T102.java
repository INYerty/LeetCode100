package Test.B_medium;

import org.w3c.dom.ls.LSInput;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
/**
 * 102. 二叉树的层序遍历
 *
 * 给你二叉树的根节点 root ，返回其节点值的 层序遍历 。 （即逐层地，从左到右访问所有节点）。
 * 提示：
 * * 树中节点数目在范围 [0, 2000] 内
 * * -1000 <= Node.val <= 1000
 *
 * 链接：https://leetcode.cn/problems/binary-tree-level-order-traversal/
 */

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