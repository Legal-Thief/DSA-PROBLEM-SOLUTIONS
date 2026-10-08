class Solution {
    public int candy(int[] ratings) {
        int n = ratings.length;
        if (n == 0) return 0;

        int sum = 1;
        int i = 1;

        while (i < n) {
            if (ratings[i] == ratings[i - 1]) {
                sum += 1;
                i++;
                continue;
            }

            int up = 0;
            while (i < n && ratings[i] > ratings[i - 1]) {
                up++;
                sum += up + 1;   
                i++;
            }

            int down = 0;
            while (i < n && ratings[i] < ratings[i - 1]) {
                down++;
                sum += down;    
                i++;
            }

            
            sum += Math.max(0, down - up);
        }

        return sum;
    }
}