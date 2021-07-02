package algorithm.tree;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static algorithm.util.InputReader.init;
import static algorithm.util.IntegerParser.toInt;

/**
 * BaekJoon. 1068
 * 트리
 * Graph - GraphSearch, Tree, DFS
 */
public class Tree {

    private static int n;
    private static int root;
    private static int erased;
    private static List<Integer>[] child;
    private static int[] leaf;

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = init();
        n = toInt(bufferedReader.readLine());
        child = new ArrayList[n];
        leaf = new int[n];

        for (int i = 0; i < n; i++) {
            child[i] = new ArrayList<>();
        }

        String[] parentNode = bufferedReader.readLine().split(" ");

        for (int i = 0; i < n; i++) {
            int parent = toInt(parentNode[i]);
            if (parent == -1) {
                root = i;
                continue;
            }
            child[parent].add(i);
        }
        erased = toInt(bufferedReader.readLine());

        // 자식 중에서 erased를 지운다.
        for (int i = 0; i < n; i++) {
            if (child[i].contains(erased)) {
                child[i].remove(child[i].indexOf(erased));
            }
        }

        // 루트가 아니라면 dfs로 재귀 순회 한다.
        if (root != erased) {
            dfs(root);
        }
        System.out.println(leaf[root]);
    }

    private static void dfs(int x) {
        if (child[x].isEmpty()) {
            leaf[x] = 1;
        }
        for (int y : child[x]) {
            dfs(y);
            leaf[x] += leaf[y];
        }
    }
}
