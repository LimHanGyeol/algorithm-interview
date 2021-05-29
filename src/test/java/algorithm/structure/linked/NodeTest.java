package algorithm.structure.linked;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class NodeTest {

    @Test
    void node() {
        // given
        Node<Integer> node1 = new Node<>(1);
        Node<Integer> node2 = new Node<>(2);

        // when
        node1.setNext(node2);
        Node<Integer> head = node1;

        // then
        assertThat(head.getData()).isEqualTo(1);
        assertThat(head.getNext().getData()).isEqualTo(2);
    }
}
