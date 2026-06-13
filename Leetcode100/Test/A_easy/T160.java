package Test.A_easy;
/**
 * 160. 相交链表
 *
 * 给你两个单链表的头节点 headA 和 headB ，请你找出并返回两个单链表相交的起始节点。如果两个链表不存在相交节点，返回 null 。
 * 图示两个链表在节点 c1 开始相交：
 * [https://assets.leetcode.cn/aliyun-lc-upload/uploads/2018/12/14/160_stateme
 * nt.png] [https://assets.leetcode.cn/aliyun-lc-upload/uploads/2018/12/14/160
 * _statement.png]
 * 题目数据 保证 整个链式结构中不存在环。
 * 注意，函数返回结果后，链表必须 保持其原始结构 。
 * 自定义评测：
 * 评测系统 的输入如下（你设计的程序 不适用 此输入）：
 * * intersectVal - 相交的起始节点的值。如果不存在相交节点，这一值为 0
 * * listA - 第一个链表
 * * listB - 第二个链表
 * * skipA - 在 listA 中（从头节点开始）跳到交叉节点的节点数
 * * skipB - 在 listB 中（从头节点开始）跳到交叉节点的节点数
 * 评测系统将根据这些输入创建链式数据结构，并将两个头节点 headA 和 headB 传递给你的程序。
 * 如果程序能够正确返回相交节点，那么你的解决方案将被 视作正确答案 。
 * 提示：
 * * listA 中节点数目为 m
 * * listB 中节点数目为 n
 * * 1 <= m, n <= 3 * 104
 * * 1 <= Node.val <= 105
 * * 0 <= skipA <= m
 * * 0 <= skipB <= n
 * * 如果 listA 和 listB 没有交点，intersectVal 为 0
 * * 如果 listA 和 listB 有交点，intersectVal == listA[skipA] == listB[skipB]
 * 进阶：你能否设计一个时间复杂度 O(m + n) 、仅用 O(1) 内存的解决方案？
 *
 * 链接：https://leetcode.cn/problems/intersection-of-two-linked-lists/
 */

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