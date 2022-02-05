import java.util.Random;

public class CircularlyLinkedList<E> {
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

    // instance variables of the CircularlyLinkedList
    private Node<E> tail = null; // we store tail (but not head)
    private int size = 0; // number of nodes in the list

    public CircularlyLinkedList() {
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
        return tail.getNext().getElement(); // the head is *after* the tail
    }

    public E last() { // returns (but does not remove) the last element
        if (isEmpty())
            return null;
        return tail.getElement();
    }

    // update methods
    public void rotate() { // rotate the first element to the back of the list
        if (tail != null) // if empty, do nothing
            tail = tail.getNext(); // the old head becomes the new tail
    }

    public void addFirst(E e) { // adds element e to the front of the list
        if (size == 0) {
            tail = new Node<>(e, null);
            tail.setNext(tail); // link to itself circularly
        } else {
            Node<E> newest = new Node<>(e, tail.getNext());
            tail.setNext(newest);
        }
        size++;
    }

    public void addLast(E e) { // adds element e to the end of the list
        addFirst(e); // insert new element at front of list
        tail = tail.getNext(); // now new element becomes the tail
    }

    public E removeFirst() { // removes and returns the first element
        if (isEmpty())
            return null; // nothing to remove
        Node<E> head = tail.getNext();
        if (head == tail)
            tail = null; // must be the only node left
        else
            tail.setNext(head.getNext()); // removes ”head” from the list
        size--;
        return head.getElement();
    }
    @Override
    public String toString() {
        // TODO Auto-generated method stub
        Node<E> temp = tail.getNext();
        String res = temp.getElement().toString() + ", ";
        while (temp.getNext() != tail.getNext()) {
            temp = temp.getNext();
            if (temp.getNext() != null)
                res += temp.getElement() + ", ";
            else
                res += temp.getElement();
        }
        return "CircularlyLinkedList: " + "{ " + res + " }";

    }
    public static void main(String[] args) {
        CircularlyLinkedList<Integer> list = new CircularlyLinkedList<Integer>();
        Random r = new Random();
        int randomTest = r.nextInt(0,20);
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
        System.out.println("\n");
        System.out.println("Removing " + randomInt3 + " from the start \t");
        list.removeFirst();
        System.out.println(list);
        System.out.println("\n");
        System.out.println("Rotating List \t");
        list.rotate();
        System.out.println(list);
        System.out.println("\n");
        System.out.println("Rotating List again\t");
        list.rotate();
        System.out.println(list);
        System.out.println("\n" + "Size of a list: " + list.size);
    }
}