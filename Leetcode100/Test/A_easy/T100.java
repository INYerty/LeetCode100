package Test.A_easy;
/**
 * 100. 相同的树
 *
 * 给你两棵二叉树的根节点 p 和 q ，编写一个函数来检验这两棵树是否相同。
 * 如果两个树在结构上相同，并且节点具有相同的值，则认为它们是相同的。
 * 提示：
 * * 两棵树上的节点数目都在范围 [0, 100] 内
 * * -104 <= Node.val <= 104
 *
 * 链接：https://leetcode.cn/problems/same-tree/
 */

public class T100 {

    public boolean isSameTree(TreeNode p, TreeNode q) {
        if(p==null || q==null){
            return p==q;
        }
        return p.val == q.val && isSameTree(p.left,q.left)&&isSameTree(p.right,q.right);
    }

    public static void main(String[] args) {
        TreeNode tree = new TreeNode(1);
        tree.left = new TreeNode(2);
        tree.right = new TreeNode(2);
        tree.left.left = new TreeNode(3);
        tree.left.right = new TreeNode(4);
        tree.right.left = new TreeNode(4);
        tree.right.right = new TreeNode(3);
        TreeNode tree2 = new TreeNode(1);
        tree2.left = new TreeNode(2);
        tree2.right = new TreeNode(2);
        tree2.left.left = new TreeNode(3);
        tree2.left.right = new TreeNode(4);
        tree2.right.left = new TreeNode(4);
        tree2.right.right = new TreeNode(3);
        T100 t100 = new T100();
        boolean same = t100.isSameTree(tree,tree2);
        System.out.println(same);
    }
}