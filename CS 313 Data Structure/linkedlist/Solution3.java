package linkedlist;

public class Solution3 {
	public static void main (String [] args) {
		SinglyLinkedList <PrimeFinder> singlyList = new SinglyLinkedList <> ();
		
		PrimeFinder process1= new PrimeFinder ("Process 1", 0, 1000);
        PrimeFinder process2= new PrimeFinder ("Process 2", 1001, 2000);
        PrimeFinder process3= new PrimeFinder ("Process 3", 2001, 3000);
        PrimeFinder process4= new PrimeFinder ("Process 4", 3001, 4000);
        PrimeFinder process5= new PrimeFinder ("Process 5", 4001, 5000);
        PrimeFinder process6= new PrimeFinder ("Process 6", 5001, 6000);
        PrimeFinder process7= new PrimeFinder ("Process 7", 6001, 7000);
        PrimeFinder process8= new PrimeFinder ("Process 8", 7001, 8000);
        PrimeFinder process9= new PrimeFinder ("Process 9", 8001, 9000);
        PrimeFinder process10= new PrimeFinder ("Process 10", 9001, 10000);
        
        singlyList.addLast(process1);
        singlyList.addLast(process2);
        singlyList.addLast(process3);
        singlyList.addLast(process4);
        singlyList.addLast(process5);
        singlyList.addLast(process6);
        singlyList.addLast(process7);
        singlyList.addLast(process8);
        singlyList.addLast(process9);
        singlyList.addLast(process10);
       
    
       
       
        while (!singlyList.isEmpty()) {
	        if (!singlyList.first().isFinished()) {
	        	singlyList.first().run(25);
	        	singlyList.addLast(singlyList.removeFirst());
	        }
	        
	        else {
	        	singlyList.removeFirst();
	        }
        } 
       
       
	}
	
	
}
