package Test.C_hard;

import java.util.Comparator;
import java.util.PriorityQueue;
/**
 * 295. 数据流的中位数
 *
 * 中位数是有序整数列表中的中间值。如果列表的大小是偶数，则没有中间值，中位数是两个中间值的平均值。
 * * 例如 arr = [2,3,4] 的中位数是 3 。
 * * 例如 arr = [2,3] 的中位数是 (2 + 3) / 2 = 2.5 。
 * 实现 MedianFinder 类:
 * * MedianFinder() 初始化 MedianFinder 对象。
 * * void addNum(int num) 将数据流中的整数 num 添加到数据结构中。
 * * double findMedian() 返回到目前为止所有元素的中位数。与实际答案相差 10-5 以内的答案将被接受。
 * 提示:
 * * -105 <= num <= 105
 * * 在调用 findMedian 之前，数据结构中至少有一个元素
 * * 最多 5 * 104 次调用 addNum 和 findMedian
 *
 * 链接：https://leetcode.cn/problems/find-median-from-data-stream/
 */

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