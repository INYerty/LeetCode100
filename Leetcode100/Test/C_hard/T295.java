package Test.C_hard;

import java.util.Comparator;
import java.util.PriorityQueue;

public class T295 {
    // 暴力解法 超时
/*    class MedianFinder {
        PriorityQueue<Integer> pq = null;
        public MedianFinder() {
            pq = new PriorityQueue<>(
                    new Comparator<Integer>() {
                        @Override
                        public int compare(Integer o1, Integer o2) {
                            return o1-o2;
                        }
                    }
            );
        }

        public void addNum(int num) {
            pq.offer(num);
        }

        public double findMedian() {
            int length = pq.size();
            int[] arr = new int[length];
            PriorityQueue<Integer> temp = pq;
            for(int i = 0;i<length;i++){
                if (!pq.isEmpty()){
                    arr[i] = temp.poll();
                }
            }
            if (length%2 ==0){
                return (double) (arr[length / 2-1] + arr[length / 2 ]) /2;
            }else{
                return arr[length / 2];
            }
        }
    }*/

    // 双堆
    class MedianFinder {

        private PriorityQueue<Integer> right =new PriorityQueue<>();
        private PriorityQueue<Integer> left = new PriorityQueue<>((a,b)->b-a);
        public void addNum(int num) {
            if(left.size() == right.size()){
                right.offer(num);
                left.offer(right.poll());
            }else{
                left.offer(num);
                right.offer(left.poll());
            }
        }

        public double findMedian() {
            if (left.size()>right.size()){
                return left.peek();
            }
            return (double) (left.peek() + right.peek()) /2;
        }
    }
}
