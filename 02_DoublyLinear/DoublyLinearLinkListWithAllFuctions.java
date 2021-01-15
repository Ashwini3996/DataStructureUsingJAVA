import java.lang.*;
import java.util.*;

class Node
{
	public int data;
	public Node next;
	public Node prev;
	
	public Node(int value)
	{
		data = value;
		next =null;
		prev = null;
	}
}

class DoublyLinkedList
{
	public Node Head;
	private int size = 0;
	
	public DoublyLinkedList()
	{
		Head = null;
	}
	
    public void InsertFirst(int data)
	{
		Node newn = new Node(data);
        newn.data = data;
        newn.next = null;
        newn.prev = null;		
		
		if(Head == null)
		{
			Head = newn;
		}
		else
		{
		   newn.next = Head;
           Head.prev = newn;
           Head = newn;		   
		}		
		size++;
	}	
	
	public void InsertLast(int data)
	{
		Node newn = new Node(data);
        newn.data = data;
        newn.next = null;
        newn.prev = null;		
		
		if(Head == null)
		{
			Head = newn;
		}
		else
		{
		   Node temp = Head;
		   
		   while(temp.next != null)
		   {
			   temp = temp.next;
		   }			   
		   temp.next = newn;
		   newn.prev = temp; 
		}		
		size++;
	}
	
	public void InsertAtPos(int data, int pos)
	{
		int count = Count();
		
		if(pos <=0 || pos > count+1)
		{
			System.out.println("Error : Invalid Position!");
			return;
		}
		
		if(pos == 1)
		{
			InsertFirst(data);
		}
		else if(pos == count+1)
		{
			InsertLast(data);
		}
		else
		{
			Node newn = new Node(data);
			newn.data = data;
			newn.next = null;
			newn.prev = null;
		
			Node temp = Head;
			for(int i = 1; i < pos-1; i++)
		    {
				temp = temp.next;
			}		
		    newn.next = temp.next;
			temp.next.prev = newn;
			temp.next = newn;
			newn.prev = temp;
			
			size++;
		}
	}
	
	public void DeleteFirst()
	{
	   if(Head == null)
   	   {
		   System.out.println(" Linked List is Empty !");
		   return;
	   }		  
	   else
       {
		   if(Head.next == null)
			{
				 Head = null;
			}
			else
			{
			   Head = Head.next;
			   Head.prev = null;
			}
	   }
	  System.out.println("Node Deletd Succesfully!");
      size--;
	}
	 
	public void DeleteLast()
	{
       if(Head == null)
   	   {
		   System.out.println(" Linked List is Empty !");
		   return;
	   }	   
	   else
	   {
		    if(Head.next == null)
			{
				 Head = null;
			}
			else
			{
				 Node temp = Head;	 
				 while(temp.next.next != null)
				 {
					temp = temp.next;	 
				 }
				  temp.next =null;
			}
	   }
	  System.out.println("Node Deletd Succesfully!"); 
      size--;		
	}
	
	public void DeleteAtPos(int pos)
	{
		int count = Count();
		
		if(pos <= 0 || pos > count)
		{
			System.out.print("Error: Invalid Argument!");
			return;
		}
		
		if(pos == 1)
		{
			DeleteFirst();
		}
		else if(pos == count)
		{
			DeleteLast();
		}
		else
		{
			Node temp = Head;
			for(int i=1; i < pos-1; i++)
			{
				temp = temp.next;
			}
			temp.next = temp.next.next;
			temp.next.prev = temp;
			
			 System.out.println("Node Deletd Succesfully at pos:"+pos); 
             size--;
		}
	}
	
	public void Display()
	{
		Node temp = Head;
		
		while(temp != null)
		{
			System.out.print("|"+ temp.data+"|<=>");
			temp = temp.next;
		}
		System.out.print("NULL");
		System.out.println();		
	}
	
	public int Count()
	{
		return size;
	}
}

class DoublyLinearLinkListWithAllFuctions
{
	public static void main(String args[])
	{
	   int value = 0, pos =0, choice = 1, cnt =0;
	   
	   DoublyLinkedList obj = new DoublyLinkedList();
       Scanner sobj = new Scanner(System.in);
	   while(choice != 0)
	   {
			System.out.println("---------------------------------------");	
			System.out.println(" DOUBLY LINKED LIST USING JAVA");
			System.out.println("---------------------------------------");	
			System.out.println("1: Insert First");
			System.out.println("2: Insert Last");
			System.out.println("3: Insert At Pos");
			System.out.println("4: Delete First");
			System.out.println("5: Delete Last");
			System.out.println("6: Delete At Pos");
			System.out.println("7: Display"); 
			System.out.println("8: Count");
			System.out.println("---------------------------------------");	
		 
			System.out.println("Enter your choice");
			choice = sobj.nextInt();

       
			switch(choice)
			{
			 
			 case 1: System.out.println("Enter value:");
			         value = sobj.nextInt();
					 obj.InsertFirst(value);
					 break;
			
             case 2: System.out.println("Enter value:");
			         value = sobj.nextInt();
					 obj.InsertLast(value);
					 break;			
			
			 case 3: System.out.println("Enter value:");
			         value = sobj.nextInt();
					 
					 System.out.println("Enter position:");
					 pos = sobj.nextInt();
					 
					 obj.InsertAtPos(value, pos);
					  break;
			 
			 case 4: obj.DeleteFirst();
                     break;
             
			 case 5: obj.DeleteLast();
                     break;	
             
             case 6: System.out.println("Enter position:");
					 pos = sobj.nextInt();
					
					 obj.DeleteAtPos(pos);
					  break;						  			 
			 
			 case 7: obj.Display();
                      break;			  
					  
		     case 8: cnt = obj.Count(); 
			          System.out.println("Number of elements from Linked List:"+cnt);
					  break;
			}
		}			
		
       System.out.println("Thank you!");
       obj.Head = null;	   
	}	
}