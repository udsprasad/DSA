package DataStructures.LinkedListExample;

public class Runner {

    public static void main(String[] args){
        LinkedList list = new LinkedList(5);

        list.printList();

        list.append(9);
        list.append(10);
        System.out.println("tailValue: "+ list.tail());
        System.out.println("headValue: "+ list.peek());

        list.removeLast();
        list.removeLast();
        list.removeLast();
        list.printList();
        System.out.println("tailValue: "+ list.tail());
        System.out.println("headValue:"+ list.peek());

        list.prepend(0);
        list.prepend(1);
        list.prepend(2);
        System.out.println("getting the value at 1 index: "+list.get(1));
        System.out.println(list.size());
        System.out.println("removing first:" + list.removeFirst());
        System.out.println("tailValue: "+ list.tail());
        System.out.println("headValue:"+ list.peek());

        System.out.println(list.remove(2));
        System.out.println(list.size());
        System.out.println(list.remove(0));
        list.append(1);
        list.append(2);
        list.append(3);
        list.printList();
        list.reverse();
        list.printList();
    }
}
