package Test.B_medium;

public class T34 {
    public int[] searchRange(int[] nums, int target) {
        int leftSite = binarySearch(nums,target,true);
        int rightSite = binarySearch(nums,target,false);
        return new int[] {leftSite,rightSite};
    }

    // 寻找左边界
    public int binarySearch(int[] nums,int target,boolean isLeft){
        int left = 0,right = nums.length-1;
        int index = -1;
        while(left<=right){
            int mid = (left+right)/2;
            if (target>nums[mid]){
                left = mid+1;
            } else if (target<nums[mid]) {
                right = mid-1;
            }else{
                index = mid;
                if(isLeft){
                    right = mid-1;
                }else{
                    left = mid+1;
                }
            }
        }
        return index;
    }

}
