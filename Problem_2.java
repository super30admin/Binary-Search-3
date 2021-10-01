// Time Complexity : O(log(n-k))
// Space Complexity :O(1)
// Did this code successfully run on Leetcode : Yes
// Three line explanation of solution in plain english
// get the starting point of the k window, by looking from 0 to n-k filed, then on the mid check the distance of its start and end, and predit the search based on it.
// Your code here along with comments explaining your approach
// using binary search
class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        List<Integer> result = new ArrayList<>();
        if( arr ==  null || arr.length == 0 ) return result;
        int low = 0;
        int high = arr.length - k;
        while( low < high ){
            int mid = low + (high -low ) / 2;
            int sDis = x-arr[mid];
            int eDis =arr[mid+k]-x;
            if(sDis > eDis){
                low = mid + 1;
            }else{
                high = mid;
            }
        }
        for( int i = low; i <low + k; i++){
            result.add(arr[i]);
        }
        return result;
    }
}


// // using 2 pointers
// class Solution {
//     public List<Integer> findClosestElements(int[] arr, int k, int x) {
//         List<Integer> result = new ArrayList<>();
//         if( arr == null || arr.length == 0) return result;
//         int low = 0;
//         int high = arr.length-1;
//         while( (high - low + 1) > k){
//             if( (high - low + 1) > k && Math.abs(arr[high]-x) >= Math.abs(arr[low]-x) ){
//                 high--;
//             }else if ( (high - low + 1) > k && Math.abs(arr[high]-x) < Math.abs(arr[low]-x)) {
//                 low++;
//             }
//         }
//         if((high -low + 1) == k){
//                 for( int i = low; i <= high; i++){
//                     result.add(arr[i]);
//                 }
//         }
//         return result;
//     }
// }