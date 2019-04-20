package linkedlist;

public class Solution2 {
	public static void main (String [] args) {
		PerfectSquareFinder process1= new PerfectSquareFinder ("Process 1", 0, 1000);
		PerfectSquareFinder process2= new PerfectSquareFinder ("Process 2", 1001, 2000);
		PerfectSquareFinder process3= new PerfectSquareFinder ("Process 3", 2001, 3000);
		PerfectSquareFinder process4= new PerfectSquareFinder ("Process 4", 3001, 4000);
		PerfectSquareFinder process5= new PerfectSquareFinder ("Process 5", 4001, 5000);
		PerfectSquareFinder process6= new PerfectSquareFinder ("Process 6", 5001, 6000);
		PerfectSquareFinder process7= new PerfectSquareFinder ("Process 7", 6001, 7000);
		PerfectSquareFinder process8= new PerfectSquareFinder ("Process 8", 7001, 8000);
		PerfectSquareFinder process9= new PerfectSquareFinder ("Process 9", 8001, 9000);
		PerfectSquareFinder process10= new PerfectSquareFinder ("Process 10", 9001, 10000);
		
		CircularLinkedList <PerfectSquareFinder> list = new CircularLinkedList <> ();
		
		    list.addLast (process1);
	        list.addLast (process2);
	        list.addLast (process3);
	        list.addLast (process4);
	        list.addLast (process5);
	        list.addLast (process6);
	        list.addLast (process7);
	        list.addLast (process8);
	        list.addLast (process9);
	        list.addLast (process10);
		
		while (!list.isEmpty()) {
	        if (!list.first().isFinished()) {
	        	list.first().run(25);
	        	list.rotate();
	        }
	        
	        else {
	        	list.removeFirst();
	        }
        }  
	}
}
