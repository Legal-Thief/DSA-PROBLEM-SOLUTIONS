class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int low = 1;
        int high = 0;
        
        
        for (int pile : piles) {
            high = Math.max(high, pile);
        }
        
        int minSpeed = high;
        
        while (low <= high) {
            int mid = low + (high - low) / 2;
            
            if (canFinish(piles, h, mid)) {
                minSpeed = mid;
                high = mid - 1;
            } else {
                low = mid + 1;  
            }
        }
        
        return minSpeed;
    }
    
    private boolean canFinish(int[] piles, int h, int k) {
        long totalHours = 0;
        for (int pile : piles) {
            totalHours += (pile + k - 1) / k;
        }
        return totalHours <= h;
    }
}