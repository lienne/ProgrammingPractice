// Linked List of Integers in Java

import java.io.*;

// Basic node class holds a piece of data (here, an int), and a next field.
class Node
{
	int data;
	Node next;

	// Constructor method. Sets this object's 'data' field to contructor's argument 'data'
	Node(int data)
	{
		this.data = data;
	}
}

// Basic Linked List of integers
public class LinkedList
{
	// Don't mess with my head and tail! (private members)
	private Node head, tail;

	// Insert at the tail of the list.
	public void tailInsert(int data)
	{
		// Since we're inserting at the tail, we need to check if the list is empty first.
		// If the list is empty, set 'head' and 'tail' to the new node.
		if(head == null)
			head = tail = new Node(data);

		// Otherwise, append the new node to the end of the list and move the tail reference forward.
		else
		{
			tail.next = new Node(data);
			tail = tail.next;
		}
	}

	// Insert at the head of the list
	public void headInsert(int data)
	{
		// Since we're inserting at the head, we only check if list is empty later.
		// First, create the node to be inserted.
		Node newNode = new Node(data);

		// Insert it at the beginning of the list.
		newNode.next = head;
		head = newNode;

		// If the list was empty before adding this node, 'head' AND 'tail' need to reference this new node.
		if(tail == null)
			tail = newNode;
	}

	// Remove the head of the list (and return its 'data' value).
	// We're using Integer so that we can return a null reference if the list is empty.
	// Otherwise, the return value can be used in int contexts. This is a bit nicer than
	// returning -1 or Integer.MIN_VALUE, because we might actually want to allow those values
	// in our linked list nodes!
	public Integer deleteHead()
	{
		// If the list is empty, signify that by returning null.
		if(head == null)
			return null;

		// Store the data from the head, then move the head reference forward.
		// Java will take care of the memory management when it realizes there are no
		// references to the old head anymore.
		int temp = head.data;
		head = head.next;

		// If the list is now empty (i.e., if the node we just removed was the only node in the list),
		// update the tail reference, too!
		if(head == null)
			tail = null;

		// Return the value from the old head node.
		return temp;
	}

	// Remove the tail of the list, and return its 'data' value.
	public Integer deleteTail()
	{
		// If the list is empty, both head and tail are null, then return null
		if(head == null)
			return null;

		// Store data from tail, and move the reference forward. Java will take care of deleting it
		// once it realizes its reference is gone.
		int temp = tail.data;
		tail = tail.next;

		// If this was the only node in the list, the list is now empty, and we must also update head
		if(tail == null)
			head = null;

		// Return the value of the old tail
		return temp;
	}

	// Print the contents of the linked list.
	public void print()
	{
		for(Node temp = head; temp != null; temp = temp.next)
			System.out.print(temp.data + ((temp.next == null) ? "\n" : " "));
	}

	// Returns true if the list is empty, false otherwhise.
	boolean isEmpty()
	{
		return (head == null);
	}

	public static void main(String [] args)
	{
		// Create a new linked list.
		LinkedList list = new LinkedList();

		list.headInsert(43);
		list.headInsert(58);
		list.headInsert(52);
		list.headInsert(33);
		list.headInsert(19);
		list.headInsert(12);

		// Print the list to verify everything got in there correctly.
		list.print();


		list.deleteTail();
		list.print();
		/*
		while(!list.isEmpty())
		{
			list.deleteHead();
			list.print();
		}
		*/
	}

}
