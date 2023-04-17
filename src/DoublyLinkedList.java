public class DoublyLinkedList<T> {

    Node<T> head;
    Node<T> prev;
    Node<T> tail;

    int numNode = 0;

    public DoublyLinkedList() {
        this.head = null;
        this.prev= null;
        this.tail = null;
    }

    // Should run in O(1) time
    public Node<T> append(Album data) {
        Node<T> node = new Node<T>(data);
        if (this.head == null) {
            this.head = node;
            this.tail = node;
        } else {
            this.tail.next = node;
            this.tail.next.prev = this.tail;
            //node.prev = this.tail; - same as above
        }
        this.tail = node;
        this.tail.next = null;
        numNode += 1;
        // return the appended node
        return node;
    }

    // insert at that point in the list (0 is the head, 1 is right after the head)
    public Node<T> insert(int position, Album album1) {
        Node<T> toInsertNode = new Node<T>(album1);

        // throw an IllegalArgumentException if location is out of the bounds of the list
        IllegalArgumentException IAe = new IllegalArgumentException
                ("Position Out of Bounds of Doubly Linked List");

        // Condition: if the list is null but a node position requested
        if (head == null && position != 0) {
            throw IAe;
        }

        // Condition: if the position requested is higher than the total node number
        // Condition: if the position requested is less than 0
        if (position > numNode || position < 0) {
            throw IAe;
        }
        else {
            // Condition: if the list is null
            // Start a list
            if (this.head == null && position == 0) {
                //toInsert.next = head;
                //head.prev = toInsert;
                this.head = toInsertNode;
                this.tail = toInsertNode;
                numNode++;
            }
            // Condition: if requested position is 0 and total node number is not 0
            // Add node to the head of the list
            else if (position == 0 && this.head != null) {
                this.head.prev = toInsertNode;
                toInsertNode.next = this.head;
                this.head = toInsertNode;
                numNode++;
            }
            // add to the middle of the list
            else if (position < numNode && this.head != null) {
                int count = 1;
                Node<T> pre_node = this.head;
                Node<T> after_node = this.head.next;
                while (count < position) {
                    pre_node = after_node;
                    after_node = after_node.next;
                }
                pre_node.next = toInsertNode;
                pre_node.next.prev = pre_node;
                pre_node.next.next = after_node;
                pre_node.next.next.prev = toInsertNode;
                numNode++;
            }
            else {
                int pos = 0;
                Node<Album> current = this.head;
                while (pos < position && current.next != null) {
                    current = current.next;
                    pos++;
                }
                if ((pos+1)==position) {
                    return this.append(album1);
                }
            }
        }
        // return the inserted node
        return toInsertNode;
    }

}
