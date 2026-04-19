package Test.A_easy;

public class T160 {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if(headA == null || headB == null) return null;
        ListNode pA = headA, pB = headB;
        // 在这里第一轮体现在pA和pB第一次到达尾部会移向另一链表的表头, 而第二轮体现在如果pA或pB相交就返回交点, 不相交最后就是null==null
        while(pA != pB) {
            pA = pA == null ? headB : pA.next;
            pB = pB == null ? headA : pB.next;
        }
        return pA;
    }

    public static void main(String[] args) {
        T160 t = new T160();
        //定义链表listA =[4,1,8,4,5]
        ListNode a = new ListNode(4);
        a.next = new ListNode(1);
        a.next.next = new ListNode(8);
        a.next.next.next = new ListNode(4);
        a.next.next.next.next = new ListNode(5);

        //定义链表listB =[5,0,1,8,4,5]
        ListNode b = new ListNode(5);
        b.next = new ListNode(0);
        b.next.next = new ListNode(1);
        b.next.next.next = new ListNode(8);
        b.next.next.next.next = new ListNode(4);
        b.next.next.next.next.next = new ListNode(5);



        //打印链表所有元素
        System.out.print("链表1：");
        while (a != null) {
            System.out.print(a.val + " ");
            a = a.next;
        }
        System.out.println();
        System.out.print("链表2：");
        while (b != null) {
            System.out.print(b.val + " ");
            b = b.next;
        }
        System.out.println(t.getIntersectionNode(a, b));
    }
}
