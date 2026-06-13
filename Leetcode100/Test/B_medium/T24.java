package Test.B_medium;

import java.util.List;
/**
 * 24. 两两交换链表中的节点
 *
 * 给你一个链表，两两交换其中相邻的节点，并返回交换后链表的头节点。你必须在不修改节点内部的值的情况下完成本题（即，只能进行节点交换）。
 * 提示：
 * * 链表中节点的数目在范围 [0, 100] 内
 * * 0 <= Node.val <= 100
 *
 * 链接：https://leetcode.cn/problems/swap-nodes-in-pairs/
 */

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