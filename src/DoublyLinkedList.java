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

        try {
            // Condition: if the position requested is equal to the total node number,
            // meaning the end of the list
            if (position < 0 || position > numNode) {
                throw new IllegalArgumentException("Position requested is out of the bounds of the list");
            }
            if (position == numNode) {

                // Start a node, if list is null
                if (this.head == null) {
                    this.head = toInsertNode;
                    this.tail = toInsertNode;
                }
                // Add node to the end of list, if list is not null
                else {
                    this.tail.next = toInsertNode;
                    toInsertNode.prev = this.tail;
                    this.tail = toInsertNode;
                }
                numNode++;
            }

            // Condition: if the position requested is the head of the list.
            else if (position == 0) {

                // Start a node, if list is empty
                if (this.head == null) {
                    this.head = toInsertNode;
                    this.tail = toInsertNode;
                }
                // Add node to the head of list, if list is not empty
                else {
                    this.head.prev = toInsertNode;
                    toInsertNode.next = this.head;
                    this.head = toInsertNode;
                }
                numNode++;
            }
            // Condition: if requested position is smaller than total node number
            // Add node to the middle of the list
            else if (position < numNode && numNode != 0) {
                int count = 0;
                // Initialize a new head pointer for the list
                Node<T> current = this.head;
                Node<T> after_node = this.head.next;
                while (count < position) {
                    current = current.next;
                    count++;
                }
                toInsertNode.prev = current.prev;
                toInsertNode.next = current;
                current.prev.next = toInsertNode;
                current.prev = toInsertNode;
                numNode++;
            }

        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException("Position requested is out of the bounds of the list");
        }
        return toInsertNode;
    }

    @Override
    public String toString(){
        Node<T> toPrint = this.head;

        StringBuilder stringBuilder = new StringBuilder();

        while(toPrint != null){
            stringBuilder.append(toPrint.data);
            stringBuilder.append("->");
            toPrint = toPrint.next;
        }

        stringBuilder.append("NULL");
        return stringBuilder.toString();
    }
}
