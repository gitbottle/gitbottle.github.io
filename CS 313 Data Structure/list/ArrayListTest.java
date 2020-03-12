package list;

public class ArrayListTest {
	public static void main(String[] args)
    {
        List<Integer> arrayList = new FixedArrayList<>();
        //what would happen if the next line was not commented out- will get indexout of bounds exception from checkIndex method
        //System.out.println(arrayList.get(1));
        arrayList.add(2);
        arrayList.add(1);
        arrayList.add(1, 3);
        arrayList.add(4);
        arrayList.add(0, 8);
        arrayList.add(9);
        //8 2 3 1 4 9
        System.out.println(arrayList.set(0, 7)); //line 1- prints 8 
        // 7 2 3 1 4 9
        System.out.println(arrayList.remove(1)); //line 2- prints 2
        // 7 3 1 4 9
        System.out.println(arrayList.get(1)); //line 3 -prints 3
        
        //what would happen if we did not comment out these lines?-- IllegalStateException. array is full
        //for(int i=0; i<6; i++) 
       //     arrayList.add(1);
    }
}
