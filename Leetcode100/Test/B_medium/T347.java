package Test.B_medium;

import java.util.*;
/**
 * 347. 前 K 个高频元素
 *
 * 给你一个整数数组 nums 和一个整数 k ，请你返回其中出现频率前 k 高的元素。你可以按 任意顺序 返回答案。
 * 提示：
 * * 1 <= nums.length <= 105
 * * -104 <= nums[i] <= 104
 * * k 的取值范围是 [1, 数组中不相同的元素的个数]
 * * 题目数据保证答案唯一，换句话说，数组中前 k 个高频元素的集合是唯一的
 * 进阶：你所设计算法的时间复杂度 必须 优于 O(n log n) ，其中 n 是数组大小。
 *
 * 链接：https://leetcode.cn/problems/top-k-frequent-elements/
 */

public class T347 {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer,Integer> map = new HashMap<>();
        if(nums.length == 0) return new int[]{};
        for(int i:nums){
            if(map.containsKey(i)){
                map.put(i,map.get(i)+1);
            }else{
                map.put(i,1);
            }
        }
        PriorityQueue<int[]> queue = new PriorityQueue<int[]>(new Comparator<int[]>() {
            public int compare(int[] m, int[] n) {
                return m[1] - n[1];
            }
        });

        for(Map.Entry<Integer,Integer> entry:map.entrySet()){
            int num = entry.getKey();
            int count = entry.getValue();

            if(queue.size() == k){
                if (queue.peek() != null && count > queue.peek()[1]) {
                    queue.poll();
                    queue.offer(new int[]{num,count});
                }
            }else{
                queue.offer(new int[]{num,count});
            }
        }

        int[] res = new int[k];
        for (int i = 0; i < k; i++) {
            res[i] = Objects.requireNonNull(queue.poll())[0];
        }
        return res;
    }
}