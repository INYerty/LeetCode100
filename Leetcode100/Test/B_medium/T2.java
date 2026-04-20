package Test.B_medium;

public class T2 {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode resultHead = new ListNode(0);
        ListNode resultCur = resultHead;
        int sub = 0;


        while(l1!=null||l2!=null||sub!=0) { //如果两者一样长
            int v1 = (l1 != null) ? l1.val : 0;
            int v2 = (l2 != null) ? l2.val : 0;

            int sum = v1 + v2 + sub;
            resultCur.val = sum % 10; // 取个位
            sub = sum / 10;

            if ((l1 != null && l1.next != null) || (l2 != null && l2.next != null) || sub != 0) {
                resultCur.next = new ListNode(0);
            }


            if (l1 != null) {
                // 如果 l1 没了但 l2 还有或者有进位，为了维持循环，我们虚拟补 0
                if (l1.next == null && (l2 != null && l2.next != null || sub != 0)) {
                    l1.next = new ListNode(0);
                }
                l1 = l1.next;
            }

            if (l2 != null) {
                if (l2.next == null && (l1 != null || sub != 0)) {
                    l2.next = new ListNode(0);
                }
                l2 = l2.next;
            }

            resultCur = resultCur.next;
        }


        return resultHead;

    }

    public static void main(String[] args) {
        T2 t2 = new T2();

        // 1. 构建第一个链表：9 -> 9 -> 9 (表示数字 999)
        ListNode l1 = new ListNode(9);
        l1.next = new ListNode(9);
        l1.next.next = new ListNode(9);

        // 2. 构建第二个链表：1 (表示数字 1)
        ListNode l2 = new ListNode(1);

        // 3. 执行相加
        ListNode result = t2.addTwoNumbers(l1, l2);

        // 4. 打印结果
        System.out.print("Result: ");
        printList(result);
        // 预期输出: 0 -> 0 -> 0 -> 1 (表示数字 1000)
    }

    public static void printList(ListNode node) {
        while (node != null) {
            System.out.print(node.val + (node.next != null ? " -> " : ""));
            node = node.next;
        }
        System.out.println();
    }


}

