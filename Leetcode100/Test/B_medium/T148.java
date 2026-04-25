package Test.B_medium;

public class T148 {

    public ListNode sortList(ListNode head) {
/*        暴力解法
        ListNode dummy = new ListNode(Integer.MIN_VALUE);
        dummy.next = head;
        ListNode pre = dummy;
        ListNode left = pre;
        ListNode right = left.next;
        ListNode run = right;

        int count = 0;

        while (run!=null){
            run = run.next;
            count++;
        }

        for(int i = 0 ; i < count; i++){
            while (right!=null){
                if (left.val>right.val){
                    ListNode tmp1 = right.next;
                    ListNode tmp2 = pre.next;
                    pre.next = right;
                    right.next = tmp2;
                    tmp2.next = tmp1;
                }
                pre = left;
                left = right;
                right = right.next;
            }
            pre = dummy;
            left = pre;
            right = left.next;
        }


        return dummy.next;*/

        // 终止条件：如果是空链表或只有一个节点，直接返回
        if (head == null || head.next == null) return head;
        //快慢指针找中点
        ListNode slow = head;
        ListNode fast = head;
        ListNode mid = null;
        while(fast!=null&&fast.next!=null){
            mid = slow;
            slow = slow.next;
            fast = fast.next.next;
        }
        //断开
        mid.next = null;


        // 3. 递归排序左右两段
        ListNode left = sortList(head);
        ListNode right = sortList(slow);


        return merge(left,right);

    }

    ListNode merge (ListNode l1,ListNode l2){
        ListNode dummy = new ListNode(0);
        ListNode curr = dummy;
        while (l1!=null&&l2!=null){
            if (l1.val>l2.val){
                curr.next = l2;
                l2 = l2.next;
            }else{
                curr.next = l1;
                l1 = l1.next;
            }
            curr = curr.next;
            curr.next = (l1!=null)?l1:l2;
        }

        return dummy.next;
    }

    public static void main(String[] args) {
        T148 t148 = new T148();

        ListNode l1 = new ListNode(4);
        l1.next = new ListNode(2);
        l1.next.next = new ListNode(1);
        l1.next.next.next = new ListNode(3);

        ListNode result = t148.sortList(l1);

        // 4. 打印结果
        System.out.print("Result: ");
        printList(result);
    }

    public static void printList(ListNode node) {
        while (node != null) {
            System.out.print(node.val + (node.next != null ? " -> " : ""));
            node = node.next;
        }
        System.out.println();
    }
}
