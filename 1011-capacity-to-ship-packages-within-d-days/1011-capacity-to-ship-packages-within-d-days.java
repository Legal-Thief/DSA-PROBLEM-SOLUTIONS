class Solution {
    public int shipWithinDays(int[] weights, int days) {

        int low = 0;
        int high = 0;

        for (int weight : weights) {
            low = Math.max(low, weight);
            high += weight;
        }

        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (c_check(weights, mid, days)) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        return low;
    }

    public boolean c_check(int[] arr, int capacity, int days) {

        int usedDays = 1;
        int currentWeight = 0;

        for (int weight : arr) {

            if (currentWeight + weight > capacity) {
                usedDays++;
                currentWeight = 0;
            }

            currentWeight += weight;
        }

        return usedDays <= days;
    }
}