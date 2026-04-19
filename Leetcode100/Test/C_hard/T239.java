package Test.C_hard;
import java.util.Deque;
import java.util.LinkedList;

public class T239 {
    public int[] maxSlidingWindow(int[] nums, int k) {
/*        // 滑动窗口大小
        int[] res = new int[nums.length-k+1];
        // 暴力解法：每个窗口都遍历一次，时间复杂度 O(n*k)
        for(int i=0;i<=nums.length-k;i++){
            int max = Integer.MIN_VALUE;
            for(int j=i;j<i+k;j++){
                max = Math.max(max, nums[j]);
            }
            res[i] = max;
        }
        return res;*/
        //单调队列解法
        int[] res = new int[nums.length-k+1];
        Deque<Integer> deque = new LinkedList<>();
        for (int i = 0; i < nums.length; i++) {
            if (i >= k && !deque.isEmpty() && deque.getFirst() == nums[i - k]) {
                deque.removeFirst();
            }
            while (!deque.isEmpty() && deque.getLast() < nums[i]) {
                deque.removeLast();
            }
            deque.addLast(nums[i]);
            if(i-k+1>=0){
                res[i-k+1] = deque.getFirst();
            }
        }
        return res;
    }


    public static void main(String[] args) {
        T239 t = new T239();
        int[] nums = {1,3,-1,-3,5,3,6,7};
        int[] ints = t.maxSlidingWindow(nums, 3);
        for (int anInt : ints) {
            System.out.println(anInt);
        }

    }
}
