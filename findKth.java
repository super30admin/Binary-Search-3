//TC: O(log(n - k))
//SC:O(1)


class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
       if(arr == null || arr.length == 0) return new ArrayList<>();

       //binary solution
       int n = arr.length;
       int low = 0;
       int high = n - k;

       while(low < high){
           int mid = low + (high - low)/2;
           int ds = x - arr[mid];
           int de = arr[mid + k] - x;

           if(ds > de){
               low = mid + 1;
           } else{
               high = mid;
           }
       }
       List<Integer> result = new ArrayList<>();
       for(int i = 0; i<low+k; i++){
           result.add(arr[i]);
       }
       return result;
    }
}
