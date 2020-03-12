package project3_files;

public class HeapTest {
	public static void main (String [] args) {
		/*
		PriorityQueue <Integer, String> heapPQ = new LinkedHeapPQ<>();
		   
        heapPQ.insert(4, "Sven");
        heapPQ.insert(11, "Helga");
        heapPQ.insert(23, "William");
        heapPQ.insert(3, "Olaf");
        System.out.println(heapPQ.insert(7, "Vlad").getValue()); //line 1
        System.out.println("Current size: " + heapPQ.size()); //line 2
        System.out.println(heapPQ.min().getValue()); //line 3
        System.out.println(heapPQ.removeMin().getValue()); //line 4
        System.out.println(heapPQ.min().getValue()); //line 5
        System.out.println(heapPQ.min().getKey()); //line 6
        System.out.println("Current size: " + heapPQ.size());
		*/
		
		Integer [] key = {4, 11, 23, 3, 7};
		String [] value= {"Sven", "Helga", "William", "Olaf", "Vlad"};
		PriorityQueue <Integer, String> heapPQ = new LinkedHeapPQ<>(key, value);
		System.out.println("Current size: " + heapPQ.size()); //5
		System.out.println(heapPQ.min().getValue()); //Olaf
		System.out.println(heapPQ.removeMin().getValue());//Olaf
		System.out.println(heapPQ.min().getValue()); //Sven
		System.out.println(heapPQ.min().getKey()); //4
		
		
	}

}
