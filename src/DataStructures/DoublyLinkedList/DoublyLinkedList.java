package DataStructures.DoublyLinkedList;

import static java.util.Optional.ofNullable;

public class DoublyLinkedList {
    Node head;
    Node tail;
    int length = 0;

    class Node {
        int value;
        Node next;
        Node prev;

        Node(int value){
           this.value = value;
        }
    }

    public DoublyLinkedList(int value){
        Node newNode = new Node(value);
        head = newNode;
        tail = newNode;
        length++;
    }

    public void getHead() {
        System.out.println("head: "+ head.value);
    }

    public void getTail() {
        System.out.println("tail: "+ tail.value);
    }

    public void getLength(){
        System.out.println("length: "+ length);
    }

    public void printList() {
        Node temp = head;
        while (temp != null) {
            System.out.println(temp.value);
            temp = temp.next;
        }
    }

    public boolean append(int value) {
        Node newNode = new Node(value);
        if (length == 0){
            head = newNode;
            tail = newNode;
        } else {
            newNode.prev = tail;
            tail.next = newNode;
            tail = newNode;
        }
        length++;
        return true;
    }

    public void printfromEnd(){
        Node temp = tail;
        while (temp != null){
            System.out.println(temp.value);
            temp = temp.prev;
        }
    }

    public Integer removeLast(){
        Node temp = tail;
        if (length == 0) {
            return null;
        } else if (length ==1){
            head = null;
            tail = null;
        } else {
            tail = temp.prev;
            tail.next = null;
            temp.prev =null;
        }
        length --;
        return temp.value;
    }

    public void prepend(int value){
        Node newNode = new Node(value);
        if (length == 0) {
            head = newNode;
            tail = newNode;
        } else {
            newNode.next = head;
            head.prev = newNode;
            head = newNode;
        }
        length++;
    }

    public Integer removeFirst(){
        Node temp = head;
        if(length == 0){
            return null;
        } else if(length == 1){
            head = null;
            tail = null;
        } else {
            head = head.next;
            head.prev = null;
            temp.next = null;

        }
        length--;
        return temp.value;
    }

    public Integer get(int index) {
        return ofNullable(getNode(index)).map(node -> node.value).orElse(null);
    }

    // important method to check
    // In order to increase efficiency we used both head and tail
    public Node getNode(int index){
        Node temp = head;
        if (index < 0 || index >= length) {
            return null;
        }
        if (index < length/2) {
            for (int i = 0; i < index; i++) {
                temp = temp.next;
            }
        } else {
            temp = tail;
            for (int i = length-1; i > index; i--) {
                temp = temp.prev;
            }
        }
        return temp;
    }

    public boolean set(int index, int value){
        Node temp = getNode(index);
        if (temp != null){
            temp.value = value;
            return true;
        }
        return false;
    }

    public boolean insert(int index, int value){
        Node newNode = new Node(value);
        if (index < 0 || index > length) return false;
        if (index == 0) {
            prepend(value);
            return true;
        } else if (index == length) {
            append(value);
            return true;
        } else {
            Node before = getNode(index-1);
            Node after = before.next;
            newNode.next = after;
            newNode.prev = before;
            after.prev = newNode;
            before.next = newNode;
            length++;
        }
        return true;
    }


    public Integer remove(int index) {
        if (index < 0 || index >= length)return null;
        if (index == 0) {
            return removeFirst();
        } else if (index == length-1){
            return removeLast();
        } else {
            Node temp = getNode(index);
            Node before = temp.prev;
            Node after = temp.next;
            temp.prev = null;
            temp.next = null;
            before.next = after;
            after.prev = before;
            length--;
            return temp.value;
        }
    }
}


class Runner {

    public static void main(String[] args){
        DoublyLinkedList list = new DoublyLinkedList(5);
        String line= "----------------";

        list.append(9);
        list.append(10);
        list.printList();
        list.getTail();
        list.getHead();

        list.printfromEnd();

        System.out.println(list.removeLast());
        list.printList();
        System.out.println(list.removeLast());
        list.printList();
        list.getTail();
        list.getHead();

        list.prepend(0);
        list.prepend(1);
        list.prepend(2);
        list.printList();
        System.out.println("getting the value at 1 index: "+list.get(1));
        System.out.println("removing first:" + list.removeFirst());
        System.out.println();
        list.printList();
        list.insert(1,4);
        System.out.println(line);
        list.printList();

        System.out.println(line);
        System.out.println(list.remove(2));
        System.out.println(list.remove(0));
        System.out.println(line);
        list.printList();
    }
}
