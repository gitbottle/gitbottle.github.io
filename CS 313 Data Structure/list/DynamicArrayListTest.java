package list;

public class DynamicArrayListTest {
	public static void main(String[] args)
    {
        List<Integer> arrayList = new ArrayList<>(3);
        //System.out.println(arrayList.get(1));-- will throw index out of bounds exception
        arrayList.add(2);
        arrayList.add(1);
        arrayList.add(3);
        arrayList.add(4);
        arrayList.add(8);
        arrayList.add(9);
        System.out.println(arrayList.get(1)); //line 1 -- prints 1
        System.out.println(arrayList.set(0, 7)); //line 2 - prints 2
        System.out.println(arrayList.remove(1)); //line 3 - prints 1
        System.out.println(arrayList.get(1)); //line 4 - prints 3
}
}
