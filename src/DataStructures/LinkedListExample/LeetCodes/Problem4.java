package DataStructures.LinkedListExample.LeetCodes;

public class Problem4 {

    private Node head;
    private int length;

    class Node {
        int value;
        Node next;

        Node(int value) {
            this.value = value;
        }
    }

    public Problem4(int value) {
        Node newNode = new Node(value);
        head = newNode;
        length = 1;
    }

    public Node getHead() {
        return head;
    }

    public int getLength() {
        return length;
    }

    public void printList() {
        Node temp = head;
        while (temp != null) {
            System.out.println(temp.value);
            temp = temp.next;
        }
    }

    public void printAll() {
        if (length == 0) {
            System.out.println("Head: null");
        } else {
            System.out.println("Head: " + head.value);
        }
        System.out.println("Length:" + length);
        System.out.println("\nLinked List:");
        if (length == 0) {
            System.out.println("empty");
        } else {
            printList();
        }
    }

    public void makeEmpty() {
        head = null;
        length = 0;
    }

    public void append(int value) {
        Node newNode = new Node(value);
        if (head == null) {
            head = newNode;
        } else {
            Node current = head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = newNode;
        }
        length++;
    }

    public void partitionList(int x){
        if (length == 0){
            return;
        }
        Node temp =head;
        Node headDummy = new Node(0);
        Node tailDummy = new Node(0);
        Node tailIterator = tailDummy;
        Node headIterator = headDummy;
        for(int i=0;i<length;i++) {
            if (x <= temp.value) {
                tailIterator.next = temp;
                tailIterator = temp;

            } else {

                headIterator.next = temp;
                headIterator = temp;
            }
            temp = temp.next;
        }

        tailIterator.next = null;
        headIterator.next = tailDummy.next;
        head = headDummy.next;

    }

    // WRITE THE PARTITIONLIST METHOD HERE //
    //                                     //
    //                                     //
    //                                     //
    //                                     //
    /////////////////////////////////////////

}


class Runner4 {

    public static void main(String[] args) {

        // Create a new LinkedList and append values to it
        Problem4 ll = new Problem4(3);
        ll.append(5);
        ll.append(8);
        ll.append(10);
        ll.append(2);
        ll.append(1);

        // Print the list before partitioning
        System.out.println("LL before partitionList:");
        ll.printList(); // Output: 3 5 8 10 2 1

        // Call the partitionList method with x = 5
        ll.partitionList(8);

        // Print the list after partitioning
        System.out.println("LL after partitionList:");
        ll.printList(); // Output: 3 2 1 5 8 10

        /*
            EXPECTED OUTPUT:
            ----------------
            LL before partition_list:
            3
            5
            8
            10
            2
            1
            LL after partition_list:
            3
            2
            1
            5
            8
            10

        */

    }

}


/*LL: Partition List ( ** Interview Question)
⚠️ CAUTION: Advanced Challenge Ahead!

This Linked List problem is significantly more challenging than the ones we've tackled so far. It's common for students at this stage to find this exercise demanding, so don't worry if you're not ready to tackle it yet. It's perfectly okay to set it aside and revisit it later when you feel more confident.

If you decide to take on this challenge, I strongly advise using a hands-on approach: grab a piece of paper and visually map out each step.

This problem requires a clear understanding of how elements in a Linked List interact and move. By now, you've observed numerous Linked List animations in the course, which have prepared you for this moment.

This exercise will be a true test of your ability to apply those concepts practically. Remember, patience and persistence are key here!

Now, here is the exercise:

___________________________________



You have a singly linked list that DOES NOT HAVE A TAIL POINTER  (which will make this method simpler to implement).

Given a value x you need to rearrange the linked list such that all nodes with a value less than x come before all nodes with a value greater than or equal to x.

Additionally, the relative order of nodes in both partitions should remain unchanged.


Constraints:

The solution should traverse the linked list at most once.

The solution should not create a new linked list.


Input:

A singly linked list and an integer x.


Output:

The same linked list but rearranged as per the above criteria.


Function signature:

public void partitionList(int x);


Details:

The function partitionList takes an integer x as a parameter and modifies the current linked list in place according to the specified criteria. If the linked list is empty (i.e., head is null), the function should return immediately without making any changes.



Example 1:

Input:

Linked List: 3 -> 8 -> 5 -> 10 -> 2 -> 1 x: 5

Process:

Values less than 5: 3, 2, 1

Values greater than or equal to 5: 8, 5, 10

Output:

Linked List: 3 -> 2 -> 1 -> 8 -> 5 -> 10





Example 2:
Input:

Linked List: 1 -> 4 -> 3 -> 2 -> 5 -> 2 x: 3

Process:

Values less than 3: 1, 2, 2

Values greater than or equal to 3: 4, 3, 5

Output:

Linked List: 1 -> 2 -> 2 -> 4 -> 3 -> 5





Tips:

While traversing the linked list, maintain two separate chains: one for values less than x and one for values greater than or equal to x.

Use dummy nodes to simplify the handling of the heads of these chains.

After processing the entire list, connect the two chains to get the desired arrangement.



Note:

The solution must maintain the relative order of nodes. For instance, in the first example, even though 8 appears before 5 in the original list, the partitioned list must still have 8 before 5 as their relative order remains unchanged.

Note:

You must solve the problem WITHOUT MODIFYING THE VALUES in the list's nodes (i.e., only the nodes' next pointers may be changed.)*/


