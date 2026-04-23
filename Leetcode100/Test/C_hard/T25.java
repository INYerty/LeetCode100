package Test.C_hard;

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
