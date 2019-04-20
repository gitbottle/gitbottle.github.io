package linkedlist;
// testing SinglyLinkedList clone () and equals ()method
public class DEquivalenceClone {
	public static void main (String [] args) {
		
		//Equivalence testing
		SinglyLinkedList<String> list1 = new SinglyLinkedList <> ();
		SinglyLinkedList <String> list2 = new SinglyLinkedList<> ();
		SinglyLinkedList <String> list3 = new SinglyLinkedList <> ();
		
		list1.addFirst("Hi");
		list2.addFirst("Hi");
		list3.addFirst("Hi");
		
		System.out.println (list1.equals(list2)); //prints true
		System.out.println (list1.equals(list3)); // prints true
	}
}
