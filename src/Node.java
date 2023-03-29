public class Node<T> {
    Album album;
    T data;
    Node<T> next;
    Node<T> prev;

    public Node(Album album1) {
        this.album = album1;
        this.next = null;
        this.prev = null;
    }
}
