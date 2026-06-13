package Test.B_medium;

import java.util.ArrayList;
import java.util.LinkedList;
/**
 * 236. 二叉树的最近公共祖先
 *
 * 给定一个二叉树, 找到该树中两个指定节点的最近公共祖先。
 * 百度百科 [https://baike.baidu.com/item/%E6%9C%80%E8%BF%91%E5%85%AC%E5%85%B1%E7%
 * A5%96%E5%85%88/8918834?fr=aladdin]中最近公共祖先的定义为：“对于有根树 T 的两个节点 p、q，最近公共祖先表示为一
 * 个节点 x，满足 x 是 p、q 的祖先且 x 的深度尽可能大（一个节点也可以是它自己的祖先）。”
 * 提示：
 * * 树中节点数目在范围 [2, 105] 内。
 * * -109 <= Node.val <= 109
 * * 所有 Node.val 互不相同 。
 * * p != q
 * * p 和 q 均存在于给定的二叉树中。
 *
 * 链接：https://leetcode.cn/problems/lowest-common-ancestor-of-a-binary-tree/
 */

public class T236 {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        LinkedList<TreeNode> leftPath = new LinkedList<>();
        LinkedList<TreeNode> rightPath = new LinkedList<>();

        if (dfs(root,p.val,leftPath)){
            System.out.println(leftPath);
        }
        if (dfs(root,q.val,rightPath)){
            System.out.println(rightPath);
        }
        //检查两个queue的倒数 头一个一样的元素
        for (int i = leftPath.size()-1;i>=0;i--){
            for (int j = rightPath.size()-1;j>=0;j--){
                if (leftPath.get(i) == rightPath.get(j))
                    return rightPath.get(j);
            }
        }

        return null;
    }

    public boolean dfs(TreeNode node, int targetNum ,LinkedList<TreeNode> path){
        if (node == null) return false;
        path.add(node);
        if (node.val == targetNum) return true;
        if (dfs(node.left, targetNum,path)||dfs(node.right,targetNum,path)){
            return true;
        }
        path.removeLast();
        return false;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(5);
        root.right = new TreeNode(1);
        root.left.left = new TreeNode(6);
        root.left.right = new TreeNode(2);
        root.right.left = new TreeNode(0);
        root.right.right = new TreeNode(8);
        root.left.right.left = new TreeNode(7);
        root.left.right.right = new TreeNode(4);
        T236 t236 = new T236();
        TreeNode treeNode = t236.lowestCommonAncestor(
                root,
                root.left.right.right,
                root.right.right
        );
    }
}