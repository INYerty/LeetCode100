package Test.B_medium;
/**
 * 33. 搜索旋转排序数组
 *
 * 整数数组 nums 按升序排列，数组中的值 互不相同 。
 * 在传递给函数之前，nums 在预先未知的某个下标 k（0 <= k < nums.length）上进行了 向左旋转，使数组变为 [nums[k], n
 * ums[k+1], ..., nums[n-1], nums[0], nums[1], ..., nums[k-1]]（下标 从 0 开始 计数）。
 * 例如， [0,1,2,4,5,6,7] 下标 3 上向左旋转后可能变为 [4,5,6,7,0,1,2] 。
 * 给你 旋转后 的数组 nums 和一个整数 target ，如果 nums 中存在这个目标值 target ，则返回它的下标，否则返回 -1 。
 * 你必须设计一个时间复杂度为 O(log n) 的算法解决此问题。
 * 提示：
 * * 1 <= nums.length <= 5000
 * * -104 <= nums[i] <= 104
 * * nums 中的每个值都 独一无二
 * * 题目数据保证 nums 在预先未知的某个下标上进行了旋转
 * * -104 <= target <= 104
 *
 * 链接：https://leetcode.cn/problems/search-in-rotated-sorted-array/
 */

public class T33 {
    /**
    旋转将此数组分成了两个单调递增的区间，我们需要判断。mid指针落到了哪一个区间上，那就自然分成了两种情况，第一种是落到了第一个单增区间上，此时`nums[left]`<=`nums[mid]`的，这时候判断target在不在这个区间上，那么用target比较边界的最大最小值就行了，如果在，更新right指针，缩小一个位，`right=mid-1`，直至找到target；如果不在这个区间。我们要从`[mid,right]`区间找target，那就更新left=mid+1。如果mid落在了第二个单增区间上，先判断target在不在`[mid.right]` 这个单增区间上，如果在，我们更新左指针`left = mid+1`如果不在，说明target落在了`[left,mid]` 上,更新右指针`right = mid-1`。 */
    public int search(int[] nums, int target) {
        int left = 0,right = nums.length-1;
        while(left<=right){

            int mid = (left+right)/2;
            if(nums[mid] == target){
                return mid;
            }

            //如果不相等,那么判断落到了第一个单调递增的区间还是第二个单调递增的区间
            //如果落到了第一个单调递增的区间 那么更新左指针的值 right = mid - 1
            if(nums[left] <= nums[mid]){
                if(nums[left] <= target && target< nums[mid]){
                    right = mid - 1;
                }else{
                    left = mid + 1;
                }
            }else{
                //如果落到了第二个单调递增区间 那么更新有指针的值 left = mid + 1;
                if(target>nums[mid] && target<=nums[right]){
                    left = mid + 1;
                }else{
                    right = mid - 1;
                }
            }
        }
        return -1;
    }


    /*  二刷
    *     public int search(int[] nums,int target){
        // k 分成了两个单调递增区间 ，即一个是0，k  还有k，n-1
        // 我们算出mid 他只会调到这两个区间的其中一个区间里面。
        // 假设掉到了第一个区间里面
        int left = 0;
        int right = nums.length -1;
        while(left<=right){
            int mid = (left + right)/2;
            if(nums[mid] == target) return mid;
            // 假设掉到了第一个区间里面
            if(nums[left] <= nums[mid]){
                if(target>=nums[left] && target<nums[mid]){
                    //如果在单增区间
                    right = mid - 1;
                }else{
                    // 不在，就去mid+1到right找
                    left = mid + 1;
                }
            }
            if(nums[mid] <= nums[right]){
                if(target>nums[mid] && target<=nums[right]){
                    // 如果在第二个单增区间
                    left = mid + 1;
                }else{
                    right = mid - 1;
                }
            }
        }
        return -1;
    }*/
}