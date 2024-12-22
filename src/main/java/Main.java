public class Main {

    public static void main(String[] args) {
        Node<Integer> l1 = new Node<>(2, new Node<>(2, new Node<>(5, new Node<>(5))));
        Node<Integer> l2 = new Node<>(2, new Node<>(4, new Node<>(6)));

        Node<Integer> resultOfEx2 = ex2(l1);
        boolean resultOfEx4 = ex4(l1);
        Node<Integer> resultOfEx5 = ex5(l1);
//        Node<Integer> mergedList = ex1(l1, l2);
//        
//	    System.out.println(mergedList);
//        printList(resultOfEx2);
//        System.out.println(resultOfEx4);
//        printList(resultOfEx5);
        System.out.println(resultOfEx5);
    }
    public static Node<Integer> ex1(Node<Integer> l1, Node<Integer> l2) {
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
        Node<Integer> dummyOfNewList = new Node<>(-1); 
        Node<Integer> current = dummyOfNewList;       
        while (l1 != null) {
            int minValue = findMin(l1);

            current.setNext(new Node<>(minValue));
            current = current.getNext();

            l1 = deleteNode(minValue, l1);
        }

        return dummyOfNewList.getNext();
    }

    public static boolean ex4(Node<Integer> l) {
    	Node<Integer> current = l;
    	
    	while (current.hasNext()) {
    		
    		Node<Integer> currentTwo = current.getNext();
    		while (currentTwo.hasNext()) {
    			
    			if (current.getValue().equals(currentTwo.getValue())) {
    				return false;
    			}
    			
    			currentTwo = currentTwo.getNext();    			
    		}
    		
    		current = current.getNext();
    	}
    	
    	return true;
    }

    public static Node<Integer> ex5(Node<Integer> l) {
        Node<Integer> newListWithDummy = new Node<Integer>(-1);
        Node<Integer> newListPointer = newListWithDummy;

        while (l != null) {
            Node<Integer> tempPointerOfNewList = newListWithDummy.getNext(); 
            boolean isDuplicate = false;
            
            // Loop on the new list
            while (tempPointerOfNewList != null) {
                // Check if the value is in the new list
                if (tempPointerOfNewList.getValue().equals(l.getValue())) {
                    isDuplicate = true;
                    break;
                }
                // Continue checking if it the node value is not found in the new list.
                tempPointerOfNewList = tempPointerOfNewList.getNext();
            }
            
            if (!isDuplicate) {
                newListPointer.setNext(new Node<Integer>(l.getValue()));
                newListPointer = newListPointer.getNext();
            }

            l = l.getNext();
        }        

        return newListWithDummy.getNext();
    }
    
//    public static int ex6(Node<Integer> head) {
//    	Node<Integer> current = head.getNext();
//    	int count = 0;
//    	
//    	while (head != null) {
//    		while (current != null )
//    	}
//    }
    
    public static Node<Integer> deleteNode(int x, Node<Integer> l1) {
        Node<Integer> dummy = new Node<>(-1);
        Node<Integer> current = dummy;
        current.setNext(l1);

        while (current.getNext() != null) {
            if (current.getNext().getValue() == x) {
                current.setNext(current.getNext().getNext());
            } else {
                current = current.getNext(); 
            }
        }

        return dummy.getNext();
    }

    public static int findMin(Node<Integer> l1) {
        if (l1 == null) {
            return Integer.MAX_VALUE; 
        }

        int minValue = findMin(l1.getNext());

        return Math.min(l1.getValue(), minValue);
    }

    public static void printList(Node<Integer> head) {
        Node<Integer> current = head;
        while (current != null) {
            System.out.print(current.getValue() + " ");
            current = current.getNext();
        }
        System.out.println();
    }
}
