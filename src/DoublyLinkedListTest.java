import static org.junit.jupiter.api.Assertions.*;
import org.junit.Test;

class DoublyLinkedListTest {

    @Test
    public void testInsert() {
        DoublyLinkedList dll = new DoublyLinkedList();

        Album album1 = new Album(1, "Title 1", 5);
        dll.insert(0, album1);
        assertEquals(dll.head.album.albumTitle, "Title 1");

        Album album2 = new Album(2, "Title 2", 5);
        dll.insert(1, album2);
        assertEquals(dll.tail.album.albumTitle, "Title 2");

        Album album3 = new Album(3, "Title 3", 5);
        dll.insert(2, album3);
        assertEquals(dll.head.album.albumTitle, "Title 3");
    }
}