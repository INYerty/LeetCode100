package Test.B_medium;

import java.util.ArrayList;
import java.util.List;
/**
 * 230. 二叉搜索树中第 K 小的元素
 *
 * 给定一个二叉搜索树的根节点 root ，和一个整数 k ，请你设计一个算法查找其中第 k 小的元素（k 从 1 开始计数）。
 * 提示：
 * * 树中的节点数为 n 。
 * * 1 <= k <= n <= 104
 * * 0 <= Node.val <= 104
 * 进阶：如果二叉搜索树经常被修改（插入/删除操作）并且你需要频繁地查找第 k 小的值，你将如何优化算法？
 *
 * 链接：https://leetcode.cn/problems/kth-smallest-element-in-a-bst/
 */

public class T230 {
    public int kthSmallest(TreeNode root, int k) {
        ArrayList<Integer> list = new ArrayList<>();
        re(root,list);
        //k从0开始
        return list.get(k-1);
    }


    public void re(TreeNode node , List<Integer> list){
        if (node == null) return;
        re(node.left,list);
        list.add(node.val);
        re(node.right,list);
    }
}