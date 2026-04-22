package Test.B_medium;

import java.util.List;

public class T24 {
    public ListNode swapPairs(ListNode head) {
        // 建立哨兵节点  始终不参与移动 仅仅是最后返回完整链表的作用
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode pre = dummy;  //移动用的指针

        while(pre.next!=null&&pre.next.next!=null){
            ListNode left = pre.next;
            ListNode right = pre.next.next;

            //交换链表两个节点的顺序
            pre.next = right;
            left.next = right.next;
            right.next = left;


            pre = left;
        }
        return dummy.next;

    }

    public static void main(String[] args) {
        T24 t24 = new T24();

        ListNode l1 = new ListNode(1);
        l1.next = new ListNode(2);
        l1.next.next = new ListNode(3);
        l1.next.next.next = new ListNode(4);

        ListNode result = t24.swapPairs(l1);

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
