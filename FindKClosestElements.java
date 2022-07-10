/* Time Complexity : O(log(n-k))
 * Space Complexity : O(k)
 * Did this code successfully run on Leetcode : Yes
 * Any problem you faced while coding this : No
*/

class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        int n = arr.length;
        int low = 0;
        int high = n-k;
        while(low < high){
            int mid = low + (high - low)/2;
            int dists = x - arr[mid];
            int diste = arr[mid+k] - x;
            if(dists > diste){
                low = mid+1;
            } else{
                high = mid;
            }
        }
        //low is ending up at the start index of range
        List<Integer> result = new ArrayList<>();
        for(int i = low; i < low+k; i++){
            result.add(arr[i]);
        }
        return result;
    }
}
