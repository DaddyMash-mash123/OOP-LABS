import java.util.Iterator;
import java.util.NoSuchElementException;

class MyLinkedList<T> implements Iterable<T> {

    // EXPLAIN: A private static nested class represents one node in the list.
    private static class Node<T> {
        T data;
        Node<T> next;

        Node(T data) {
            this.data = data;
        }
    }

    private Node<T> head;
    private Node<T> tail;

    public void add(T data) {
        Node<T> node = new Node<>(data);

        if (head == null) {
            head = node;
        } else {
            tail.next = node;
        }

        tail = node;
    }

    // EXPLAIN: The inner iterator can access the list's nodes.
    private class ListIterator implements Iterator<T> {
        private Node<T> current = head;

        @Override
        public boolean hasNext() {
            return current != null;
        }

        @Override
        public T next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }

            T value = current.data;
            current = current.next;
            return value;
        }
    }

    // EXPLAIN: Returning an Iterator enables the list to work in a for-each loop.
    @Override
    public Iterator<T> iterator() {
        return new ListIterator();
    }
}

public class LinkedListDemo {
    public static void main(String[] args) {
        MyLinkedList<String> names = new MyLinkedList<>();

        names.add("Tariro");
        names.add("Kuda");
        names.add("Rudo");

        for (String name : names) {
            System.out.println(name);
        }
    }
}

