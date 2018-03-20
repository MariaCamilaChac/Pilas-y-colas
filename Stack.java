import java.io.IOException;

public class Stack {
	
	public Node head= null;
	
	public boolean isEmpty() {
		
		return head == null ? true : false;
	}

	public Node Pop(){
		
		Node temp = head;
		head = head.next;
		return temp;
		
	}
	
	public void Push(Node newNode){
		
		newNode.next = head;
		head = newNode;
		
	}
	
}

