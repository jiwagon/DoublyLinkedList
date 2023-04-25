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
    }

    //    assertEquals(dll.tail.album.albumTitle, "Title 2");
    //    assertEquals(dll.head.album.albumTitle, "Title 3");
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
        //Album album7 = new Album(7, femaleArtists, "Bitter",70);

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

        System.out.println("dll3");
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
        Album album6 = new Album(6, femaleArtists, "Sour",60);

        dll4.insert(0, album1);
        dll4.insert(1, album2);
        dll4.insert(2, album3);
        dll4.insert(3, album4);
    }

    /**
     * // Test case 1: Get index of an item that exists in the list
     * int index = doublyLinkedList.getIndex("bar");
     * System.out.println("Index of 'bar': " + index); // Output: Index of 'bar': 1
     *
     * // Test case 2: Get index of an item that does not exist in the list
     * index = doublyLinkedList.getIndex("xyz");
     * System.out.println("Index of 'xyz': " + index); // Output: Index of 'xyz': -1
     *
     * // Test case 3: Get index of an item in an empty list
     * DoublyLinkedList<Integer> emptyList = new DoublyLinkedList<>();
     * index = emptyList.getIndex(10);
     * System.out.println("Index of 10 in empty list: " + index); // Output: Index of 10 in empty list: -1
     *
     * // Test case 4: Get index of an item in a list with only one item
     * DoublyLinkedList<Integer> singleItemList = new DoublyLinkedList<>();
     * singleItemList.insert(0, 20);
     * index = singleItemList.getIndex(20);
     * System.out.println("Index of 20 in single-item list: " + index); // Output: Index of 20 in single-item list: 0
     *
     */
}