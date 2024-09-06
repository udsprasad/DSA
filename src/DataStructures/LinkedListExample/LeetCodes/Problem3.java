package DataStructures.LinkedListExample.LeetCodes;

public class Problem3 {

    private Node head;
    private Node tail;

    class Node {
        int value;
        Node next;

        Node(int value) {
            this.value = value;
        }
    }

    public Problem3(int value) {
        Node newNode = new Node(value);
        head = newNode;
        tail = newNode;
    }

    public Node getHead() {
        return head;
    }

    public Node getTail() {
        return tail;
    }

    public void printList() {
        Node temp = head;
        while (temp != null) {
            System.out.println(temp.value);
            temp = temp.next;
        }
    }

    public void printAll() {
        if (head == null) {
            System.out.println("Head: null");
            System.out.println("Tail: null");
        } else {
            System.out.println("Head: " + head.value);
            System.out.println("Tail: " + tail.value);
        }
        System.out.println("\nLinked List:");
        if (head == null) {
            System.out.println("empty");
        } else {
            printList();
        }
    }

    public void makeEmpty() {
        head = null;
        tail = null;
    }

    public void append(int value) {
        Node newNode = new Node(value);
        if (head == null) {
            head = newNode;
            tail = newNode;
        } else {
            tail.next = newNode;
            tail = newNode;
        }
    }

    public Node findKthFromEnd(int k) {
        Node slow = head;
        Node fast = head;
        for (int i=0;i<k;i++){
            if (fast == null){
                return null;
            }
            fast = fast.next;
        }
        while(fast!=null){
            slow = slow.next;
            fast = fast.next;
        }
        return slow;
    }

    // WRITE FINDKTHFROMEND METHOD HERE //
    //                                  //
    //                                  //
    //                                  //
    //                                  //
    //////////////////////////////////////

}




class Runner3 {

    public static void main(String[] args) {
        Problem3 myLinkedList = new Problem3(1);
        myLinkedList.append(2);
        myLinkedList.append(3);
        myLinkedList.append(4);
        myLinkedList.append(5);

        int k = 2;
        int result = myLinkedList.findKthFromEnd(k).value;

        System.out.println(result); // Output: 4

        /*
            EXPECTED OUTPUT:
            ----------------
            4

        */

    }

}

/*LL: Find Kth Node From End ( ** Interview Question)
Implement a method called findKthFromEnd that returns the k-th node from the end of the list.

If the list has fewer than k nodes, the method should return null.

Note: This implementation of the Linked List class does not have the length attribute.

Method signature:

public Node findKthFromEnd(int k)


Example:

LinkedList myList = new LinkedList(1);
myList.append(2);
myList.append(3);
myList.append(4);
myList.append(5);

Node result = myList.findKthFromEnd(2); // Output: Node with value 4

result = myList.findKthFromEnd(5); // Output: Node with value 1

result = myList.findKthFromEnd(6); // Output: null


Note:

In this problem, you should use the two-pointer technique to efficiently find the k-th node from the end of the linked list.

*/
