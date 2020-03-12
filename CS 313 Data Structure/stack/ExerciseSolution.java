package stack;

public class ExerciseSolution {
	
	public static void transfer (Stack S, Stack T) {
		while (!S.isEmpty()) {
			T.push(S.pop());
		}
	}
	
	public static void main (String [] args) {
		Stack <Integer> S = new LinkedList <>();
		
		S.push(5);
		S.push(4);
		S.push(3);
		S.push(2);
		S.push(1);
		
		reverseStack(S);
		System.out.println(S.top());
		
		
	}
	
	 static void reverseStack(Stack s) {
	        Stack<Integer> temp1 = new LinkedList<>();
	        Stack<Integer> temp2 = new LinkedList<>();
	        transfer(s, temp1);
	        transfer(temp1, temp2);
	        transfer(temp2, s);

	        //why do we need the temporary stacks?
	}
	
}
