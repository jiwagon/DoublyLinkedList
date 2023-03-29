import static org.junit.jupiter.api.Assertions.*;

import org.junit.Test;
class DoublyLinkedListTest {

    @Test
    public void testInsert() {
        DoublyLinkedList dll = new DoublyLinkedList();
        Album album1 = new Album(1, "Title 1", 5);
        dll.insert(0, album1);
        assertEquals(dll.head.album.albumTitle, "Title 1");
    }
}