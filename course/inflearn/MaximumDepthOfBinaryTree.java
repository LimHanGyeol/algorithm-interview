/**
 * 쉽게 풀어보는 코딩 테스트 기출문제
 * Graph - Recursive, DFS, BFS
 * MaximumDepthOfBinaryTree
 */
class Solution {

    public static void main(String[] args) {
        // Recursive
        TreeNode tree = new TreeNode(3);
        tree.left = new TreeNode(1);
        tree.right = new TreeNode(4);
        tree.left.left = new TreeNode(5);
        tree.left.right = new TreeNode(8);
        tree.left.left.left = new TreeNode(7);
        System.out.println(maxDepthRecursive(tree));

        // DFS
        TreeNode treeOfDfs = new TreeNode(1);
        treeOfDfs.left = new TreeNode(2);
        treeOfDfs.right = new TreeNode(3);
        treeOfDfs.left.left = new TreeNode(4);
        treeOfDfs.left.right = new TreeNode(5);
        treeOfDfs.left.left.left = new TreeNode(6);
        System.out.println(maxDepthDfs(treeOfDfs));

        // BFS
        TreeNode treeOfBfs = new TreeNode(3);
        treeOfBfs.left = new TreeNode(1);
        treeOfBfs.right = new TreeNode(4);
        treeOfBfs.left.left = new TreeNode(5);
        treeOfBfs.left.right = new TreeNode(8);
        treeOfBfs.left.left.left = new TreeNode(7);
        System.out.println(maxDepthBfs(treeOfBfs));
    }

    private int maxDepthRecursive(TreeNode rootNode) {
        if (rootNode == null) {
            return 0;
        }
        int leftMax = maxDepthRecursive(rootNode.left);
        int rightMax = maxDepthRecursive(rootNode.right);

        return Math.max(leftMax, rightMax) + 1;
    }

    private int maxDepthDfs(TreeNode rootNode) {
        if (rootNode == null) {
            return 0;
        }

        Stack<TreeNode> stack = new Stack<>();
        Stack<Integer> valueStack = new Stack<>();

        stack.push(rootNode);
        valueStack.push(1);

        int max = 0;

        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            int count = valueStack.pop();
            max = Math.max(max, count);

            if (node.left != null) {
                stack.push(node.left);
                valueStack.push(count + 1);
            }
            if (node.right != null) {
                stack.push(node.right);
                valueStack.push(count + 1);
            }
        }
        return max;
    }

    private int maxDepthBfs(TreeNode rootNode) {
        if (rootNode == null) {
            return 0;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(rootNode);
        int count = 0;

        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
            }
            count++;
        }
        return count;
    }

    class TreeNode {
        private int value;
        private TreeNode left;
        private TreeNode right;

        public TreeNode(int value) {
            this.value = value;
        }

        @Override
        public String toString() {
            return value + " : " + left + " : " + right;
        }
    }

}
