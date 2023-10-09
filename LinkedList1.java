package com.practice;
class LL
{
	int size;
	Node head;
	class Node
	{
		int data;
		Node next;
		Node(int data)
		{
			this.data = data;
			this.next =  null;
			size++;
		}
		Node(int data,Node temp)
		{
			this.data = data;
			this.next = temp;
			size++;
		}
		
	}
	int getSize()
	{
		return this.size;
	}
	public void addFirst(int data)
	{
		Node newNode = new Node(data);
		{
			if(head == null)
			{
				head = newNode;
				return;
			}
			newNode.next = head;
			head = newNode;
		}
	}
	public void addLast(int data)
	{
		Node newNode = new Node(data);
		{
			if(head == null)
			{
				head = newNode;
				return;
			}
			Node temp = head;
			while(temp.next!=null)
			{
				temp = temp.next;
			}
			temp.next = newNode;
		}
	}
	public void deleteFirst()
	{
		if(head == null)
		{
			System.out.println("Empty String");				
			return;
		}
		head = head.next;
	}
	
	public void deleteLast()
	{
		if(head == null)
		{
			return;
		}
		if(head.next==null)
		{
			head = null;
			return;
		}
		
		Node prev,current;
		prev = head;
		current = head.next;
		while(current.next!=null)
		{
			prev = prev.next;
			current = current.next;
		}
			prev.next = null;
	}
	void addPos(int data,int pos)
	{
		int i=0;
		Node newNode = new Node(data);
		if(head == null)
		{
			head = newNode;
			return;
		}
		if(pos!=0)
		{
			Node prev = null;
			Node current = head;
			while(current.next != null && i < pos)
			{
				prev = current;
				current = current.next;
				i++;
			}
			prev.next = newNode;
			newNode.next = current; 
		}
		else
		{
			newNode.next = head;
			head  = newNode;
		}
	}
	public void printList() 
	{
		if(head == null)
		{
			System.out.println("empty list");
			return;
		}
		Node temp = head;
		while(temp != null )
		{
			System.out.print(temp.data+"==>"+"");
			temp =   temp.next;
		}
		System.out.println("NULL");
	}
	boolean search(int data)
	{
		Node current = head;
		while(current != null)
		{
			if(current.data == data)
				return true;
			current = current.next;
		}
		return false;
	}
	void InsertAsec(int data)
	{
		Node newNode = new Node(data);
		Node currentNode = head;
		if(currentNode==null || currentNode.data>data)
		{
			newNode.next = head;
			head = newNode;
			return;
		}
		while(currentNode.next!=null && currentNode.next.data<data)
		{
			currentNode = currentNode.next;
		}
		if(currentNode.next != null)
		{
			newNode.next = currentNode.next;
			currentNode.next = newNode;
		}
		else
		{
			currentNode.next = newNode;
		}
	}
	void InsertDesc(int data)
	{
		Node newNode = new Node(data);
		Node currentNode = head;
		if(currentNode==null || currentNode.data<data)
		{
			newNode.next = head;
			head = newNode;
			return;
		}
		while(currentNode.next!=null && currentNode.next.data>data)
		{
			currentNode = currentNode.next;
		}
		if(currentNode.next != null)
		{
			newNode.next = currentNode.next;
			currentNode.next = newNode;
		}
		else
		{
			currentNode.next = newNode;
		}
	}
	void delelement(int data)
	{
		Node currentNode = head;
		if(currentNode==null)
		{
			System.out.println("empty list");
			return;
		}
		if(currentNode.data==data)
		{
			head = head.next;
			return;
		}
		while(currentNode.next != null)
		{
			if(currentNode.next.data == data)
			{
				currentNode.next = currentNode.next.next;
				return;
			}
			currentNode = currentNode.next;
		}
	}
	void delelements(int data)
	{
		Node currentNode = head;
		if(currentNode==null)
		{
			System.out.println("empty list");
			return;
		}
		if(currentNode.data == data)
		{
			head = head.next;
			size--;
		}
		while(currentNode.next != null)
		{
			if(currentNode.next.data == data)
			{
				currentNode.next = currentNode.next.next;
				size--;
			}
			else
			{
				currentNode = currentNode.next;
			}
		}
	}
	void delelementAtPos(int pos)
	{
		Node currentNode = head;
		int i=0;
		if(currentNode==null)
		{
			System.out.println("empty list");
			return;
		}
		if(pos==0)
		{
			head = head.next;
			size--;
			return;
		}
		while(currentNode.next != null && i<pos)
		{
			if(i==pos-1)
			{
				currentNode.next = currentNode.next.next;
				size--;
				return;
			}
			currentNode = currentNode.next;
			i++;
		}
	}
	void reverse()
	{
		Node current = head, prev = null, next = null;
		while(current != null)
		{
			next = current.next;
			current.next = prev;
			prev = current;
			current = next;
		}
		head = prev;
	}
	void removeDuplicates()
	{
		Node  currentNode = head;
		while(currentNode != null)
		{
			if(currentNode.next != null && currentNode.data == currentNode.next.data)
			{
				currentNode.next = currentNode.next.next;
			}
			else
			{
				currentNode = currentNode.next;
			}
		}
	}
	LL copyReverseList()
	{
		Node currentNode = head, temp1 = null, temp2 = null;
		while(currentNode != null)
		{
			temp2 = new Node(currentNode.data,temp1);
			temp1 = temp2;
			currentNode = currentNode.next;
		}
		
		LL l = new LL();
		l.head = temp1;
		return l;
	}
	LL oroginalList()
	{
		Node headNode = null, tailNode = null, tempNode = null, currentNode = head;
		if(currentNode == null)
		{
			return null;
		}
		headNode = new Node(currentNode.data,null);
		tailNode = headNode;
		currentNode = currentNode.next;
		
		while(currentNode != null)
		{
			tempNode = new Node(currentNode.data,null);
			tailNode.next = tempNode;
			tailNode = tempNode;
			currentNode = currentNode.next;
		}
				
		LL l = new LL();
		l.head = headNode;
		return l;
	}
	boolean compareList(LL list)
	{
		Node head1 = head, head2 = list.head;
		while(head1 != null && head2 != null)
		{
			if(head1.data != head2.data)
			{
				return false;
			}
			else
			{
				head1 = head1.next;
				head2 = head2.next;
			}
		}
		if(head1 == null && head2 == null)
		{
			return true;
		}
		else
		{
			return false;
		}
	}
	int nthNodefromBegin(int index)
	{
		Node currentNode = head;
		if(index > getSize() || index < 0)
		{
			return -1;
		}
		else
		{
			int count = 0;
			while(currentNode.next != null && count < index-1)
			{
				currentNode = currentNode.next;
				count++;
			}
				return currentNode.data;
		}
	}
	int nthNodefromEnd(int index)
	{
		int size = getSize();
		int sindex;
		if(size==0 && size<index)
		{
			return -1;
		}
		else
		{
			sindex = size-index+1;
		}
		return nthNodefromBegin(sindex);
	}
}
public class LinkedList1 
{
	public static void main(String[] args) 
	{
		LL list= new LL();
		list.addFirst(160);
		list.addFirst(140);
		list.addFirst(120);
		list.addFirst(100);
		list.addFirst(80);
		list.printList();
		System.out.println(list.nthNodefromBegin(1));
		System.out.println(list.nthNodefromEnd(1));
		
	/*	list.delelements(5);
		list.printList();	*/
		
	/*	LL list1 = new LL();
		list1.addLast(111);
		list1.addLast(222);
		list1.addLast(333);
		list1.printList();
		
		LL list2 = new LL();
		list2.addLast(111);
		list2.addLast(222);
		list2.addLast(333); 
		list2.printList();
		
		System.out.println(list1.compareList(list2)); */
	}		
}

