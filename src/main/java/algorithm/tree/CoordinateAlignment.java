package algorithm.tree;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import static algorithm.util.InputReader.init;
import static algorithm.util.IntegerParser.toInt;

/**
 * BaekJoon. 11650
 * 좌표 정렬하기
 * Sort
 */
public class CoordinateAlignment {

    public static void main(String[] args) throws IOException {
        List<Node> result = input();
        sort(result);
        print(result);
    }

    private static List<Node> input() throws IOException {
        BufferedReader bufferedReader = init();
        String inputN = bufferedReader.readLine();
        int n = toInt(inputN);

        List<Node> result = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            String[] input = bufferedReader.readLine().split(" ");
            int x = toInt(input[0]);
            int y = toInt(input[1]);

            result.add(new Node(x, y));
        }
        return result;
    }

    private static void sort(List<Node> result) {
        result.sort(new Comparator<Node>() {
            @Override
            public int compare(Node o1, Node o2) {
                if (o1.x == o2.x) {
                    return o1.y - o2.y;
                }
                return o1.x - o2.x;
            }
        });
    }

    private static void print(List<Node> result) {
        result.stream()
                .map(node -> node.x + " " + node.y)
                .forEach(System.out::println);
    }

    static class Node {
        int x;
        int y;

        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
