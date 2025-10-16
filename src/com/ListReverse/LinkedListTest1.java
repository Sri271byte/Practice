package com.ListReverse;

import java.util.LinkedList;

public class LinkedListTest1 {

	public static void main(String[] args) {

		
		// Declaring linked list without any initial size
        LinkedList<String> linkedli = new LinkedList<String>();
        // Appending elements at the end of the list
        linkedli.add("Cherry");
        linkedli.add("Chennai");
        linkedli.add("Bullet");
        System.out.print("Elements before reversing: " + linkedli);
        linkedli = reverseLinkedList(linkedli);
        System.out.print("\nElements after reversing: " + linkedli);
    }

    // Takes a linked list as a parameter and returns a reversed linked list
    public static LinkedList<String> reverseLinkedList(LinkedList<String> llist)
    {
        LinkedList<String> revLinkedList = new LinkedList<String>();
        for (int i = llist.size() - 1; i >= 0; i--) {

            // Append the elements in reverse order
            revLinkedList.add(llist.get(i));
        }
        // Return the reversed array list
        return revLinkedList;
    }
}


