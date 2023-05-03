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

    public int getIndex(Album data){
        Node<T> current = this.head;
        int index = 0;
        while(current != null){
            if(current.data.getID() == data.getID() &&
                    current.data.getTitle().equals(data.getTitle()) &&
                    current.data.getNumSong() == data.getNumSong() &&
                    current.data.getName().equals(data.getName())){
                // Return the first index of the item
                return index;
            }
            else {
                current = current.next;
                index++;
            }
        }
        // Return -1 if it isn't in the list
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

    // Shuffle method to shuffle the doubly linked list
    // Return the head of a shuffled list ?
    // Shuffling should take a list 1->2->3->4->5->6->NULL and return 2->1->4->3->6->5->NULL
    public Node<Album> shuffle(){
        //before shuffle the list, divide the original list into half by odd and even index
        DoublyLinkedList oddList = new DoublyLinkedList();
        DoublyLinkedList evenList = new DoublyLinkedList();
        Node<T> pointer = this.head;
        int count = 0;
        while(pointer != null){
            if(count%2 == 0){
                evenList.append(pointer.data);
            }
            else{
                oddList.append(pointer.data);
            }
            count++;
            pointer = pointer.next;
        }
        Node<T> pointer1 = oddList.head;
        Node<T> pointer2 = evenList.head;
        DoublyLinkedList result = new DoublyLinkedList();
        while(pointer1 != null){
            result.append(pointer1.data);
            result.append(pointer2.data);
            pointer1 = pointer1.next;
            pointer2 = pointer2.next;
        }
        if(pointer2 != null){
            result.append(pointer2.data);
        }
        // Print the shuffled list
        Node<T> current = result.head;
        while (current != null) {
            System.out.print(current.data.toString());
            current = current.next;
            System.out.print("->");
        }
        System.out.println("NULL");
        System.out.print("\n");
        //Return the head of a shuffled list
        return result.head;
    }

    // Return a new list that contains everything in the list that is greater than or equal to the data given to it
    public DoublyLinkedList partition(Node<T> data) {
        DoublyLinkedList newDll = new DoublyLinkedList();
        Node current = head;
        while (current != null) {
            if (current.data.compareTo(data.data) >= 0) {
                newDll.append(current.data);
            }
            current = current.next;
        }
        return newDll;
    }
}
