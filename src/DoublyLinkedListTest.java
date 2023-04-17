import static org.junit.jupiter.api.Assertions.*;
import org.junit.Test;

import java.util.ArrayList;

class DoublyLinkedListTest {


    @org.junit.jupiter.api.Test
    void append() {
        DoublyLinkedList dll = new DoublyLinkedList();

        ArrayList<String> femaleArtists = new ArrayList<>();
        ArrayList<String> maleArtists = new ArrayList<>();
        femaleArtists.add("Taylor Swift");
        femaleArtists.add("Lady Gaga");
        maleArtists.add("Harry Styles");

        Album album1 = new Album(1, femaleArtists,"Midnights", 5);
        Album album2 = new Album(2, femaleArtists, "Title 2",6);
        Album album3 = new Album(3, maleArtists, "Title 2",7);
        //append when the list is empty
        dll.append(album1);
        assertEquals(album1, dll.append(album1).data);
        dll.append(album2);
        dll.append(album3);
        assertEquals(album3, dll.append(album3).data);
        System.out.println(dll.head.data);
        System.out.println(dll.head.next.next.data);
        System.out.println(dll.tail.data);

//        Album album2 = new Album(2, "Title 2", 5);
//        dll.append(album2);
//        assertEquals(dll.tail.album.albumTitle, "Title 2");
//
//    Album album3 = new Album(3, "Title 3", 5);
//        dll.insert(2, album3);
//    assertEquals(dll.head.album.albumTitle, "Title 3");
    }



}