package algorithm.structure;

import java.util.ArrayList;
import java.util.List;

public class CustomStack<T> {

    private List<T> stack = new ArrayList<>();

    public void push(T item) {
        stack.add(item);
    }

    public T pop() {
        if (stack.isEmpty()) {
            return null;
        }
        final int lastIndex = getLastIndex();
        return stack.remove(lastIndex);
    }

    public T peek() {
        if (stack.isEmpty()) {
            return null;
        }
        final int lastIndex = getLastIndex();
        return stack.get(lastIndex);
    }

    private int getLastIndex() {
        return stack.size() - 1;
    }

    public boolean isEmpty() {
        return stack.isEmpty();
    }

    public int size() {
        return stack.size();
    }
}
