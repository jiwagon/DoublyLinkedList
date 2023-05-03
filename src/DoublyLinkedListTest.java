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
        dll.append(album2);
        dll.append(album3);

        assertEquals(album1, dll.head.data);
        assertEquals(album2, dll.head.next.data);
        assertEquals(album3, dll.head.next.next.data);

        assertEquals(album1, dll.append(album1).data);
        assertEquals(album3, dll.append(album3).data);

        assertEquals(album1, dll.tail.prev.data);
        assertEquals(album3, dll.tail.data);

        System.out.println(dll);
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
        //Album album6 = new Album(6, femaleArtists, "Sour",60);
        //Album album7 = new Album(7, femaleArtists, "Bitter",70);

        //Create a list of nodes
        dll1.append(album1);
        dll1.append(album3);
        dll1.append(album5);

        dll1.insert(1,album2);
        dll1.insert(3,album4);

        assertEquals(album1, dll1.head.data);
        assertEquals(album2, dll1.head.next.data);
        assertEquals(album4, dll1.tail.prev.data);
        assertEquals(album5, dll1.tail.data);
        System.out.println(dll1);

//        DoublyLinkedList dll2 = new DoublyLinkedList();
//        dll2.append(album2);
//        dll2.append(album4);
//
//        dll2.insert(0,album1);
//        dll2.insert(2,album3);
//        dll2.insert(4,album5);
//        dll2.insert(5,album6);
//        System.out.println(dll2);

        // to test try catch block
        // dll2.insert(-10,album6);
        // dll2.insert(100,album7);
    }

    @Test
    void delete() {
        DoublyLinkedList dll3 = new DoublyLinkedList();

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

        dll3.insert(0, album4);
        dll3.insert(1, album1);
        dll3.insert(2, album2);
        dll3.insert(3, album5);
        dll3.insert(4, album3);
        dll3.insert(5, album6);

        // Delete a node at the end of nodes
        dll3.delete(5);
        // Delete a node at the head of nodes
        dll3.delete(0);
        // Delete a node in the middle
        dll3.delete(2);

        assertEquals(album1, dll3.head.data);
        assertEquals(album2, dll3.head.next.data);
        assertEquals(album3, dll3.tail.data);
        System.out.println(dll3);
    }

    @Test
    void getIndex() {
        DoublyLinkedList dll4 = new DoublyLinkedList();

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

        dll4.insert(0, album1);
        dll4.insert(1, album2);
        dll4.insert(2, album3);
        dll4.insert(3, album4);

        // Get index of items that exists in the list
        assertEquals(0, dll4.getIndex(album1));
        int index1 = dll4.getIndex(album1);
        System.out.println("Index " + album1 + " = " + index1);

        assertEquals(1, dll4.getIndex(album2));
        int index2 = dll4.getIndex(album2);
        System.out.println("Index " + album2 + " = " + index2);

        // Get index of an item that does not exist in the list
        assertEquals(-1, dll4.getIndex(album5));
        int index3 = dll4.getIndex(album5);
        System.out.println("Index " + album5 + " = " + index3);
    }

    @Test
    void shuffle() {
        DoublyLinkedList dll = new DoublyLinkedList();
        ArrayList<String> artists = new ArrayList<>();

        artists.add("Taylor Swift");
        artists.add("Lady Gaga");
        artists.add("Harry Styles");
        artists.add("Drake");

        Album album1 = new Album(1, artists,"Born This Way", 10);
        Album album2 = new Album(2, artists,"Midnights", 20);
        Album album3 = new Album(3, artists, "Love Story",30);
        Album album4 = new Album(4, artists, "Harry's House",45);
        Album album5 = new Album(5, artists, "More Life",50);
        Album album6 = new Album(6, artists, "Sour",60);

//        dll.append(album1);
//        dll.append(album2);
//        dll.append(album3);
//        dll.append(album4);
//        dll.append(album5);
//        dll.append(album6);
//        assertEquals(album2,dll.shuffle().data);

        DoublyLinkedList dll2 = new DoublyLinkedList();
        dll2.append(album1);
        dll2.append(album2);
        dll2.append(album3);
        dll2.append(album4);
        dll2.append(album5);
        dll2.append(album6);

        System.out.println(dll2);
        assertEquals(album2,dll2.shuffle().data);
    }

    @Test
    void partition() {
        DoublyLinkedList dll = new DoublyLinkedList();

        ArrayList<String> artists = new ArrayList<>();
        artists.add("Taylor Swift");
        artists.add("Lady Gaga");
        artists.add("Harry Styles");
        artists.add("Drake");

        Album album1 = new Album(1, artists,"Born This Way", 10);
        Album album2 = new Album(2, artists,"Midnights", 20);
        Album album3 = new Album(3, artists, "Love Story",30);
        Album album4 = new Album(4, artists, "Harry's House",45);
        Album album5 = new Album(5, artists, "More Life",50);
        Album album6 = new Album(6, artists, "Sour",60);

        dll.append(album1);
        dll.append(album2);
        dll.append(album3);
        dll.append(album4);
        dll.append(album5);
        dll.append(album6);

        DoublyLinkedList dll2 = new DoublyLinkedList();
        dll2.append(album2);
        dll2.append(album3);
        dll2.append(album4);
        dll2.append(album5);
        dll2.append(album6);

        Node<Album> node1 = new Node<Album>(album2);
        assertEquals(dll2.toString(),dll.partition(node1).toString());
        //System.out.println(dll2);

        DoublyLinkedList dll3 = new DoublyLinkedList();
        dll3.append(album4);
        dll3.append(album5);
        dll3.append(album6);

        Node<Album> node2= new Node<Album>(album4);
        assertEquals(dll3.toString(),dll.partition(node2).toString());
        System.out.println(dll3);
    }
}