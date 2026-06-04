package Test.B_medium;


import java.util.Comparator;
import java.util.PriorityQueue;

public class T215 {

    // 大顶堆
    /*void heapify(int[] nums,int n,int root){
        int largest = root;
        int lson = root * 2 + 1;
        int rson = root * 2 + 2;
        if(lson < n && nums[largest] < nums[lson]){
            largest = lson;
        }
        if (rson < n && nums[largest] < nums[rson]){
            largest = rson;
        }
        // 发生了变化 ，我们要swap
        if (largest != root) {
            // 交换nums[largest] 与 nums[root]
            swap(nums, largest, root);
            // 递归他们的孩子 是否也符合大顶堆
            heapify(nums, n, largest);
        }
    }*/

    void heapify(int[] nums,int n,int root){
        int less = root;
        int lson = root * 2 + 1;
        int rson = root * 2 + 2;
        if(lson < n && nums[less] > nums[lson]){
            less = lson;
        }
        if (rson < n && nums[less] > nums[rson]){
            less = rson;
        }
        // 发生了变化 ，我们要swap
        if (less != root) {
            // 交换nums[less] 与 nums[root]
            swap(nums, less, root);
            // 递归他们的孩子 是否也符合小顶堆
            heapify(nums, n, less);
        }
    }

    // 堆排序 n是堆的大小
    void heap_sort(int[] nums,int n){
        int i;
        // 建堆
        // 这里的n是数组大小  for用的是下标 因此-1
        for(i = (n-1-1)/2;i>=0;i--){
            heapify(nums, n, i);
        }

        // 排序
        for (int j = n-1; j > 0 ; j--) {
            swap(nums, j,0);
            heapify(nums, j, 0);
        }
    }

    // 交换方法
    void swap(int[] arr,int i,int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

/*    public static void main(String[] args) {
        T215 t = new T215();
        int[] nums = {2,3,8,1,4,9,10,7,16,14};
        t.heap_sort(nums,nums.length);
        System.out.println(Arrays.toString(nums));
    }*/


    public int findKthLargest(int[] nums, int k) {
        // 暴力  排序
/*        Arrays.sort(nums);
        return nums[nums.length - k];*/

        // 最小堆排序
        /*heap_sort(nums, nums.length);
        return nums[k];*/

        // 维护K大小的小顶堆
        /*for (int i = k/2 - 1; i >= 0; i--) {
            heapify(nums, k, i);
        }

        // 剩下的元素
        for (int i = k; i < nums.length; i++) {
            if (nums[i] > nums[0]){
                nums[0] = nums[i];
                heapify(nums, k, 0);
            }
        }
        return nums[0];*/

        // 优先级队列 (大顶堆)
        PriorityQueue<Integer> pq = new PriorityQueue<>(
                // 匿名内部类
                new Comparator<Integer>() {
                    @Override
                    public int compare(Integer o1, Integer o2) {
                        return o2 - o1;
                    }
                }
        );
        for(int i = 0;i<nums.length;i++){
            pq.offer(nums[i]);
        }
        int res = 0;
        for (int i = 0; i < k; i++) {
            if (!pq.isEmpty()){
                res= pq.poll();
            }
        }
        return res;
    }
}
