package Test.B_medium;

import java.util.HashMap;

public class T138 {
    public Node copyRandomList(Node head) {
        HashMap<Node, Node> nodeNodeHashMap = new HashMap<>();
        // 拷贝节点
        for (Node node = head; node !=null ; node = node.next){
            nodeNodeHashMap.put(node, new Node(node.val));
        }
        // 拷贝next指针以及random指针
        for(Node node = head; node !=null;node = node.next){
            if (node.next!=null) {
                nodeNodeHashMap.get(node).next = nodeNodeHashMap.get(node.next);
            }
            if (node.random!=null) {
                nodeNodeHashMap.get(node).random = nodeNodeHashMap.get(node.random);
            }
        }
        return nodeNodeHashMap.get(head);
    }
}
