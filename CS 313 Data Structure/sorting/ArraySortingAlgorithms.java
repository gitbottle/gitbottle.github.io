package sorting;

public class ArraySortingAlgorithms {
	   public static void insertionSort(char[] data)
	    {
	        for (int k= 1; k<data.length; k++) {
	        	char current = data[k];
	        	int j = k;
	        	
	        	while (j>0 && data[j-1] > current) {
	        		data[j] = data[j-1];
	        		j--;
	        	}
	        	
	        	data[j] = current;
	        }
	}
	   
	   public static void insertionSort2(char[]data) {
		   for (int i=0; i<data.length; i++) {
			   char current= data[i];
			   int j = i;
			   
			   while(j>0 && data[j-1]>current) {
				   data[j] = data[j-1];
				   j--;
			   }
			   data[j]= current;
		   }
	   }
	   
	   public static void selectionSort (char [] data) {
		   for (int i = 0; i<data.length; i++) {
			   int lowestIndex = i;
			   for (int j = i+1; j<data.length; j++ ) {
				   if (data[lowestIndex] > data[j]) 
					   lowestIndex = j;
			   }
			   
			   char smallest = data[lowestIndex];
			   data[lowestIndex] = data[i];
			   data[i]= smallest;
			   
		   }
	   }
	   
	   public static void selectionSort2(char [] data) {
		   for (int i=0; i<data.length; i++) {
			   int lowestIndex = i;
			   
			   for(int j=i+0; j<data.length; j++) {
				   if(data[j]<data[lowestIndex])
					   lowestIndex= j;
			   }
			   
			   char smallest = data[lowestIndex];
			   data[lowestIndex] = data[i];
			   data[i]= smallest;
		   }
	   }
	   
	   
	   public static void main (String[] args) {
			char [] data = {'D','C','A','F','B'};
			
			 System.out.print(" Before sort: ");
			for(int i=0; i<data.length; i++)
	        {
	            System.out.print(data[i]);
	        }
	        insertionSort(data);
	        System.out.print("\n After insertion sort ");
	        for(int i=0; i<data.length; i++)
	        {
	            System.out.print(data[i]);
	        }
	        

	        char[] data2 =  {'f', 'y', 'a', 'a', 'c', 'b'};
	        System.out.print("\n Before sort: ");
	        for(int i=0; i<data2.length; i++)
	        {
	            System.out.print(data2[i]);
	        }
	        selectionSort(data2);
	        System.out.print("\n After selection sort ");
	        for(int i=0; i<data2.length; i++)
	        {
	            System.out.print(data2[i]);
	}
		}
	   
	   
}               
