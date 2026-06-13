package Test.A_easy;


import java.awt.image.AreaAveragingScaleFilter;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
/**
 * 144. 二叉树的前序遍历
 *
 * 给你二叉树的根节点 root ，返回它节点值的 前序 遍历。
 * 提示：
 * * 树中节点数目在范围 [0, 100] 内
 * * -100 <= Node.val <= 100
 * 进阶：递归算法很简单，你可以通过迭代算法完成吗？
 *
 * 链接：https://leetcode.cn/problems/binary-tree-preorder-traversal/
 */

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