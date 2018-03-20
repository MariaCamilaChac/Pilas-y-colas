
public class Queue {
	
	public Node head=null;
	
	public boolean isEmpty() {
		
		return head == null ? true : false;
	}

	public void enquece(Node newNode){
	
		newNode.next = head;
		head = newNode;
	
	}

	public Node dequece(){
	
		Node temp;
		Node Pre = head;
	
		while(Pre.next.next != null) {
			Pre = Pre.next;
		}
	
		temp = Pre.next;
		Pre.next = null;
		System.gc();
		return temp;
	
	}
	

}
