import java.lang.*;
import java.util.*;

class Node
{
	public int data;
	public Node next;
	
	public Node(int value)
	{
		data = value;
		next = null;
	}
}

class SinglyCircularLinkedList
{
	public Node Head;
	public Node Tail;
	private int size =0;
	
	SinglyCircularLinkedList()
	{
		Head = null;
		Tail = null;
	}
	
	public void InsertFirst(int data)
	{
		Node newn = new Node(data);
		
		if((Head == null) && (Tail == null))//linked list Empty
		{
			Head = newn;
			Tail = newn;
		}
		else                               //At least one node
		{
			newn.next = Head;
			Head = newn;
		}
		
		Tail.next = Head;
		size++;
	}	
	
	public void InsertLast(int data)
	{
		Node newn = new Node(data);
		
		if((Head == null) && (Tail == null))//linked list Empty
		{
			Head = newn;
			Tail = newn;
		}
		else                               //At least one node
		{
			Tail.next = newn;
			Tail = newn;
		}
		
		Tail.next = Head;
		size++;
	}
	
	public void InsertAtPos(int data, int pos)
	{
		int count = Count();
		
		if(pos <=0 || pos > count+1)
		{
			System.out.println("Invalid Position");
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
			Node newn =new Node(data);
			Node temp = Head;
			
			for(int i=1; i< pos-1;i++)
			{
				temp = temp.next;
			}
		
		    newn.next = temp.next;
            temp.next =newn;			
			
			size++;
		}
	}
	
	public void DeleteFirst()
	{
		if((Head  == null) && (Tail == null))//Linked List Empty
		{
			System.out.println("Linked List is Empty!");
			return;
		}
		
		if(Head == Tail) // single Node
		{
			Head = null;
			Tail = null;
			
			System.out.println("Node Deletd Successfully!");
			size--;
			return ;
		} 
		else         //Multiple Nodes
		{
			Head = Head.next;
			
			Tail.next = Head;
			
			System.out.println("Node Deletd Successfully!");
			size--;
		}		
	}
	
	public void DeleteLast()
	{
		if((Head  == null) && (Tail == null))//Linked List Empty
		{
			System.out.println("Linked List is Empty!");
			return;
		}
		
		if(Head == Tail) // single Node
		{
			Head = null;
			Tail = null;
			
			System.out.println("Node Deletd Successfully!");
			size--;
			return ;
		} 
		else         //Multiple Nodes
		{
			Node temp = Head;
			while(temp.next != Tail)
			{
				temp = temp.next; 
			}
			Tail = temp;
			
			Tail.next = Head;
			
			System.out.println("Node Deletd Successfully!");
			size--;
		}		
	}
	
	public void DeleteAtPos(int pos)
	{
		int count = Count();
		
		if(pos <= 0 || pos > count)
		{
			System.out.println("Error : Invalid Position !");
            return ; 
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
			for(int i =1; i < pos-1; i++)
			{
               temp = temp.next;				
			}
			temp.next = temp.next.next;
		
   		size--;
		System.out.println("Node deleted succesfully fron pos :"+pos);
		}
	}	
	
	public void Display()
	{
		if((Head == null) && (Tail == null))
		{
			System.out.println("Linked list is Empty!");
			return;
		}
		
		do
		{
			System.out.print("<-|"+ Head.data+"|->");
	        Head = Head.next;		
		}
		while(Head != Tail.next);
		System.out.println();
	}
	
	public int Count()
	{
		return size;
	}
}


class SinglyCircularLinkListWithAllFuctions
{
  public static void main(String arr[]) throws Exception
  {
     int choice= 1, value = 0, pos=0, cnt=0;
	 
     SinglyCircularLinkedList obj = new SinglyCircularLinkedList();	 
     Scanner sobj = new Scanner(System.in);
	  
	  while(choice != 0)
	  {
		  System.out.println("------------------------------------------");
		  System.out.println("SINGLY CIRCULAR LINKED LIST USING JAVA");
		  System.out.println("------------------------------------------");
		  System.out.println("1: Insert First");
	      System.out.println("2: Insert Last");
		  System.out.println("3: Insert At Pos");
		  System.out.println("4: Delete First");
		  System.out.println("5: Delete Last");
		  System.out.println("6: Delete At Pos");
		  System.out.println("7: Display");
		  System.out.println("8: Count");
		  System.out.println("0: Exit");
		  System.out.println("------------------------------------------");
		  
		  System.out.println("Enter your choice:");
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
      
	  System.out.println("Thank You!");
	  obj.Head = null;
  }
}
