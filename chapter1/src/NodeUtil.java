import java.util.HashSet;
import java.util.Set;

public class NodeUtil {

    public static Node generate(int n, boolean cycle){
        Node first = null;
        Node last = null;
        for(int i = 0; i < n; i++){
            if (last == null) {
                first = new Node(i);
                last = first;
            } else {
                last.next = new Node(i);
                last = last.next;
            }
        }
        if (cycle){
            last.next = first;
        }
        return first;
    }


    public static String printNode(Node node){
        if (node != null){
            return node.val + " -> " + printNode(node.next);
        }
        return null;
    }




    public static Node reverse(Node node){
        Node prev = null;
        Node curr = node;
        while (curr != null){
            Node next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }


    public static void iterate(Node node, int m){
        int index = 0;
        Node curr = node;
        Node prev = findPrev(node);
        while (true){
            if (index++ == m){
                //remove current node
                index = 0;
                System.out.println("node with val: " + curr.val + " was removed!");
                prev.next = curr.next;
            }else {
                prev = curr;
            }
            curr = curr.next;
        }
    }

    public static int lengthOfNodes(Node node){
        if(node != null){
            int len = 1;
            Node next = node.next;
            while (next != null){
                if (next == node){
                    break;
                }
                len ++;
                next = next.next;
            }
        }
        return 0;
    }

    //寻找环形单向链表的上一个节点
    public static Node findPrev(Node node){
        if (node != null){
            Node curr = node;
            Node next = node.next;
            while (next != null){
                if (next != node){
                    curr = next;
                    next = next.next;
                }else {
                    return curr;
                }
            }
        }

        return null;
    }
}
