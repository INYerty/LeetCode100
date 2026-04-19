package Test.B_medium;

import java.util.ArrayDeque;
import java.util.Queue;

public class T189 {
    public void rotate(int[] nums, int k) {
        int n = nums.length;
        k = k % n;
        Queue<Integer> queue = new ArrayDeque<>();
        for (int i = n - k; i < n; i++) {
            queue.add(nums[i]);
        }
        for (int i = 0; i < n - k; i++) {
            queue.add(nums[i]);
        }
        int i = 0;
        while (!queue.isEmpty()) {
            nums[i++] = queue.poll();
        }
    }

    public static void main(String[] args) {
        T189 t = new T189();
        int[] nums = {1,2,3,4,5,6,7};
        t.rotate(nums, 3);
    }

}

