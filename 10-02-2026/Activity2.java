/*
Part 1 – Scenario Based Analysis
1. Real-time chat message storage

Choice: ArrayList
Justification: Chat messages are typically appended sequentially and accessed by index for display. ArrayList provides O(1) random access for reading messages and amortized O(1) for appending at the end.
2. Music playlist where songs are frequently reordered

Choice: LinkedList
Justification: Frequent reordering involves insertions and deletions at various positions. LinkedList offers O(1) insertions/deletions once the position is found, while ArrayList would be O(n) due to element shifting.
3. Student database with frequent searching by index

Choice: ArrayList
Justification: Random access by index is O(1) in ArrayList vs O(n) in LinkedList. ArrayList provides better cache locality for faster access.
4. Browser back and forward navigation

Choice: LinkedList (Doubly Linked List preferred)
Justification: Navigation involves sequential forward/backward movement and frequent insertions/deletions of history entries. LinkedList's O(1) insertions/deletions at both ends are ideal.
5. Online exam system storing answers sequentially

Choice: ArrayList
Justification: Answers are stored sequentially with minimal reordering. ArrayList's O(1) append and O(1) index-based retrieval are perfect for this use case.*/

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;

public class ArrayListAdvanced {
    public static void main(String[] args) {
        // Create ArrayList and store 10 numbers
        ArrayList<Integer> numbers = new ArrayList<>();
        numbers.add(34);
        numbers.add(12);
        numbers.add(78);
        numbers.add(45);
        numbers.add(23);
        numbers.add(90);
        numbers.add(56);
        numbers.add(33);
        numbers.add(67);
        numbers.add(88);
        
        System.out.println("Original list: " + numbers);
        
        // Remove all even numbers using Iterator for safe removal
        Iterator<Integer> iterator = numbers.iterator();
        while (iterator.hasNext()) {
            if (iterator.next() % 2 == 0) {
                iterator.remove();
            }
        }
        System.out.println("After removing even numbers: " + numbers);
        
        // Find maximum and minimum
        if (!numbers.isEmpty()) {
            int max = Collections.max(numbers);
            int min = Collections.min(numbers);
            System.out.println("Maximum element: " + max);
            System.out.println("Minimum element: " + min);
        }
        
        // Sort in descending order
        Collections.sort(numbers, Collections.reverseOrder());
        System.out.println("Sorted in descending order: " + numbers);
    }
}



public class HospitalQueue {
    public static void main(String[] args) {
        LinkedList<String> patientQueue = new LinkedList<>();
        
        // Add 5 patients
        patientQueue.add("John Doe");
        patientQueue.add("Alice Smith");
        patientQueue.add("Bob Johnson");
        patientQueue.add("Carol White");
        patientQueue.add("David Brown");
        
        System.out.println("Initial queue: " + patientQueue);
        
        // Emergency patient added at first position
        patientQueue.addFirst("Emergency: Mike Wilson");
        System.out.println("After emergency patient: " + patientQueue);
        
        // Remove 2 patients after treatment
        if (patientQueue.size() >= 2) {
            patientQueue.removeFirst(); // First patient treated
            patientQueue.removeFirst(); // Second patient treated
        } else {
            System.out.println("Not enough patients to remove");
        }
        
        // Display current queue
        System.out.println("Current queue after treatments: " + patientQueue);
        System.out.println("Number of patients waiting: " + patientQueue.size());
    }
}

public class SinglyLinkedList {
    // Node class
    class Node {
        int data;
        Node next;
        
        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }
    
    private Node head;
    
    // Constructor
    public SinglyLinkedList() {
        this.head = null;
    }
    
    // 1. Insert at specific position
    public void insertAtPosition(int data, int position) {
        Node newNode = new Node(data);
        
        if (position == 1) {
            newNode.next = head;
            head = newNode;
            return;
        }
        
        Node current = head;
        for (int i = 1; i < position - 1 && current != null; i++) {
            current = current.next;
        }
        
        if (current == null) {
            System.out.println("Position out of bounds");
            return;
        }
        
        newNode.next = current.next;
        current.next = newNode;
    }
    
    // 2. Delete by value
    public void deleteByValue(int value) {
        if (head == null) return;
        
        // If head needs to be deleted
        if (head.data == value) {
            head = head.next;
            return;
        }
        
        Node current = head;
        while (current.next != null && current.next.data != value) {
            current = current.next;
        }
        
        if (current.next != null) {
            current.next = current.next.next;
        }
    }
    
