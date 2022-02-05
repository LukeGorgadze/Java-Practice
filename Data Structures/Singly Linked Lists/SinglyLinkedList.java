import java.util.Arrays;
import java.util.Random;

public class SinglyLinkedList<E> {
    private static class Node<E> {
        private E element; // reference to the element stored at this node
        private Node<E> next; // reference to the subsequent node in the list

        public Node(E e, Node<E> n) {
            element = e;
            next = n;
        }

        public E getElement() {
            return element;
        }

        public Node<E> getNext() {
            return next;
        }

        public void setNext(Node<E> n) {
            next = n;
        }

        @Override
        public String toString() {
            // TODO Auto-generated method stub
            return element.toString();
        }
    }

    // instance variables of the SinglyLinkedList
    private Node<E> head = null; // head node of the list (or null if empty)
    private Node<E> tail = null; // last node of the list (or null if empty)
    private int size = 0; // number of nodes in the list

    public SinglyLinkedList() {
    } // constructs an initially empty list

    // access methods
    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public E first() { // returns (but does not remove) the first element
        if (isEmpty())
            return null;
        return head.getElement();
    }

    public E last() { // returns (but does not remove) the last element
        if (isEmpty())
            return null;
        return tail.getElement();
    }

    // update methods
    public void addFirst(E e) { // adds element e to the front of the list
        head = new Node<>(e, head); // create and link a new node
        if (size == 0)
            tail = head; // special case: new node becomes tail also
        size++;
    }

    public void addLast(E e) { // adds element e to the end of the list
        Node<E> newest = new Node<>(e, null); // node will eventually be the tail
        if (isEmpty())
            head = newest; // special case: previously empty list
        else
            tail.setNext(newest); // new node after existing tail
        tail = newest; // new node becomes the tail
        size++;
    }

    public E removeFirst() { // removes and returns the first element
        if (isEmpty())
            return null; // nothing to remove
        E answer = head.getElement();
        head = head.getNext(); // will become null if list had only one node
        size--;
        if (size == 0)
            tail = null; // special case as list is now empty
        return answer;
    }

    @Override
    public String toString() {
        // TODO Auto-generated method stub
        Node<E> temp = head;
        String res = temp.getElement().toString() + ", ";
        while (temp.getNext() != null) {
            temp = temp.getNext();
            if (temp.getNext() != null)
                res += temp.getElement() + ", ";
            else
                res += temp.getElement();
        }
        return "SinglyLinkedList: " + "{ " + res + " }";

    }

    public static void main(String[] args) {
        SinglyLinkedList<Integer> list = new SinglyLinkedList<Integer>();
        Random r = new Random();
        int randomTest = r.nextInt(0,100);
        for(int i = 0; i < randomTest; i++)
        {
            int randomInt1 = r.nextInt(0,200);
            list.addFirst(randomInt1);
        }
        System.out.println("List before modifying: \t");
        System.out.println(list);
        System.out.println("\n");
        int randomInt2 = r.nextInt(0,200);
        list.addFirst(randomInt2);
        System.out.println("List after modifying: \t");
        System.out.println(list);
        System.out.println("\n");
        int randomInt3 = r.nextInt(0,200);
        System.out.println("Adding " + randomInt3 + " to the end \t");
        list.addLast(randomInt3);
        System.out.println(list);
        System.out.println("\n");
        System.out.println("Adding " + randomInt3 + " to the start \t");
        list.addFirst(randomInt3);
        System.out.println(list);
        System.out.println("\n" + "Size of a list: " + list.size);

    }

}
