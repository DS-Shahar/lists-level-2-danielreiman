
public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		 Node<Integer> l1 = new Node<>(2, new Node<>(-1, new Node<>(5)));
	    Node<Integer> l2 = new Node<>(2, new Node<>(4, new Node<>(6)));

	     Node<Integer> mergedList = ex1(l1, l2);
	        
	    System.out.println(mergedList);
	}
	
	public static Node<Integer> ex1(Node<Integer> l1, Node<Integer> l2)
	{
		Node<Integer> head = new Node<Integer>(-1, null);
		Node<Integer> current = head;
		
			
		while(l2 != null && l1 != null) {
			if (l1.getValue() >= l2.getValue()) {
				current.setNext(new Node<Integer>(l2.getValue()));
				l2 = l2.getNext();
			} else {
				current.setNext(new Node<Integer>(l1.getValue()));
				l1 = l1.getNext();
			}

			current = current.getNext();
		}
		
		return head.getNext();
	}
  
	public static Node<Integer> ex2(Node<Integer> l1) {
		Node<Integer> dummy = new Node<Integer>(-1);
		Node<Integer> current = l1;
		
		while(current.hasNext()) {
			int x = findMin(l1);
			dummy.setNext(new Node<Integer>(x));
			
			current = deleteNode(x, l1);

			current = current.getNext();
		}
		
		return dummy.getNext();
	}
	
	public static Node<Integer> deleteNode(int x, Node<Integer> l1) {
		Node<Integer> dummy = new Node<Integer>(-1);
		Node<Integer> current = dummy;
		
		while (current.hasNext()) {
			if (current.getNext().getValue() == x) {
				current.setNext(current.getNext().getNext());
			}
			
			current = current.getNext();
		}
		
		return dummy.getNext();
	}
	
	public static int findMin(Node<Integer> l1) {
		if (l1.getNext() == null)
			return l1.getValue();
		
		if (l1 == null)
			return -1;
		
		return Math.min(l1.getValue(), findMin(l1.getNext()));
	}
}
