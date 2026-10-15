import java.util.ArrayList;

class Stack<T> {
    private final ArrayList<T> items = new ArrayList<>();

    // EXPLAIN: push adds an item to the top of the stack.
    public void push(T item) {
        items.add(item);
    }

    // EXPLAIN: pop removes and returns the most recently added item.
    public T pop() {
        if (isEmpty()) {
            throw new IllegalStateException("Stack is empty");
        }
        return items.remove(items.size() - 1);
    }

    // EXPLAIN: peek returns the top item without removing it.
    public T peek() {
        if (isEmpty()) {
            throw new IllegalStateException("Stack is empty");
        }
        return items.get(items.size() - 1);
    }

    public boolean isEmpty() {
        return items.isEmpty();
    }
}

public class GenericStackDemo {
    public static void main(String[] args) {
        Stack<String> stack = new Stack<>();

        stack.push("Java");
        stack.push("Collections");
        stack.push("Generics");

        System.out.println("Top: " + stack.peek());
        System.out.println("Removed: " + stack.pop());
        System.out.println("Top now: " + stack.peek());
        System.out.println("Is empty? " + stack.isEmpty());
    }
}

