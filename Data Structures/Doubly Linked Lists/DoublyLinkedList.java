import java.util.Random;

public class DoublyLinkedList<E> {
    // ---------------- nested Node class ----------------
    private static class Node<E> {
        private E element; // reference to the element stored at this node
        private Node<E> prev; // reference to the previous node in the list
        private Node<E> next; // reference to the subsequent node in the list

        public Node(E e, Node<E> p, Node<E> n) {
            element = e;
            prev = p;
            next = n;
        }

        public E getElement() {
            return element;
        }

        public Node<E> getPrev() {
            return prev;
        }

        public Node<E> getNext() {
            return next;
        }

        public void setPrev(Node<E> p) {
            prev = p;
        }

        public void setNext(Node<E> n) {
            next = n;
        }

        @Override
        public String toString() {
            // TODO Auto-generated method stub
            return element.toString();
        }
    } // ----------- end of nested Node class -----------

    // instance variables of the DoublyLinkedList
    private Node<E> header; // header sentinel
    private Node<E> trailer; // trailer sentinel
    private int size = 0; // number of elements in the list

    public DoublyLinkedList() {
        header = new Node<>(null, null, null); // create header
        trailer = new Node<>(null, header, null); // trailer is preceded by header
        header.setNext(trailer); // header is followed by trailer
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public E first() {
        if (isEmpty())
            return null;
        return header.getNext().getElement(); // first element is beyond header
    }

    public E last() {
        if (isEmpty())
            return null;
        return trailer.getPrev().getElement(); // last element is before trailer
    }
    // public update methods

    public void addFirst(E e) {
        addBetween(e, header, header.getNext()); // place just after the header
    }

    public void addLast(E e) {
        addBetween(e, trailer.getPrev(), trailer); // place just before the trailer
    }

    public E removeFirst() {
        if (isEmpty())
            return null; // nothing to remove
        return remove(header.getNext()); // first element is beyond header
    }

    public E removeLast() {
        if (isEmpty())
            return null; // nothing to remove
        return remove(trailer.getPrev()); // last element is before trailer
    }

    // private update methods

    private void addBetween(E e, Node<E> predecessor, Node<E> successor) {
        // create and link a new node
        Node<E> newest = new Node<>(e, predecessor, successor);
        predecessor.setNext(newest);
        successor.setPrev(newest);
        size++;
    }

    private E remove(Node<E> node) {
        Node<E> predecessor = node.getPrev();
        Node<E> successor = node.getNext();
        predecessor.setNext(successor);
        successor.setPrev(predecessor);
        size--;
        return node.getElement();
    }

    @Override
    public String toString() {
        // TODO Auto-generated method stub
        Node<E> temp = header.getNext();
        String res = " ";
        if (temp != null)
            res = temp.getElement().toString() + ", ";
        while (temp.getNext() != trailer) {
            temp = temp.getNext();
            if (temp.getNext() != null && temp.getNext() != trailer)
                res += temp.getElement() + ", ";
            else
                res += temp.getElement();
        }
        return "DoublyLinkedList: " + "{ " + res + " }";

    }

    public static void main(String[] args) {
        DoublyLinkedList<Integer> list = new DoublyLinkedList<Integer>();
        Random r = new Random();
        int randomTest = r.nextInt(0, 20);
        for (int i = 0; i < randomTest; i++) {
            int randomInt1 = r.nextInt(0, 200);
            list.addFirst(randomInt1);
        }
        System.out.println("List before modifying: \t");
        System.out.println(list);
        System.out.println("\n");
        int randomInt2 = r.nextInt(0, 200);
        list.addFirst(randomInt2);
        System.out.println("List after modifying: \t");
        System.out.println(list);
        System.out.println("\n");
        int randomInt3 = r.nextInt(0, 200);
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
        System.out.println("Removing " + randomInt3 + " from the end \t");
        list.removeLast();
        System.out.println(list);
        System.out.println("\n" + "Size of a list: " + list.size());
    }
}
