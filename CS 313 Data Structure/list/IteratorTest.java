package list;
import java.util.Iterator;

public class IteratorTest {
	public static void main (String [] args) {
		List <Integer> list = new ArrayList <> ();
		
		list.add(1);
		list.add(2);
		list.add(3);
		list.add(4);
		list.add(5);
		
		Iterator <Integer> iterator1 = list.iterator();
		
		while (iterator1.hasNext()) {
			//You have to capture the element when iterator passes 
			//if you want to use it more than once because Iterator keeps moving onto the next
			Integer i = iterator1.next();
			System.out.println (i);
			if (i==3) {
				System.out.println ("removing" + i);
				iterator1.remove(); // it removes the one that we passed just now
			}
		}
		
		System.out.println ("current size = " + list.size()); // prints out 4
		
		for (Integer integer: list) {
			System.out.println (integer);
		}
		
		
	}
}
