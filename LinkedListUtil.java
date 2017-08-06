package datastuct;

import java.util.Iterator;
import java.util.LinkedList;

public class LinkedListUtil {
/*
 * Node Declaration
 * Test comment added
 * 
 */
	public class Node {
		private int data;
		private Node next;

		// constructor
		public Node(int data, Node next) {
			this.data = data;
			this.next = next;
		}

		// getter and setter
		public void setData(int data) {
			this.data = data;
		}

		public int getData() {
			return data;
		}

		public void setNext(Node next) {
			this.next = next;
		}

		public Node getNext() {
			return next;
		}
	}
	
	private int length = 0;
	private Node head;

	//get Head
	
	public Node getHead(){
		return head;
	}
	
	public void setHead(Node hed){
		head = hed;
	}
	
	// insert at First
	public void insertAtBegin(int elem) {
		
		if (length == 0) {
			Node node = new Node(elem,null);
			head = node;
			length++;
		}
		
		else {
			Node node = new Node(elem,head);
			head = node;
			length++;
		}
		
	}
	
	//insert at Last
public void insertAtLast(int elem) {
		
		if (length == 0) {
			Node node = new Node(elem,null);
			head = node;
			length++;
		}
		
		else {
			Node node = head;
			while (node.next != null){
				node = node.next;
			}
			Node newNode = new Node(elem,null);
			node.next = newNode;
			length++;
			
		}
		
	}
	
//Insert in the middle of the list
public void insertAtMiddle(int elem,int pos){
	if (pos == 1){
		insertAtBegin(elem);
	}
	if (pos > length){
		System.out.println("Cant find the position");
	}
	if (length == 0){
		Node node = new Node(elem,null);
		head = node;
		length++;
	}
	
	else{
		Node h = head;
		int count = 2;
		while (count < pos){
			h = h.next;
			count++;
		}
		Node newNode = new Node(elem,h.next);
		h.next = newNode;
		length++;
		
	}
	
}
/*
 * Deletion of ELements from Linked List
 * 
 */

/*
 * Find The nth Node from end of the List
 * 
 */

public int nthNodeFromEnd(int n){
	/*
	 * This is going to be simple as we know the length of the List in declaration
	 * We have to return length - n + 1 element from begining
	 */
	Node h = head;
	int counter = 1;
	while (counter<length-n+1){
		h = h.next;
		counter++;
	}
	
	return h.data;
}

/*
 * Other approach is to use a hash table but that would take O(n) space complexity
 * Another efficient approach without using the length data
 * 
 */

public int nthNodeFromEnd_using2ptrs(int n){
	Node h1 = head;
	Node h2 = head;
	int counter = 1;
	while (counter<=n){
		h1 = h1.next;
		counter++;
	}
	
	while (h1 != null){
		h1 = h1.next;
		h2= h2.next;
	}
	
	return h2.data;
}

/*
 * Floyd algorithm to find the cycle in linked list
 * Other approaches are to use a hash table
 * Bruteforce or sorting will not work due to the loop, It may go in infinite cycle
 * 
 */
public boolean findCycle_Using_Floyd_Algorithm(){
	Node slowptr = head;
	Node fastptr = head;
	
	while (slowptr.next != fastptr.next.next || fastptr.next==null || slowptr.next == null){
		slowptr = slowptr.next;
		fastptr = fastptr.next.next;
	}
	
	if (slowptr.next == fastptr.next.next){
		return true;
	}
	
	
	return false;
}

/*
 * Find the start node of the loop if there is a cycle
 * Awsome solution using Floyd algorithm
 * 
 */

public Node findStartNodeOfLoop(){
	Node slowptr = head;
	Node fastptr = head;
	
	while (slowptr.next != fastptr.next.next || fastptr.next==null || slowptr.next == null){
		slowptr = slowptr.next;
		fastptr = fastptr.next.next;
	}
	
	if (slowptr.next == fastptr.next.next){
		fastptr = fastptr.next.next;
		slowptr = head;
	}
	
	while(slowptr.next != fastptr.next){
		slowptr = slowptr.next;
		fastptr = fastptr.next;
	}
	
	return slowptr.next;
}

/*
 * Reversing a Linked List
 * 
 */

public void reverseList(){
	Node prev = null;
	Node current = head;
	Node next;
	
	while (current != null){
		next = current.getNext();
		current.setNext(prev);
		prev = current;
		head=current;
		current = next;

		
	}
	
}

/*
 * Reversing a linked list
 * Below code will just reverse the display, It will not actually reverse the list
 * 
 */

public void reverseListDisplay_Util(Node temp_head){
	
	if (temp_head != null){
		reverseListDisplay_Util(temp_head.next);
		System.out.println(temp_head.data);
	}
	else{
		return;
	}
}

public void reverseListDisplay(){
	Node temp_head = head;
	reverseListDisplay_Util(temp_head);
}


/*
 * Finding the middle of the Linked list using two pointers
 * Below Algorithm works only when list has odd number of elements
 * 
 */

public void findMiddle(){
	Node slowptr = head;
	Node fastptr = head;
	
	while (fastptr.next !=null){
		fastptr = fastptr.next.next;
		slowptr = slowptr.next;
	}
	
	System.out.println(slowptr.data);
	
}

/*
 * Find whether the length of a list is even or odd using fast pointer
 * 
 */

public void evenOdd(){
	Node fastptr = head;
	
	while (fastptr != null && fastptr.getNext() != null) {
		fastptr = fastptr.next.next;
		
	}
	
	if (fastptr == null){
		System.out.println("Even");
	}
	else{
		System.out.println("Odd");
	}
	
}

public void javaDefinedList(){
	/*
	 * Working With java defined Linked List
	 * 
	 */
	LinkedList l = new LinkedList();
	l.add(1);
	l.add(2);
	l.add(3);
	Iterator itr = l.iterator();
	
	while (itr.hasNext()){
		System.out.println(itr.next());
	}
}


/*
 * Displaying the Elements of the List
 * 
 */
	public void displayElement(){
		Node n = head;
		while(n != null){
			System.out.println(n.getData());
			n = n.next;
		}
	}

}
