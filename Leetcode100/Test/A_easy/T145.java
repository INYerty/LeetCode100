package Test.A_easy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;
/**
 * 145. 二叉树的后序遍历
 *
 * 给你一棵二叉树的根节点 root ，返回其节点值的 后序遍历 。
 * 提示：
 * * 树中节点的数目在范围 [0, 100] 内
 * * -100 <= Node.val <= 100
 * 进阶：递归算法很简单，你可以通过迭代算法完成吗？
 *
 * 链接：https://leetcode.cn/problems/binary-tree-postorder-traversal/
 */

public class T145 {
    // 后序遍历 左右根
    /*public List<Integer> postorderTraversal(TreeNode root) {
        ArrayList<Integer> list = new ArrayList<>();
        retreat(root,list);
        return list;
    }

    public void retreat(TreeNode cur,List<Integer> vect){
        if(cur == null){
            return ;
        }
        retreat(cur.left,vect);
        retreat(cur.right,vect);
        vect.add(cur.val);
    }*/

    public List<Integer> postorderTraversal(TreeNode root) {
        Stack<TreeNode> st = new Stack<>();
        ArrayList<Integer> list = new ArrayList<>();

        st.push(root);
        while (!st.empty()){
            TreeNode top = st.peek();
            st.pop();
            if (top!=null){
                list.add(top.val);
            }else{
                continue;
            }
            st.push(top.left);
            st.push(top.right);
        }

        // 反转数组
        Collections.reverse(list);
        return list;
    }
}