
/**
 * @param {Node} head
 * @param {number} insertVal
 * @return {Node}
 */
var insert = function (head, insertValue) {
    if (head === null) {
        head = new Node(insertValue);
        head.next = head;
        return head;
    }

    let current = head.next;
    let previous = head;

    while (true) {

        //insert position is between  regular nodes in the list.
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
        if (current === head) {
            previous.next = new Node(insertValue, current);
            break;
        }
        previous = current;
        current = current.next;
    }

    return head;
};


function Node(val, next) {
    this.val = val;
    this.next = next;
}
