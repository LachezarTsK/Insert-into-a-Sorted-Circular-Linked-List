
public class Solution {

    public Node insert(Node head, int insertValue) {

        if (head == null) {
            head = new Node(insertValue);
            head.next = head;
            return head;
        }

        Node current = head.next;
        Node previous = head;

        while (true) {

            //insert position is between regular nodes in the list.
            if (insertValue >= previous.val && insertValue <= current.val) {
                previous.next = new Node(insertValue, current);
                break;
            }

            //insert position is between nodes with max and min value.
            if ((previous.val > current.val) && (insertValue >= previous.val || insertValue <= current.val)) {
                previous.next = new Node(insertValue, current);
                break;
            }

            //all nodes have the same value, which is different from the insert value.
            if (current == head) {
                previous.next = new Node(insertValue, current);
                break;
            }
            previous = current;
            current = current.next;
        }
        return head;
    }

}

class Node {

    public int val;
    public Node next;

    public Node() {
    }

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _next) {
        val = _val;
        next = _next;
    }
};
