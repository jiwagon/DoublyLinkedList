public class DoublyLinkedList {

    Node<Album> head;
    Node<Album> prev;
    Node<Album> tail;

    public DoublyLinkedList() {
        this.head = null;
        this.prev= null;
        this.tail = null;
    }

    public Node<Album> append(Album album1) {

        return null;
    }

    public Node<Album> insert(int position, Album album1) {
        Node<Album> toInsert = new Node<Album>(album1);
        IllegalArgumentException IAe = new IllegalArgumentException
                ("Position Out of Bounds of Doubly Linked List");
        if (head == null && position != 0) {
            throw IAe;
        }
        else {
            if (head == null && position == 0) {
                //toInsert.next = head;
                //head.prev = toInsert;
                head = toInsert;
                tail = toInsert;
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
        return toInsert;
    }

}
