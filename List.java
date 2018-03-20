
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;

public class List {
	
	public Node head = null; //Empty list

	
	public boolean isEmpty() {
		
		return head == null ? true : false;
	}
	
	public void InsertAtBegin(Node newNode){
		
		newNode.next = head;
		head = newNode;
		
	}
	
	public void InsertAtEnd(Node newNode) {
		if (isEmpty()) {
			head = newNode;
		}else {
			Node temp = head;
			while(temp.next != null) {	
				temp = temp.next;
			}
		
			temp.next = newNode;	
	
		}
	}
	
	public void InsertAtInedex(Node newNode , int index){
		
		Node temp;
		Node pre = head;
		
		for (int i = 0; i < index - 1; i++) {
			pre = pre.next;
		}
		
		temp = pre.next;
		newNode.next = temp;
		pre.next = newNode;
		
	}
	
	public void DeleteAtBegin(){
		
		Node temp = head;
		head = head.next;
		temp = null;
		System.gc();
		
	}
	
	public void DeleteAtEnd(){
		
		Node temp;
		Node Pre = head;
		
		while(Pre.next.next != null) {
			Pre = Pre.next;
		}
		
		temp = Pre.next;
		Pre.next = null;
		temp = null;
		System.gc();
		
	}
	
	public void DeleteAtIndex(int index) {
		
		Node temp = head;
		
		for (int i = 0; i < index - 1; i++) {
			temp = temp.next;
		}
		
		Node toDelete = temp.next;
		temp.next = toDelete.next;
		toDelete = null;
		System.gc();
		
	}
	
	public void reverse(){
		
		Stack tempList = new Stack();
		Node temp = head;
		
		while(temp != null) {
			
			tempList.Push(temp.clone());
			temp = temp.next;
			
		}
		
		head = tempList.head;
		
	}
	
	public void PrintList() throws IOException {
		
		BufferedWriter bw = new BufferedWriter (new OutputStreamWriter(System.out));
		
		Node temp = head;
		while(temp != null) {
			
			bw.write(temp.toString());
			temp = temp.next;
		}
		
		bw.flush();
		bw.close();
	}
	
	public void quickSort() {
	
		if (!isEmpty()) {
		
			List leftSet = new List ();
			List rightSet =  new List ();

			Node temp = head.next;
			Node pivot = temp;	
		
	
			while (temp != null){
			
				if ( temp.value < pivot.value) //cambiar dependiendo el parametro
				
				
					leftSet.InsertAtEnd(temp.clone());
		
				else
				
					rightSet.InsertAtEnd(temp.clone());
				
				temp = temp.next;
		}
		
		leftSet.quickSort();
		rightSet.quickSort();
		pivot.next=rightSet.head;
		leftSet.InsertAtEnd(pivot);
		head = leftSet.head;
		
	}
	}
	
	public int LenghtList() {
		
		int counter =0;
		Node temp=head;
		while (temp != null) {
			counter++;
			temp=temp.next;
		}
		return counter;
	}
	
	
	public Node getNode(int index) {
		
		if(LenghtList()< index)
			return null;
		
		else {
			Node temp=head;
			for (int i = 0; i < index; i++) {
				temp=temp.next;
				
			}
			return temp;
			
		}
	
	}
	
	public Node binarySearch() {
		int max = LenghtList(); 
		int min =0;
		int middle = (max + min)/2;
		
return null;		
	}

	
	public static void main(String[] args) throws IOException {
		
		List student = new List();
		
		student.InsertAtBegin(new Node ("Paula", 22, 561556));
		student.InsertAtEnd(new Node("camila ", 22,2434));
		student.InsertAtBegin(new Node("Juan", 23,2345676));
		student.InsertAtInedex(new Node("pepe", 23,2345676), 1);

		student.quickSort();
		student.DeleteAtBegin();
		student.DeleteAtEnd();
		student.PrintList();

		
	}

}
