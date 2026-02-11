/* 
2. Part 1 – Concept Analysis (Group Activity)
 Comparison Table
 Feature	                    ArrayList	                LinkedList
 Internal Structure	        Dynamic array	            Doubly linked nodes
 Access Time Complexity	    O(1) (random access)	    O(n) (sequential access)
 Insertion Time Complexity	O(n) (worst-case, middle)	O(1) (once position found)
 Deletion Time Complexity	    O(n) (worst-case, middle)	O(1) (once position found)
 Memory Usage	                Less overhead (contiguous)	More overhead (pointers per node)
 Best Use Case	            Frequent read operations	Frequent insert/delete operations
 Cache Locality	            Excellent	                Poor


 Scenario Analysis

     Student Record System

         Choice: ArrayList

         Reason: Frequent searching by roll number/index, minimal insertion/deletion after initialization

     Browser History

         Choice: LinkedList (Doubly Linked List preferred)

         Reason: Sequential navigation (back/forward), frequent additions/deletions

     Online Shopping Cart

         Choice: ArrayList

         Reason: Random access to items, mostly sequential addition/removal at end

     Undo/Redo Feature

         Choice: LinkedList

         Reason: Stack-like behavior, frequent push/pop operations

*/
3. Part 2 – Coding Task
Task A – ArrayList Program
java

import java.util.ArrayList;
import java.util.Collections;

public class StudentMarksArrayList {
    public static void main(String[] args) {
        System.out.println("=== STUDENT MARKS MANAGEMENT (ArrayList) ===\n");
        
        // Create ArrayList to store marks
        ArrayList<Integer> marks = new ArrayList<>();
        
        // 1. Add 5 student marks
        System.out.println("1. Adding 5 student marks:");
        marks.add(85);
        marks.add(92);
        marks.add(78);
        marks.add(65);
        marks.add(88);
        System.out.println("   Marks: " + marks);
        
        // 2. Insert a mark at index 2
        System.out.println("\n2. Inserting mark 95 at index 2:");
        marks.add(2, 95);
        System.out.println("   Updated Marks: " + marks);
        
        // 3. Remove the lowest mark
        System.out.println("\n3. Removing the lowest mark:");
        int minMark = Collections.min(marks);
        int minIndex = marks.indexOf(minMark);
        marks.remove(minIndex);
        System.out.println("   Removed: " + minMark + " from position " + minIndex);
        System.out.println("   Marks after removal: " + marks);
        
        // 4. Display final list
        System.out.println("\n4. Final List:");
        System.out.println("   " + marks);
        System.out.println("   Total students: " + marks.size());
        System.out.println("   Average marks: " + 
            String.format("%.2f", marks.stream().mapToInt(Integer::intValue).average().orElse(0.0)));
    }
}

Task B – LinkedList as Queue
java

import java.util.LinkedList;

public class TicketBookingQueue {
    public static void main(String[] args) {
        System.out.println("=== TICKET BOOKING QUEUE (LinkedList) ===\n");
        
        // Create LinkedList as Queue
        LinkedList<String> ticketQueue = new LinkedList<>();
        
        // 1. Add 5 customers
        System.out.println("1. Adding 5 customers to queue:");
        ticketQueue.add("Customer A - John");
        ticketQueue.add("Customer B - Sarah");
        ticketQueue.add("Customer C - Mike");
        ticketQueue.add("Customer D - Emma");
        ticketQueue.add("Customer E - David");
        
        displayQueue(ticketQueue);
        
        // 2. Remove 2 customers (they got their tickets)
        System.out.println("\n2. Processing 2 customers:");
        System.out.println("   Processing: " + ticketQueue.removeFirst());
        System.out.println("   Processing: " + ticketQueue.removeFirst());
        
        // 3. Display remaining queue
        System.out.println("\n3. Remaining customers in queue:");
        displayQueue(ticketQueue);
        
        // Additional: Add new customer
        System.out.println("\n4. New customer joins queue:");
        ticketQueue.add("Customer F - Lisa");
        displayQueue(ticketQueue);
    }
    
