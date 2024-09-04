package DataStructures.LinkedListExample;

import java.util.Objects;

import static java.util.Optional.ofNullable;

public class LinkedList {
    private Node head;
    private Node tail;
    private long length;

    public LinkedList(int value){
        Node newNode = new Node(value);
        head = newNode;
        tail = newNode;
        length++;
    }

    static class Node {
        Integer value;
        Node next;

        Node(Integer value) {
            this.value = value;
        }
    }

    public void printList(){
        Node temp = head;
        while(temp!=null) {
            System.out.println(temp.value);
            temp = temp.next;
        }
    }

    public void append(int value) {
        Node newNode = new Node(value);
        if (length == 0) {
            head = newNode;
            tail = newNode;
        } else {
            tail.next = newNode;
            tail = newNode;
        }
        length++;
    }

    public long size() {
        return length;
    }

    public Integer peek(){
        if (Objects.nonNull(head)) {
            return head.value;
        }
        return null;
    }


    public Integer tail(){
        if (Objects.nonNull(tail)) {
            return tail.value;
        }
        return null;
    }

    public Node removeLastNode() {
        Node temp = head;
        Node prev = head;
        if (length == 0){
            return null;
        } else if(length == 1) {
            head = null;
            tail = null;
        } else {
            while(temp.next != null){
                prev = temp;
                temp = temp.next;
            }
            prev.next = null;
            tail = prev;
        }
        length--;
        return temp;
    }

    public Integer removeLast() {
        return ofNullable(removeLastNode()).map(node -> node.value).orElse(null);
    }

    public void prepend (int value) {
        Node newNode = new Node(value);
        if (length == 0) {
            head = newNode;
            tail = newNode;
        } else {
            newNode.next = head;
            head = newNode;
        }
        length++;
    }

    public Integer removeFirst() {
        Node temp = head;
        if (length == 0) {
            return null;
        } else if (length == 1) {
            head = null;
            tail = null;
        } else {
            head = temp.next;
            temp.next = null;
        }
        length --;
        return temp.value;
    }

    public Integer get(int index) {
        return getNode(index).value;
    }

    private Node getNode(int index) {
        Node temp = head;
        if (index >= 0 && index < length) {
            for (int i = 0 ; i < index; i++ ) {
                temp = temp.next;
            }
            return temp;
        } else {
            throw new ArrayIndexOutOfBoundsException("Index out of bound");
        }
    }

    public boolean set(int index, int value) {
        Node temp = getNode(index);
        if (temp != null) {
            temp.value=value;
            return true;
        }
        return false;
    }

    public Integer remove(int index) {
        if (index == 0) {
            return removeFirst();
        } else if (index == length-1) {
            return removeLast();
        } else if (index < 0 || index >= length) {
            return  null;
        } else {
            Node prev = getNode(index - 1);
            Node temp = prev.next;
            prev.next = temp.next;
            temp.next = null;
            length--;
            return temp.value;
        }
    }

    public boolean insert(int index,  int value) {
        if (index<0 || index >= length) {
            return false;
        } else if (index == 0){
            prepend(value);
            return true;
        } else if(index == length-1){
            append(value);
            return true;
        } else {
            Node newNode = new Node(value);
            Node prev = getNode(index-1);
            newNode.next = prev.next;
            prev.next = newNode;
            length++;
            return true;
        }
    }

    // hardest part.

    public void reverse() {
        Node temp = head;
        head = tail;
        tail = temp;
        Node after;
        Node before = null;
        for(int i=0;i<length-1;i++){
          after = temp.next;
          temp.next = before;
          before = temp;
          temp = after;
        }
    }
}
