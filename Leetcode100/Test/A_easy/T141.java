package Test.A_easy;
/**
 * 141. 环形链表
 *
 * 给你一个链表的头节点 head ，判断链表中是否有环。
 * 如果链表中有某个节点，可以通过连续跟踪 next 指针再次到达，则链表中存在环。
 * 为了表示给定链表中的环，评测系统内部使用整数 pos 来表示链表尾连接到链表中的位置（索引从 0 开始）。注意：pos 不作为参数进行传递 。
 * 仅仅是为了标识链表的实际情况。
 * 如果链表中存在环 ，则返回 true 。 否则，返回 false 。
 * 提示：
 * * 链表中节点的数目范围是 [0, 104]
 * * -105 <= Node.val <= 105
 * * pos 为 -1 或者链表中的一个 有效索引 。
 * 进阶：你能用 O(1)（即，常量）内存解决此问题吗？
 *
 * 链接：https://leetcode.cn/problems/linked-list-cycle/
 */

public class T141 {
    public boolean hasCycle(ListNode head) {
//        HashSet<ListNode> map = new HashSet<>();
//        while(head!=null){
//            if(map.contains(head)){
//                return true;
//            }
//            map.add(head);
//            head = head.next;
//        }
//        return false;

        ListNode fast = head;
        ListNode slow = head;

        while(fast != null && fast.next != null){
            fast = fast.next.next;
            slow = slow.next;
            if(fast == slow){
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        T141 t141 = new T141();
    }
}