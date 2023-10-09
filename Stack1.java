package com.practice;
import java.util.*;
class Stackarray
{
	int size =5;
	int top = -1;
	int a[];
	Stackarray()
	{
		 a = new int[size];
	}
	boolean isEmpty()
	{
		return top ==-1;
	}
	int getSize()
	{
		return size = top+1;
	}
	void push(int data)
	{
		if(getSize() == a.length)
		{
			System.out.println("stack overflow");
		}
		else
		{
			top++;
			a[top] = data;
		}
	}
	void print()
	{
		if(isEmpty())
		{
			System.out.println("empty stack");
		}
		else
		{
			for(int i=0; i<=top; i++)
			{
				System.out.print(a[i]+" ");
			}
			System.out.println();
		}
	}
	int pop()
	{
		if(isEmpty())
		{
			System.out.println("stack underflow");
			return -1;
		}
		else
		{
			int data = a[top];
			top--;
			return data;
		}	
	}
	int peek()
	{
		return a[top];
	}
	boolean search(int data)
	{
		if(isEmpty())
		{
			System.out.println("stack underflow");
			return false;
		}
		else
		{
			for(int i=0; i<=top; i++)
			{
				if(a[i] == data)
				{
					return true;
				}
			}
			return false;
		}
	}
}
public class Stack1 
{
	public static void main(String[] args)
	{
		Stack<Integer> s = new Stack<Integer>(); 
		System.out.println(s.empty());
		s.push(111);
		s.push(222);
		s.push(333);
		s.push(444);
		s.push(555);
		System.out.println(s);
		System.out.println(s.empty());
	}
}
