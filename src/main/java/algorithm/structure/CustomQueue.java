package algorithm.structure;

import java.util.ArrayList;
import java.util.List;

public class CustomQueue<T> {

    private static final int FIRST_INDEX = 0;

    private List<T> queue = new ArrayList<>();

    public void enqueue(T item) {
        queue.add(item);
    }

    public T dequeue() {
        if (queue.isEmpty()) {
            return null;
        }
        return queue.remove(FIRST_INDEX);
    }

    public boolean isEmpty() {
        return queue.isEmpty();
    }

    public int size() {
        return queue.size();
    }
}
