class Solution {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals,(a,b)->{return Integer.compare(a[0],b[0]);});
        ArrayList<int[]> list = new ArrayList<>();
        int[] newInterval = intervals[0];
        list.add(newInterval);
        for(int[] i:intervals){
            if(i[0]<=newInterval[1]){
                newInterval[1]=Math.max(newInterval[1],i[1]);
            }else{
                newInterval= i;
                list.add(newInterval);
            }
        }

        return list.toArray(new int[list.size()][]);
    }
}