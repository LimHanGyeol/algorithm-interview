package algorithm.structure.linked;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class SingleLinkedListTest {

    @Test
    void create() {
        // given
        SingleLinkedList<Integer> linkedList = new SingleLinkedList<>();

        // when
        linkedList.addNode(1);

        // then
        assertThat(linkedList.getData()).isEqualTo(1);
        assertThat(linkedList.getNext()).isNull();
    }

    @Test
    void addNode() {
        // given
        SingleLinkedList<Integer> linkedList = new SingleLinkedList<>();
        linkedList.addNode(1);

        // when
        linkedList.addNode(2);

        // then
        assertThat(linkedList.getHead().getData()).isEqualTo(1);
        assertThat(linkedList.getNext().getData()).isEqualTo(2);
        assertThat(linkedList.getNext().getNext()).isNull();
        linkedList.printAll();
    }

    @Test
    @DisplayName("LinkedList 중간에 데이터 추가")
    void addNodeInside() {
        // given
        SingleLinkedList<Integer> linkedList = new SingleLinkedList<>();
        linkedList.addNode(1);
        linkedList.addNode(99);

        // when
        linkedList.addNodeInside(55, 1);

        // then
        assertThat(linkedList.getHead().getNext().getData()).isEqualTo(55);
    }

    @Test
    @DisplayName("LinkedList 끝에 데이터 추가")
    void addNodeLast() {
        // given
        SingleLinkedList<Integer> linkedList = new SingleLinkedList<>();
        linkedList.addNode(1);
        linkedList.addNode(99);

        // when
        linkedList.addNodeInside(55, 99);

        // then
        assertThat(linkedList.getLastNode().getData()).isEqualTo(55);
    }

    @Test
    @DisplayName("기존에 없는 노드에 데이터 추가")
    void addNodeAfterNonExistNode() {
        // given
        SingleLinkedList<Integer> linkedList = new SingleLinkedList<>();
        linkedList.addNode(1);
        linkedList.addNode(30);

        // when
        linkedList.addNodeInside(55,99);

        // then
        assertThat(linkedList.getLastNode().getData()).isEqualTo(55);
        assertThat(linkedList.size()).isEqualTo(3);
    }

    @Test
    void deleteNode() {
        // given
        SingleLinkedList<Integer> linkedList = new SingleLinkedList<>();
        linkedList.addNode(1);
        linkedList.addNode(99);
        linkedList.addNode(55);
        // when
        linkedList.deleteNode(99);

        // then
        assertThat(linkedList.size()).isEqualTo(2);
        assertThat(linkedList.getLastNode().getData()).isEqualTo(55);
    }

    @Test
    void deleteHeadNode() {
        // given
        SingleLinkedList<Integer> linkedList = new SingleLinkedList<>();
        linkedList.addNode(1);
        linkedList.addNode(99);
        linkedList.addNode(55);

        // when
        linkedList.deleteNode(1);

        // then
        assertThat(linkedList.size()).isEqualTo(2);
        assertThat(linkedList.getHead().getData()).isEqualTo(99);
        assertThat(linkedList.getLastNode().getData()).isEqualTo(55);
    }

    @Test
    void deleteLastNode() {
        // given
        SingleLinkedList<Integer> linkedList = new SingleLinkedList<>();
        linkedList.addNode(1);
        linkedList.addNode(99);
        linkedList.addNode(55);

        // when
        linkedList.deleteNode(55);

        // then
        assertThat(linkedList.size()).isEqualTo(2);
        assertThat(linkedList.getHead().getData()).isEqualTo(1);
        assertThat(linkedList.getLastNode().getData()).isEqualTo(99);
    }

    @Test
    void cantDeleteNode() {
        // given
        SingleLinkedList<Integer> linkedList = new SingleLinkedList<>();
        linkedList.addNode(1);
        linkedList.addNode(10);
        linkedList.addNode(22);

        // when
        boolean result = linkedList.deleteNode(30);

        assertThat(result).isFalse();
        assertThat(linkedList.size()).isEqualTo(3);
    }
}
