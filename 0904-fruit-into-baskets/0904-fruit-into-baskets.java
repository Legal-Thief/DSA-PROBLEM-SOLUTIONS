class Solution {
    public int totalFruit(int[] fruits) {
        HashMap<Integer, Integer> hm = new HashMap<>();
        int l = 0;
        int r = 0;
        int max = 0;

        while (r < fruits.length) {
            int fruit = fruits[r];

            hm.put(fruit, hm.getOrDefault(fruit, 0) + 1);

            while (hm.size() > 2) {
                int leftFruit = fruits[l];

                hm.put(leftFruit, hm.get(leftFruit) - 1);

                if (hm.get(leftFruit) == 0) {
                    hm.remove(leftFruit);
                }

                l++;
            }

            max = Math.max(max, r - l + 1);
            r++;
        }

        return max;
    }
}