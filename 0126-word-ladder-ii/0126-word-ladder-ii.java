class Solution {
    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        Set<String> st = new HashSet<>(wordList);

        List<List<String>> ans = new ArrayList<>();

        if (!st.contains(endWord)) {
            return ans;
        }

        Map<String, List<String>> parent = new HashMap<>();

        Queue<String> q = new LinkedList<>();
        q.offer(beginWord);

        st.remove(beginWord);

        boolean found = false;

        while (!q.isEmpty() && !found) {

            int size = q.size();

            Set<String> levelVisited = new HashSet<>();

            for (int j = 0; j < size; j++) {

                String curr = q.poll();
                char[] arr = curr.toCharArray();

                for (int i = 0; i < arr.length; i++) {

                    char original = arr[i];

                    for (char ch = 'a'; ch <= 'z'; ch++) {

                        if (ch == original) {
                            continue;
                        }

                        arr[i] = ch;
                        String next = new String(arr);

                        if (!st.contains(next)) {
                            continue;
                        }

                        parent
                                .computeIfAbsent(next, k -> new ArrayList<>())
                                .add(curr);

                        if (next.equals(endWord)) {
                            found = true;
                        }

                        levelVisited.add(next);
                    }

                    arr[i] = original;
                }
            }

            st.removeAll(levelVisited);

            for (String word : levelVisited) {
                q.offer(word);
            }
        }

        List<String> path = new ArrayList<>();
        path.add(endWord);
        dfs(endWord,beginWord, path, parent, ans);

        return ans;
    }

    public void dfs( String word, String beginWord, List<String> path, Map<String, List<String>> parent,
            List<List<String>> ans) {
                if(word.equals(beginWord)){
                    List<String> temp = new ArrayList<>(path);
                    Collections.reverse(temp);
                    ans.add(temp);
                    return;
                }
                if(!parent.containsKey(word)){
                    return;
                }

                for(String p:parent.get(word)){
                    path.add(p);
                    dfs(p,beginWord, path,parent, ans);
                    path.remove(path.size()-1);
                }

    }
}