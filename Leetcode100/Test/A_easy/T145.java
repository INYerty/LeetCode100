package Test.A_easy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

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
