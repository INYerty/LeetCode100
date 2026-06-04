package Test.B_medium;

import java.util.*;

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
