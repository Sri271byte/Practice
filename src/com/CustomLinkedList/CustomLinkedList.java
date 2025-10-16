package com.CustomLinkedList;

public class CustomLinkedList {
	
	 private Node head; // first node of the list

	    // Add new element at the end
	    public void add(int data) {
	        Node newNode = new Node(data);
	        if (head == null) {
	            head = newNode;
	        } else {
	            Node current = head;
	            while (current.next != null) {
	                current = current.next;
	            }
	            current.next = newNode;
	        }
	    }

	    // Display all elements
	    public void display() {
	        Node current = head;
	        while (current != null) {
	            System.out.print(current.data + " -> ");
	            current = current.next;
	        }
	        System.out.println("null");
	    }
	    
	    public static void main(String[] args) {
	        CustomLinkedList list = new CustomLinkedList();

	        list.add(10);
	        list.add(20);
	        list.add(30);

	        list.display(); // 10 -> 20 -> 30 -> null
	    }

}
