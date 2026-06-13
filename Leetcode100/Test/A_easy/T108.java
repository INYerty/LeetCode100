package Test.A_easy;
/**
 * 108. 将有序数组转换为二叉搜索树
 *
 * 给你一个整数数组 nums ，其中元素已经按 升序 排列，请你将其转换为一棵 平衡 二叉搜索树。
 * 提示：
 * * 1 <= nums.length <= 104
 * * -104 <= nums[i] <= 104
 * * nums 按 严格递增 顺序排列
 *
 * 链接：https://leetcode.cn/problems/convert-sorted-array-to-binary-search-tree/
 */

public class T108 {

    public TreeNode sortedArrayToBST(int[] nums) {
        return re(nums,0,nums.length-1);
    }


    public TreeNode re(int[] nums,int left,int right){
        if (left>right) return null;
        int mid = (left+right)/2;
        TreeNode root = new TreeNode(nums[mid]);
        root.left = re(nums,left,mid-1);
        root.right = re(nums,mid+1,right);
        return root;
    }

    public static void main(String[] args) {

    }
}