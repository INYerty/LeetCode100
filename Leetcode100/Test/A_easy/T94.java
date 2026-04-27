package Test.A_easy;

import java.awt.image.renderable.RenderableImage;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class T94 {
    //中序遍历  左根右
    /*public List<Integer> inorderTraversal(TreeNode root) {
        ArrayList<Integer> list = new ArrayList<>();
        retreat(root,list);
        return list;
    }

    public void retreat(TreeNode cur,List<Integer> vect){
        if(cur == null){
            return;
        }
        retreat(cur.left,vect);
        vect.add(cur.val);
        retreat(cur.right,vect);
    }*/


    //TODO 复习一下
    public List<Integer> inorderTraversal(TreeNode root) {
        // 栈
        Stack<TreeNode> st = new Stack<>();
        ArrayList<Integer> list = new ArrayList<>();
        // 1一路向左找左节点 并且入栈走过的节点
        // 2找到最左节点之后 入栈之后 peek一下加入Array
        // 3拿到peek之后判断右节点是否为空 不为空 加入Array pop最左节点
        // 4再从栈取元素 即为当前左右节点的父亲 入栈之后 peek一下加入Array
        // 5拿到peek之后判断右节点是否为空 不为空 加入Array pop最左节点
        // 以后也是重复2、3步
        TreeNode cur = root;
        while (cur!=null||!st.empty()){
            if (cur!=null){
                st.push(cur);//入栈走过的节点
                cur = cur.left;
            }else{
                // 此时cur是最左节点
                cur = st.peek();
                st.pop();
                list.add(cur.val);
                // 如果有遍历右节点
                cur = cur.right;
            }
        }
        return list;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.left.right = new TreeNode(5);
        T94 t94 = new T94();
        List<Integer> integers = t94.inorderTraversal(root);
        System.out.println(integers);

    }
}
