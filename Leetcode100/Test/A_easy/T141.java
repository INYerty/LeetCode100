package Test.A_easy;

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