    // 3. Count total nodes
    public int countNodes() {
        int count = 0;
        Node current = head;
        while (current != null) {
            count++;
            current = current.next;
        }
        return count;
    }
    
    // 4. Find middle element (Slow & Fast pointer)
    public int findMiddle() {
        if (head == null) return -1;
        
        Node slow = head;
        Node fast = head;
        
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        
        return slow.data;
    }
    
    // 5. Reverse the linked list
    public void reverse() {
        Node prev = null;
        Node current = head;
        Node next = null;
        
        while (current != null) {
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }
        
        head = prev;
    }
    
    // Display the linked list
    public void display() {
        Node current = head;
        while (current != null) {
            System.out.print(current.data + " -> ");
            current = current.next;
        }
        System.out.println("null");
    }
    
    // Main method to test all operations
    public static void main(String[] args) {
        SinglyLinkedList list = new SinglyLinkedList();
        
        // Insert elements
        list.insertAtPosition(10, 1);
        list.insertAtPosition(20, 2);
        list.insertAtPosition(30, 3);
        list.insertAtPosition(40, 4);
        list.insertAtPosition(50, 5);
        
        System.out.println("Original list:");
        list.display();
        
        System.out.println("Total nodes: " + list.countNodes());
        System.out.println("Middle element: " + list.findMiddle());
        
        // Delete by value
        list.deleteByValue(30);
        System.out.println("After deleting 30:");
        list.display();
        
        // Reverse list
        list.reverse();
        System.out.println("After reversing:");
        list.display();
    }
}

public class BonusLinkedList {
    class Node {
        int data;
        Node next;
        
        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }
    
    // 1. Detect loop in linked list (Floyd's Algorithm)
    public boolean hasLoop(Node head) {
        if (head == null || head.next == null) return false;
        
        Node slow = head;
        Node fast = head;
        
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            
            if (slow == fast) {
                return true; // Loop detected
            }
        }
        
        return false;
    }
    
    // 2. Merge two sorted linked lists
    public Node mergeSortedLists(Node l1, Node l2) {
        Node dummy = new Node(0);
        Node current = dummy;
        
        while (l1 != null && l2 != null) {
            if (l1.data <= l2.data) {
                current.next = l1;
                l1 = l1.next;
            } else {
                current.next = l2;
                l2 = l2.next;
            }
            current = current.next;
        }
        
        // Attach remaining elements
        if (l1 != null) {
            current.next = l1;
        } else {
            current.next = l2;
        }
        
        return dummy.next;
    }
    
    // 3. Remove duplicates from sorted linked list
    public Node removeDuplicates(Node head) {
        if (head == null || head.next == null) return head;
        
        Node current = head;
        
        while (current != null && current.next != null) {
            if (current.data == current.next.data) {
                current.next = current.next.next;
            } else {
                current = current.next;
            }
        }
        
        return head;
    }
    
    // Utility method to display list
    public void display(Node head) {
        Node current = head;
        while (current != null) {
            System.out.print(current.data + " -> ");
            current = current.next;
        }
        System.out.println("null");
    }
    
    public static void main(String[] args) {
        BonusLinkedList bonus = new BonusLinkedList();
        
        // Create sample lists
        Node list1 = bonus.new Node(1);
        list1.next = bonus.new Node(3);
        list1.next.next = bonus.new Node(5);
        
        Node list2 = bonus.new Node(2);
        list2.next = bonus.new Node(4);
        list2.next.next = bonus.new Node(6);
        
        System.out.println("List 1:");
        bonus.display(list1);
        
        System.out.println("List 2:");
        bonus.display(list2);
        
        // Merge sorted lists
        Node merged = bonus.mergeSortedLists(list1, list2);
        System.out.println("Merged sorted list:");
        bonus.display(merged);
        
        // Create list with duplicates
        Node listWithDupes = bonus.new Node(1);
        listWithDupes.next = bonus.new Node(1);
        listWithDupes.next.next = bonus.new Node(2);
        listWithDupes.next.next.next = bonus.new Node(3);
        listWithDupes.next.next.next.next = bonus.new Node(3);
        
        System.out.println("List with duplicates:");
        bonus.display(listWithDupes);
        
        // Remove duplicates
        Node noDupes = bonus.removeDuplicates(listWithDupes);
        System.out.println("After removing duplicates:");
        bonus.display(noDupes);
    }
}

