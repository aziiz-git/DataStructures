import java.util.Scanner;

public class SinglyLinkedList {
	
	//private ListNode head;  // Head node to hold the list (This line is later removed as it's present in display fn. 
	
	//class SinglyLinkedList has a static inner class. Why? One node and then same kind of next node we need
	
	public void display(ListNode head) {
		
		if (head == null) {
			return;   // Exit from if loop
		}
		ListNode current = head;  // Loop each element till end. Last node points to null
		
		while(current != null) {
			System.out.println(current.data + " --> ");
			current = current.next ;
		}
		System.out.println(current);  // Here, current will be null		
	}
	
	public int length (ListNode head) {   // Can be void RT if we are printing count directly
		
		if (head == null) {
			return 0;   // Exit from if loop
		}	
		
		ListNode current = head;  // Loop each element till end. Last node points to null
		int count = 0; // Default count
		
		while(current != null) {
			count++;
			current = current.next ;
		}		
		return count;
	}
	
	public ListNode insertAtBeginning(ListNode head, int data) {  // This method must return a result of type SinglyLinkedList.ListNode
		
		ListNode newNode = new ListNode(data);  // Get the new node ready
		if(head == null) {
			return newNode;		// The only node then	
		}
		
		newNode.next = head;
		head = newNode;  // This is the new head
		return head;     // Return the new head for display purpose
	}
	
	private static class ListNode {	
		
		private int data;  // The data (No need to declare as 'private'). 'data' cannot be used cannot be used outside ListNode class. 
		private ListNode next; //Reference of its own -> Helps Pointing to next node. 'next' can be used wherever ListNode is return type.
		
		public ListNode(int data) {  // For initializing a new node (static private class initiated. Data passed as argument.
			
			this.data = data;
			this.next = null; // The initial value  data|null  . Should work w/o 'this.'
			
		}
	}
	
	public static void main (String[] args) {
		
	// 10 -> 8 -> 1 -> 11
	// 10 is the head node
		
	ListNode head = new ListNode(10);    // Just passing the 'new' values // Objects
	ListNode second = new ListNode(8);
	ListNode third = new ListNode(1);
	ListNode fourth = new ListNode(11);
	
	// Attach together to form a list
	
	head.next = second; // 10 -> 8    // 'data' or 'next' can be used anywhere in main fn
	second.next = third; // 10 -> 8 -> 1
	third.next = fourth; // 10 -> 8 -> 1 -> 11 -> Null
	
	SinglyLinkedList singlyLinkedList = new SinglyLinkedList();
	//singlyLinkedList.display(head);	// We always start from head node	
	//System.out.println("Length of the Linked List is " + singlyLinkedList.length(head));
	ListNode newHead = singlyLinkedList.insertAtBeginning(head, 13);  // Insert and return the new head
	singlyLinkedList.display(newHead);		// Now, head is the new one
	}
}