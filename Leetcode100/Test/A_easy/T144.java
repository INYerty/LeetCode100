package Test.A_easy;


import java.awt.image.AreaAveragingScaleFilter;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class T144 {
    //先序遍历  根左右
    /*public List<Integer> preorderTraversal(TreeNode root) {
        ArrayList<Integer> list = new ArrayList<>();
        retreat(root,list);
        return list;
    }

    public void retreat(TreeNode cur,List<Integer> vect){
        if(cur == null){
            return ;
        }
        vect.add(cur.val);
        retreat(cur.left,vect);
        retreat(cur.right,vect);
    }*/


    // 非递归实现  栈
    public List<Integer> preorderTraversal(TreeNode root) {
        Stack<TreeNode> st = new Stack<>();
        ArrayList<Integer> list = new ArrayList<>();

        // 根节点入栈
        st.push(root);
        while (!st.empty()){
            // 根节点出栈存入数组
            TreeNode top = st.peek();
            st.pop();
            if (top!=null){
                list.add(top.val);
            }else{
                continue;
            }
            st.push(top.right);
            st.push(top.left);
        }
        return list;
    }
}
