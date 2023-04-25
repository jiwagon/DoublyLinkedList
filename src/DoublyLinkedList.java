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

    public Node<T> delete(int location) {

        // Throw an IllegalArgumentException if it doesn't exist
        if (location < 0 || location >= numNode) {
            throw new IllegalArgumentException("Position requested is out of the bounds of the list");
        }

        Node<T> deletedNode;

        // Delete the item at that location (delete 0 deletes the head)
        // Condition: if deleting the head node
        if (location == 0) {
            deletedNode = this.head;
            this.head = this.head.next;
            if (this.head != null) {
                this.head.prev = null;
            } else {
                this.tail = null;
            }
        }

        // Condition: if deleting the tail node
        else if (location == numNode - 1) {
            deletedNode = this.tail;
            this.tail = this.tail.prev;
            if (this.tail != null) {
                this.tail.next = null;
            } else {
                this.head = null;
            }
        }

        // Condition: if deleting a node in the middle of the list
        else {
            int count = 0;
            Node<T> current = this.head;
            while (count < location) {
                current = current.next;
                count++;
            }
            deletedNode = current;
            current.prev.next = current.next;
            current.next.prev = current.prev;
        }
        numNode--;

        // Return the deleted node
        return deletedNode;
    }

    public int getIndex(T data) {
        Node<T> current = this.head;
        int index = 0;
        while (current != null) {
            if (current.getClass().equals(data)) {
                return index;
            }
            current = current.next;
            index++;
        }
        return -1;
    }

    @Override
    public String toString(){
        Node<T> toPrint = this.head;

        StringBuilder stringBuilder = new StringBuilder();

        while(toPrint != null){
            stringBuilder.append(toPrint.data);
            // String representation of the items separated by "->"
            stringBuilder.append("->");
            toPrint = toPrint.next;
        }
        // String representation to terminate with "NULL"
        stringBuilder.append("NULL");

        //return a string representations
        return stringBuilder.toString();
    }
}
