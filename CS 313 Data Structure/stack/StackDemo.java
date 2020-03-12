package stack;

public class StackDemo {
	public static void main (String [] args) {
		
	//Using arrayStack	
		Stack <Integer> arrayStack = new ArrayStack <>(5); 
		
		try {
			arrayStack.push(1);
			arrayStack.push(7);
			arrayStack.push(2);
			arrayStack.push(4);
			arrayStack.push(7);
			System.out.println (arrayStack.size());//prints 5
			System.out.println (arrayStack.top());//prints 7
			arrayStack.push (9);//this will thrown an exception
			System.out.println (arrayStack.pop()); //will print 7
			 
			
		}catch (IllegalStateException e) {
			e.printStackTrace ();
			System.out.println (e.getMessage ());
		}
		
		//notice the following is not surrounded by try and catch because pop method
		//does not thrown an exception.
		System.out.println (arrayStack.pop());
	}
	
	
	
}
