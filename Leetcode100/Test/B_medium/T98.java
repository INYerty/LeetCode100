package Test.B_medium;

import java.util.ArrayList;
import java.util.List;
/**
 * 98. 验证二叉搜索树
 *
 * 给你一个二叉树的根节点 root ，判断其是否是一个有效的二叉搜索树。
 * 有效 二叉搜索树定义如下：
 * * 节点的左子树只包含 严格小于 当前节点的数。
 * * 节点的右子树只包含 严格大于 当前节点的数。
 * * 所有左子树和右子树自身必须也是二叉搜索树。
 * 提示：
 * * 树中节点数目范围在[1, 104] 内
 * * -231 <= Node.val <= 231 - 1
 *
 * 链接：https://leetcode.cn/problems/validate-binary-search-tree/
 */

public class T98 {

    public boolean isValidBST(TreeNode root) {
        ArrayList<Integer> list = new ArrayList<>();
        re(root,list);
        for (int i = 0; i < list.size()-1; i++) {
            if (list.get(i)>list.get(i+1)){
                return false;
            }
        }
        return true;
    }

    // 利用中序遍历的序列判断是不是升序
    public void re(TreeNode node, List<Integer> list){
        if (node == null) return;
        re(node.left,list);
        list.add(node.val);
        re(node.right,list);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(2);
        root.left = new TreeNode(2);
        root.right = new TreeNode(2);
        T98 t98 = new T98();
        boolean validBST = t98.isValidBST(root);
        System.out.println(validBST);
    }

}