    private static void displayQueue(LinkedList<String> queue) {
        if (queue.isEmpty()) {
            System.out.println("   Queue is empty!");
            return;
        }
        
        System.out.println("   Queue Position | Customer");
        System.out.println("   " + "-".repeat(30));
        
        int position = 1;
        for (String customer : queue) {
            System.out.printf("   %-13d | %s\n", position++, customer);
        }
        System.out.println("   Total waiting: " + queue.size());
    }
}

4. Part 3 – Singly Linked List Implementation
java

public class ManualSinglyLinkedList {
    
    // Node class
    static class Node {
        int data;
        Node next;
        
        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }
    
    private Node head;
    
    // Constructor
    public ManualSinglyLinkedList() {
        this.head = null;
    }
    
    // 1. Insert at beginning
    public void insertAtBeginning(int data) {
        Node newNode = new Node(data);
        newNode.next = head;
        head = newNode;
        System.out.println("Inserted " + data + " at beginning");
    }
    
    // 2. Insert at end
    public void insertAtEnd(int data) {
        Node newNode = new Node(data);
        
        if (head == null) {
            head = newNode;
            System.out.println("Inserted " + data + " as first element");
            return;
        }
        
        Node current = head;
        while (current.next != null) {
            current = current.next;
        }
        current.next = newNode;
        System.out.println("Inserted " + data + " at end");
    }
    
    // 3. Traverse (Display all elements)
    public void traverse() {
        if (head == null) {
            System.out.println("List is empty!");
            return;
        }
        
        Node current = head;
        System.out.print("Linked List: ");
        while (current != null) {
            System.out.print(current.data + " -> ");
            current = current.next;
        }
        System.out.println("null");
    }
    
    // 4. Search for an element
    public boolean search(int data) {
        Node current = head;
        int position = 1;
        
        while (current != null) {
            if (current.data == data) {
                System.out.println("Found " + data + " at position " + position);
                return true;
            }
            current = current.next;
            position++;
        }
        
        System.out.println(data + " not found in the list");
        return false;
    }
    
    // CHALLENGE: Reverse the linked list
    public void reverse() {
        Node prev = null;
        Node current = head;
        Node next = null;
        
        while (current != null) {
            next = current.next;  // Store next node
            current.next = prev;  // Reverse current node's pointer
            prev = current;       // Move pointers one position ahead
            current = next;
        }
        
        head = prev;
        System.out.println("List has been reversed");
    }
    
    // Main method to test all operations
    public static void main(String[] args) {
        System.out.println("=== MANUAL SINGLY LINKED LIST IMPLEMENTATION ===\n");
        
        ManualSinglyLinkedList list = new ManualSinglyLinkedList();
        
        // Insert operations
        list.insertAtEnd(10);
        list.insertAtEnd(20);
        list.insertAtBeginning(5);
        list.insertAtEnd(30);
        list.insertAtBeginning(1);
        
        System.out.println();
        list.traverse();
        
        // Search operations
        System.out.println();
        list.search(20);
        list.search(99);
        
        // Reverse challenge
        System.out.println("\n=== CHALLENGE: REVERSE LINKED LIST ===");
        System.out.println("Before reverse:");
        list.traverse();
        
        list.reverse();
        
        System.out.println("After reverse:");
        list.traverse();
        
        // Display list information
        System.out.println("\n=== LIST INFORMATION ===");
        list.displayInfo();
    }
    
    // Additional: Display list information
    public void displayInfo() {
        if (head == null) {
            System.out.println("List is empty");
            return;
        }
        
        int count = 0;
        Node current = head;
        
        while (current != null) {
            count++;
            current = current.next;
        }
        
        System.out.println("Total nodes: " + count);
        System.out.println("Head element: " + head.data);
        
        // Find last element
        current = head;
        while (current.next != null) {
            current = current.next;
        }
        System.out.println("Tail element: " + current.data);
    }
}


