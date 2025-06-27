class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        //Binary Search Approach
        List<Integer>output = new ArrayList<>();
        int start = 0;
        int end = arr.length-k;
        while(start<end){
            int mid = start + (end - start)/2;
            int startofrange = x - arr[mid];
            int endofrange = arr[mid+k] -x;
            if(startofrange > endofrange){
                start = mid+1;
            }
            else{
                end = mid;
            }
        }
        for(int i = start ; i < start+k ; i++){
            output.add(arr[i]);
        }
        return output;

        
    }
}