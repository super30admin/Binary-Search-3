
// TimeComplexity : O(log(n-k))
class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        // Binary Search 
        int low = 0;
        int high = arr.length-k;
        List<Integer> result = new ArrayList<>();
        while(low < high) {
            int mid = low + (high-low) /2 ;
            int startDist = x - arr[mid];
            int endDist = arr[mid+k] - x;
            if(startDist > endDist) {
                low = mid+1;
            } else {
                high = mid;
            }
        }
       for(int i = low; i< low+k;i++) {
            result.add(arr[i]);
       }
       return result;
    }
}