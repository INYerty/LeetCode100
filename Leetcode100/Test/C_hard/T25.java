package Test.C_hard;
/**
 * 25. K 个一组翻转链表
 *
 * 给你链表的头节点 head ，每 k 个节点一组进行翻转，请你返回修改后的链表。
 * k 是一个正整数，它的值小于或等于链表的长度。如果节点总数不是 k 的整数倍，那么请将最后剩余的节点保持原有顺序。
 * 你不能只是单纯的改变节点内部的值，而是需要实际进行节点交换。
 * 提示：
 * * 链表中的节点数目为 n
 * * 1 <= k <= n <= 5000
 * * 0 <= Node.val <= 1000
 * 进阶：你可以设计一个只用 O(1) 额外内存空间的算法解决此问题吗？
 *
 * 链接：https://leetcode.cn/problems/reverse-nodes-in-k-group/
 */

public class T25 {
    public static void main(String[] args) {
        T25 t25 = new T25();

        ListNode l1 = new ListNode(1);
        l1.next = new ListNode(2);
        l1.next.next = new ListNode(3);
        l1.next.next.next = new ListNode(4);

        ListNode result = t25.reverseKGroup(l1, 3);

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

    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode pre = dummy;
        while (true) {

            ListNode run = pre;

            for (int steps = 0; steps < k; steps++) {
                run = run.next;
                if (run == null) {
                    return dummy.next;
                }
            }

            ListNode groupStart = pre.next;
            ListNode nextGroupStart = run.next;
            ListNode prev = null;//代表反转时前一个结点
            ListNode cur = pre.next;

            while(cur!=nextGroupStart){
                ListNode temp = cur.next;
                cur.next = prev;
                prev = cur;
                cur = temp;
            }

            groupStart.next = nextGroupStart;
            pre.next = prev;
            pre = groupStart;

        }
    }
}