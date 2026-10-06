class Solution {
    public int getMax(int[] nums) {
        int max = Integer.MIN_VALUE;
        for (int i : nums) {
            max = Math.max(max, i);
        }
        return max;
    }

    public int smallestDivisor(int[] nums, int threshold) {
        int low = 1;
        int high = getMax(nums);
        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (getSum(nums, mid) <= threshold) {
                high = mid-1;
            }else{
                low = mid+1;
            }
        }

        return low;
    }

    private int getSum(int[] nums, int divisor) {
        int sum = 0;

        for (int num : nums) {
            sum += (num + divisor - 1) / divisor;
        }

        return sum;
    }
}