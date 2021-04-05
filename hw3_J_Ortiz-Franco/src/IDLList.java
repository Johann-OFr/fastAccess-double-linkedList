import java.util.ArrayList;

public class IDLList<E> {
	
	//fields
	private Node<E> head; 
	private Node<E> tail;	
	private int size;
	ArrayList<Node<E>> indices;
	
	
	//constructor that creates an empty double-linked list
	public IDLList ()
	{
		this.head = null; 	
		this.tail = null;
		size = 0; 
		this.indices = new ArrayList<>();
		
	}
	
	public boolean add(int index, E elem)
	{
		//index out of bounds exception
		if (index < 0 && index > size)
		{
			throw new IndexOutOfBoundsException("Index entered is out of the array bounds.");
		}
		
		//if list is empty, head and tail point to new node
		if(index == 0) 
		{
			add(elem);														// calls another add method when adding to head. 
			return true;
		}	
		
		//if there is only 1 element in array
		else if (index == size) 
		{
			append(elem);
			return true;
		}
		//adding node to non-empty list greater than 1
		else
		{
			Node<E> currNode = indices.get(index);
			//create new node
			Node<E> newNode = new Node<> (elem);
			
			//four updates needed when adding a new node in middle of list
			newNode.prev = currNode.prev;									//1. Assign newNodes prev pointer to currNode's prev pointer.	
			newNode.next = currNode; 										//2. Assign newNodes next pointer to currNode.	
			currNode.prev.next = newNode;									//3. Updates the next pointer of the predecessor node to the newNode. 
			currNode.prev = newNode; 										//4. Updates the currNode's previous pointer to newNode.
		
			size++; 														//increments list size
		
			indices.add(index, newNode);									//adds the newNode to the given index after updating pointers
			
			return true;
		}
		
	}

	// used to add node when list is empty
	public boolean add(E elem) 
	{	
		Node<E> tmpNode = new Node<E>(elem);
		//when empty
		if(head == null) 
		{
			head = tail = tmpNode;
			head.prev = null; 
			tail.next = null;
			size++;
			
			indices.add(0, head);
			return true; 
		}
		//else add when element in list
		else
		{
			head.prev = tmpNode;
			tmpNode.next = head; 
			head = tmpNode; 
			size++; 
			
			indices.add(0, head);
			
			return true;
		}
		 
		
	}

	//append (E elem) that adds elem as the new last element of the list (i.e. at the tail)
	public boolean append(E elem)
	{
		if(head == null)													//determines if list is empty
		{
			add(elem);
			
			return true;
		}
	
		
		else 
		{
		
			Node<E> newNode = new Node<>(elem);
		
			newNode.prev = tail;
			tail.next = newNode; 
			tail = newNode; 
			size++; 
			indices.add(newNode);		
		}
		
		return true;
	}
	
	//return the object at position index from head
	public E get(int index)
	{
		if(index < 0 || index > indices.size())
		{
			throw new IndexOutOfBoundsException("Index was out of bounds. Value must be within array bounds");
		}
		
		return indices.get(index).data;
		
	}
	
	//return the object at the head
	public E getHead() {
		if(head == null || indices.size() == 0) 
		{
			throw new NullPointerException("The list is empty. Cannot get head node.");			//throws exception if list is empty. Cannot remove head if empty list
		} 
		
		return head.data;
	}
	
	//returns the object at the tail
	public E getLast() {
		if(head == null || indices.size() == 0) 
		{
			throw new NullPointerException("The list is empty. Cannot get last node.");			//throws exception if list is empty. Cannot remove head if empty list
		} 
		return tail.data;
	}
	
	//returns the list size
	public int size() {
		
		return indices.size();
	}
	
	//removing the head
	public E remove(){
		
		//if head is null list empty, nothing is removed --> Add NullPointerException
		if(head == null || indices.size() == 0) 
		{
			throw new NullPointerException("The list is empty.");			//throws exception if list is empty. Cannot remove head if empty list
		} 
		

		Node<E> tmpNode = head; 
		//if only 1 element in the array, need to change head = null and tail = null 
		if(head == tail)
		{
			head = null;
			tail = null;
			size--;
			
			indices.remove(0);
			return tmpNode.data;
		}
		else 
		{
			//if multiple nodes
			head = head.next;
			head.prev.next = null; 
			head.prev = null;
			
			size--; 
			
			indices.remove(0);
			
			return tmpNode.data;
		}

	
	}
	
	//Remove and returns the element at tail
	public E removeLast() 
	{
		//if list empty
		if(tail == null)
		{
			throw new NullPointerException("The list is empty."); //throws exception when trying to handle null pointer
		}
		
		//if list has 1 element
		else if(tail == head)
		{
			Node<E> tmpNode = tail;
			head = null;
			tail = null;
			size--;
			
			indices.remove(tmpNode);
			return tmpNode.data;
		}
		//if removing from list with greater than 1 element
		else 
		{
			Node<E> tmpNode = tail;
			tail = tail.prev;
			tail.next = null;
			size--;
			
			indices.remove(tmpNode);
			return tmpNode.data;
		}
	}

	//Removes and returns the element at index
	public E removeAt(int index)
	{
		//empty list
		if (index < 0 || index > indices.size()) {
			throw new IndexOutOfBoundsException("Index entered is not within arraylist bounds.");
		}
		
		//only 1 element in list
		else if (index == 0) 
		{
			return remove();
		}
		
		else if(index == indices.size() -1) 
		{
			return removeLast();
		}
		
		else 
		{
			Node<E> tmpNode = indices.get(index);
			tmpNode.next.prev = tmpNode.prev;
			tmpNode.prev.next = tmpNode.next;
			size--;
			
			indices.remove(index);
			
			return tmpNode.data;
		}
		
	}
	
	//Remove the first occurrence of elem in the list. return false if not present
	public boolean remove(E elem) 
	{
		
		Node<E> tmpNode = head;
		
		for(int i = 0; i < indices.size(); i++)
		{
			if(tmpNode.data.equals(elem)) 
			{
				removeAt(i);
				return true;
			}
			
			tmpNode = tmpNode.next;
			
		}
		
		return false;

	}
	
	//convert object data to string
	public String toString() {
		String toString = "";
		Node<E> tmpNode = head;
		
		while(tmpNode != null)
		{
			toString += tmpNode.data + " ";
			tmpNode = tmpNode.next;
		}
		
		return toString;
	}
	
	private class Node<E> {

		//fields
		private E data; 
		private Node<E> next;
		private Node<E> prev;
		
		//Default constructor
		private Node (E elem)
		{
			data = elem;
		}
		
		//parameterized constructor
		private Node(E elem, Node<E> prev, Node<E> next)
		{
			data = elem; 
			this.prev = prev;
			this.next = next;
		}
	}
	
}





