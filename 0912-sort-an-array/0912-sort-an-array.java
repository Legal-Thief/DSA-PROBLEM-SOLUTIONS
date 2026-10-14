class Solution {
    public int[] sortArray(int[] nums) {
        mergeSort(nums,nums.length);
        return nums;
    }

    public void mergeSort(int[] nums, int length){
        if(length<2){
            return;
        }

        int mid = length/2;
        int[] left = new int[mid];
        int[] right= new int[length-mid];
        for(int i=0;i<mid;i++){
            left[i]=nums[i];
        }
        for(int i=0;i<nums.length-mid;i++){
            right[i]=nums[i+mid];
        }

        mergeSort(left,mid);
        mergeSort(right,length-mid);

        merge(nums, left,right ,mid,length-mid);
    }

    public void merge(int[] arr, int[] left,int[] right,int l,int r){
        int i=0;
        int j=0;
        int k=0;
        while(i<l && j<r){
            if(left[i]<=right[j]){
                arr[k++]=left[i++];
            }else{
                arr[k++] = right[j++];
            }
        }

        while(i<l){
            arr[k++]=left[i++];
        }

        while(j<r){
            arr[k++]=right[j++];
        }
    }
}