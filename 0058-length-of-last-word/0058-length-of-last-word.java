class Solution {
    public int lengthOfLastWord(String s) {
        int c=0;
        for(int i=s.length()-1;i>=0;i--){
            char ch=s.charAt(i);
            if(ch!=' '){
                c++;
            }else if(c!=0){
                break;
            }
        }
        return c;
    }
}