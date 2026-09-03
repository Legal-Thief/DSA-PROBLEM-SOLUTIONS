class Solution {
    class Pair{
        String word;
        int cnt;
        Pair(String word,int cnt){
            this.word= word;
            this.cnt= cnt;
        }
    }
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Queue<Pair> q =new LinkedList<>();
        Set<String> st =new HashSet<>();
        for(String word:wordList){
            st.add(word);
        }
        st.remove(beginWord);
        q.offer(new Pair(beginWord,1));
        int maxCnt=0;
        while(!q.isEmpty()){
            Pair curr= q.poll();
            String word= curr.word;
            int cnt = curr.cnt;
            if(endWord.equals(word)) return cnt;
            for(int i=0;i<word.length();i++){
                for(char ch='a';ch<='z';ch++){
                    char[] chWord=word.toCharArray();
                    chWord[i]=ch;
                    String newWord = new String(chWord);
                    if(st.contains(newWord)){
                        st.remove(newWord);
                        q.offer(new Pair(newWord,cnt+1));
                    }
                }
            }
        }
        return 0;
    }
}