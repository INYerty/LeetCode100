package Test.A_easy;

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
