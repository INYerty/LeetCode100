package Test.A_easy;

public class T35 {
    public int searchInsert(int[] nums, int target) {
        return binarySearch(nums,0,nums.length-1,target);
    }

    public int binarySearch(int[] nums,int left,int right,int target){
        if (left > right) {
            return left; // 找不到时，left 就是插入位置
        }
        int mid = (left+right)/2;
        if (target>nums[mid]){
            return binarySearch(nums,mid+1,right,target);
        }
        if (target<nums[mid]){
            return binarySearch(nums,left,mid-1,target);
        }else{
            return mid;
        }
    }
}
