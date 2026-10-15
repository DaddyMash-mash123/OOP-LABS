import java.util.ArrayList;
import java.util.EmptyStackException;
class Stack<T> {
    // EXPLAIN: The stack contains a list to store its elements.
    private final ArrayList<T> elements = new ArrayList<>();
    public void push(T item) {
        // EXPLAIN: Add an item to the top of the stack.
        elements.add(item);
    }
    public T pop() {
        // EXPLAIN: A stack cannot remove an item when it is empty.
        if (elements.isEmpty()) {
            throw new EmptyStackException();
        }
        // EXPLAIN: Remove and return the last item added.
        return elements.remove(elements.size() - 1);
    }
    public boolean isEmpty() {
        // EXPLAIN: Report whether the stack contains any elements.
        return elements.isEmpty();
    }
    public int size() {
        // EXPLAIN: Return the number of items in the stack.
        return elements.size();
    }
}
public class StackDemo {
    public static void main(String[] args) {
        // EXPLAIN: Create a stack of strings.
        Stack<String> stack = new Stack<>();
        // EXPLAIN: Push items onto the stack.
        stack.push("First");
        stack.push("Second");
        stack.push("Third");
        // EXPLAIN: Pop removes items in last-in, first-out order.
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println("Items remaining: " + stack.size());
    }
}



