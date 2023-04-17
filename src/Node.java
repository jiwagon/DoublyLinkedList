public class Node<T> {
    Album album;
    T data;
    Node<T> next;
    Node<T> prev;

    public Node(Album data) {
        this.album = data;
        this.next = null;
        this.prev = null;
    }
}
