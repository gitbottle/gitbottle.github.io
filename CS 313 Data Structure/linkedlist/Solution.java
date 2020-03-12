package linkedlist;

public class Solution {
	public static void main (String [] args) {
		
		CircularLinkedList <PrimeFinder> list = new CircularLinkedList <> ();
		
		
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
