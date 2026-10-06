class Solution {

    public boolean canMake(int[] bloomDay, int day, int m, int k) {
        int flowers = 0;
        int bouquets = 0;

        for (int x : bloomDay) {

            if (x <= day) {
                flowers++;

                if (flowers == k) {
                    bouquets++;
                    flowers = 0;

                    if (bouquets == m) {
                        return true;
                    }
                }

            } else {
                flowers = 0;
            }
        }

        return false;
    }

    public int minDays(int[] bloomDay, int m, int k) {

        if ((long) m * k > bloomDay.length) {
            return -1;
        }

        int low = 1;
        int high = 0;

        for (int x : bloomDay) {
            high = Math.max(high, x);
        }

        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (canMake(bloomDay, mid, m, k)) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        return low;
    }
}