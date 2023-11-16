/* Time Complexity : O(log (n-k)) + O(k) */
/* Space Complexity : O(1) */
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :

//Binary Search

class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        //Using binary search to find the index of the number 
        // where the range of k starts from
        int low = 0; //smallest possible index 0
        int high = arr.length - k;// highest possible index (len of arr - k)
        
        while(low < high){
            int mid = low + (high - low)/2;
            int distSt = x - arr[mid];
            int distEnd = arr[mid + k] - x;
            //Move the pointer towards mid where dist. is more
            if(distSt > distEnd){
                low = mid + 1;
            }else{
                high = mid;
            }
        }
        List<Integer> result = new ArrayList<>();
        //from curr low to low+k, add ele to result
        for(int i = low; i < low+k; i++){
            result.add(arr[i]);
        }
        return result;
    }
}