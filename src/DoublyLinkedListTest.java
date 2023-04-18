import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

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


    @Test
    void insert() {
        DoublyLinkedList dll1 = new DoublyLinkedList();

        ArrayList<String> femaleArtists = new ArrayList<>();
        ArrayList<String> maleArtists = new ArrayList<>();
        femaleArtists.add("Taylor Swift");
        femaleArtists.add("Lady Gaga");
        maleArtists.add("Harry Styles");
        maleArtists.add("Drake");

        Album album1 = new Album(1, femaleArtists,"Born This Way", 10);
        Album album2 = new Album(2, femaleArtists,"Midnights", 20);
        Album album3 = new Album(3, femaleArtists, "Love Story",30);
        Album album4 = new Album(4, maleArtists, "Harry's House",45);
        Album album5 = new Album(5, maleArtists, "More Life",50);
        Album album6 = new Album(6, femaleArtists, "Sour",60);
        Album album7 = new Album(7, femaleArtists, "Bitter",70);

        //Create a list of nodes
        dll1.append(album1);
        dll1.append(album3);
        dll1.append(album5);

        dll1.insert(1,album2);
        dll1.insert(3,album4);

        System.out.println("dll1");
        System.out.println(dll1);

        DoublyLinkedList dll2 = new DoublyLinkedList();

        dll2.append(album2);
        dll2.append(album4);

        dll2.insert(0,album1);
        dll2.insert(2,album3);
        dll2.insert(4,album5);
        dll2.insert(5,album6);

        // to test try catch block
        // dll2.insert(-10,album6);
        // dll2.insert(100,album7);

        System.out.println("dll2");
        System.out.println(dll2);
    }
}