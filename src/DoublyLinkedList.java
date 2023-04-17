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
    public Node<T> insert(int position, Album data) {
        Node<T> toInsertNode = new Node<T>(data);

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
            // Condition: if requested position is 0 and the list is not empty
            // Add node to the head of the list
            else if (position == 0 && this.head != null) {
                this.head.prev = toInsertNode;
                toInsertNode.next = this.head;
                this.head = toInsertNode;
                numNode++;
            }

            // Condition: if requested position is smaller than total node number
            // Add node to the middle of the list
            else if (position < numNode && this.head != null) {
                int count = 0; // or int count = 0
                Node<T> currentNode = this.head;
                //Node<T> after_node = this.head.next;
                while (count < position && currentNode.next != null) {
                    currentNode = currentNode.next;
                    count++;
                }
                if ((count + 1) != position) {
                    return this.append(data);
                }
                else if (count != position) {
                    throw IAe;
                } else {
                    toInsertNode.next = currentNode;
                    toInsertNode.prev = currentNode.prev;
                    currentNode.prev.next = toInsertNode;
                    currentNode.prev = toInsertNode;
                    numNode++;
                }
            }
            else {
                int pos = 0;
                Node<T> current = this.head;
                while (pos < position && current.next != null) {
                    current = current.next;
                    pos++;
                }
//                if ((pos+1)==position) {
//                    return this.append(data);
//                }
            }
        }
        // return the inserted node
        return toInsertNode;
    }

}
