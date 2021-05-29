package algorithm.structure.linked;

public class SingleLinkedList<T> {

    private Node<T> head = null;

    public void addNode(T data) {
        if (head == null) {
            head = new Node<>(data);
        } else {
            Node<T> node = this.head;
            while (node.getNext() != null) {
                node = node.getNext();
            }
            node.setNext(new Node<>(data));
        }
    }

    /**
     * Ex) 1, 99 노드 중간에 55가 들어갈 경우
     *
     * @param data
     * @param frontData
     */
    public void addNodeInside(T data, T frontData) {
        Node<T> finedNode = find(frontData); // 1

        if (finedNode == null) {
            addNode(data);
        } else {
            Node<T> previousNextNode = finedNode.getNext(); // 99
            finedNode.setNext(new Node<>(data)); // 1의 next를 55로 변경
            Node<T> changedNextNode = finedNode.getNext(); // 1, 55
            changedNextNode.setNext(previousNextNode); // 55의 next를 99로 변경
        }
    }

    private Node<T> find(T data) {
        if (this.head == null) {
            return null;
        }

        Node<T> node = this.head;
        while (node != null) {
            if (node.getData() == data) {
                return node;
            } else {
                node = node.getNext();
            }
        }
        return null;
    }

    public boolean deleteNode(T data) {
        if (this.head == null) {
            return false;
        }
        Node<T> node = this.head;
        if (node.getData() == data) { // 지우려는 노드가 head라면 다음 노드를 head로 변경한다.
            this.head = this.head.getNext();
            return true;
        } else {
            while (node.getNext() != null) {
                if (node.getNext().getData() == data) {
                    node.setNext(node.getNext().getNext());
                    return true;
                }
                node = node.getNext();
            }
            return false;
        }
    }


    public Node<T> getHead() {
        return head;
    }

    public T getData() {
        return head.getData();
    }

    public Node<T> getNext() {
        return head.getNext();
    }

    public Node<T> getLastNode() {
        if (head != null) {
            Node<T> node = this.head;
            while (node.getNext() != null) {
                node = node.getNext();
            }
            return node;
        }
        return null;
    }

    public int size() {
        int quantity = 0;
        Node<T> node = this.head;
        while (node.getData() != null) {
            quantity++;
            if (node.getNext() == null) {
                break;
            }
            node = node.getNext();
        }
        return quantity;
    }

    public void printAll() {
        if (head != null) {
            Node<T> node = this.head;
            System.out.println(node.getData());
            while (node.getNext() != null) {
                node = node.getNext();
                System.out.println(node.getData());
            }
        }
    }
}
