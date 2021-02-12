/**
 * 쉽게 풀어보는 코딩 테스트 기출문제
 * Graph - DFS
 * WordLadder
 */
class Solution {

    public static void main(String[] args) {
        String[] words = new String[]{"hot", "dot", "dog", "lot", "log", "cog"};
        List<String> wordList = Arrays.asList(words);

        // 5
        System.out.println(getLadderLengthNeighbor("hit", "cog", wordList));
    }

    public int getLadderLengthNeighbor(String beginWord, String endWord, List<String> wordList) {
        if (wordList == null || !wordList.contains(endWord)) {
            return 0;
        }

        Queue<String> queue = new LinkedList<>();
        Set<String> dictionary = new HashSet<>(wordList);

        queue.offer(beginWord);
        dictionary.add(endWord);
        dictionary.remove(beginWord);
        int level = 1;

        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                String prevWord = queue.poll();

                if (prevWord != null && prevWord.equals(endWord)) {
                    return level;
                }

                for (String neighbor : neighbors(prevWord, wordList)) {
                    queue.offer(neighbor);
                }
            }
            level++;
        }
        return 0;
    }

    private List<String> neighbors(String targetWord, List<String> wordList) {
        List<String> results = new LinkedList<>();
        Set<String> dictionary = new HashSet<>(wordList);

        for (int i = 0; i < targetWord.length(); i++) {
            char[] chars = targetWord.toCharArray();

            for (char chracter = 'a'; chracter <= 'z'; chracter++) {
                chars[i] = chracter;
                String word = String.valueOf(chars);

                if (dictionary.remove(word)) {
                    results.add(word);
                }
            }
        }
        return results;
    }

}
