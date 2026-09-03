class Solution {
    class Pair {
        String word;
        int cnt;

        Pair(String word, int cnt) {
            this.word = word;
            this.cnt = cnt;
        }
    }

    public int ladderLength(String beginWord, String endWord, List<String> wordList) {

        Set<String> st = new HashSet<>(wordList);

        if (!st.contains(endWord)) {
            return 0;
        }

        Queue<Pair> q = new LinkedList<>();

        q.offer(new Pair(beginWord, 1));
        st.remove(beginWord);

        while (!q.isEmpty()) {

            Pair curr = q.poll();

            String word = curr.word;
            int cnt = curr.cnt;

            if (word.equals(endWord)) {
                return cnt;
            }

            char[] arr = word.toCharArray();

            for (int i = 0; i < arr.length; i++) {

                char original = arr[i];

                for (char ch = 'a'; ch <= 'z'; ch++) {

                    if (ch == original) {
                        continue;
                    }

                    arr[i] = ch;

                    String newWord = new String(arr);

                    if (st.contains(newWord)) {
                        st.remove(newWord);
                        q.offer(new Pair(newWord, cnt + 1));
                    }
                }

                arr[i] = original;
            }
        }

        return 0;
    }
}