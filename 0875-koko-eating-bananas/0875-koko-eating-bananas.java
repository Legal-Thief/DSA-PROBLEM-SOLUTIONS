class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int low = 1;
        int high = 0;

        for (int pile : piles) {
            high = Math.max(high, pile);
        }

        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (getSum(piles, mid) <= h) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        return low;
    }

    private long getSum(int[] nums, int divisor) {
        long sum = 0;

        for (int num : nums) {
            sum += (num + (long) divisor - 1) / divisor;
        }

        return sum;
    }
}