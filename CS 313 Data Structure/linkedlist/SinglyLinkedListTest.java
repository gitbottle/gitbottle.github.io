package linkedlist;


public class SinglyLinkedListTest {
    public static void main(String[] args)
    {
        //what does each System.out.println print?
        SinglyLinkedList<Integer> linkedList = new SinglyLinkedList<>();
        System.out.println(linkedList.isEmpty()); //line 1

        linkedList.addFirst(23);
        linkedList.addFirst(42);
        linkedList.addFirst(12);
        linkedList.addLast(59);
        linkedList.addLast(62);

        System.out.println(linkedList.removeFirst()); //line 2
        System.out.println(linkedList.first()); //line 3
        System.out.println(linkedList.removeFirst()); //line 4
        System.out.println(linkedList.isEmpty()); //line 5
        System.out.println(linkedList.secondToLast());
    }
}