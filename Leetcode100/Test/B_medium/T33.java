package Test.B_medium;

public class T33 {
    /**
    旋转将此数组分成了两个单调递增的区间，我们需要判断。mid指针落到了哪一个区间上，那就自然分成了两种情况，第一种是落到了第一个单增区间上，此时`nums[left]`<=`nums[right]`的，这时候判断target在不在这个区间上，那么用target比较边界的最大最小值就行了，如果在，更新right指针，缩小一个位，`right=mid-1`，直至找到target；如果不在这个区间。我们要从`[mid,right]`区间找target，那就更新left=mid+1。如果mid落在了第二个单增区间上，先判断target在不在`[mid.right]` 这个单增区间上，如果在，我们更新左指针`left = mid+1`如果不在，说明target落在了`[left,mid]` 上,更新右指针`right = mid-1`。 */
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
}