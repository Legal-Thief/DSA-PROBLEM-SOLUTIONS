class Solution {

    public int check(int[] arr, int mid, int k) {
        int cnt = 0;
        int c_cnt = 0;

        for (int i = 0; i < arr.length; i++) {

            if (arr[i] <= mid) {
                cnt++;
            } else {
                cnt = 0;
            }

            if (cnt == k) {
                c_cnt++;
                cnt = 0;
            }
        }

        return c_cnt;
    }

    public int minDays(int[] bloomDay, int m, int k) {

        int low = 0;
        int high = 0;

        for (int i : bloomDay) {
            high = Math.max(high, i);
        }

        int ans = -1;

        while (low <= high) {

            int mid = low + (high - low) / 2;

            if (check(bloomDay, mid, k) >= m) {
                ans = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        return ans;
    }
}