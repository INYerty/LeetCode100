package Test.daily_question.B_medium;


import java.util.Deque;
import java.util.LinkedList;

public class T2161 {
    public int[] pivotArray(int[] nums, int pivot) {
        Deque<Integer> dq = new LinkedList<>();

        for (int i = 0; i < nums.length; i++) {
            if(nums[i] < pivot){
                dq.addFirst(nums[i]);
            } else if (nums[i] == pivot) {
                dq.add(nums[i]);
            } else if (nums[i] > pivot) {
                dq.add(nums[i]);
            }
        }
        return dq.stream().mapToInt(Integer::intValue).toArray();
    }
}
