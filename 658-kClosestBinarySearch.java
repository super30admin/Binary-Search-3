/**LC-658   [1,2,6,6,8,9,10,11,12]
 * Time Complexity : O(N-k) 
 * Space Complexity : O(1)    since we will be returning list result so it wont be counted in the auxiliary space 
 * Did this code successfully run on Leetcode : Yes
 * Any problem you faced while coding this : No
 Algorithm: this solution works for the duplicates as well 
 Here we apply binary Search in quite a different manner. Here the purpose of Binary Search is to
 find the first index of the range which we need to return.
 ALSO, since our purpose is to find the first index of the range, we need to make sure that,
 we dont go out of bounds. This means we will apply binary search on the N-K search space instead of N.
 So low = 0 and high = arr.length -k
 Once we start our binary search we will take two pointers first and last. first = low + (high - low)/2
 We need to take care of the duplicates as well. We handle this by checking differences at first-1 and last && first and last+1 places. 
 
 */

class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        
        List<Integer> result = new ArrayList<>();

        int first = binarySearch(arr, 0, arr.length - k, k, x);  
        for(int i = first; i < first+k; i++){
            result.add(arr[i]);
        }
        
        return result;
    }
    
    private int binarySearch(int[] arr, int low, int high, int k, int x){
        
        while(low <= high){
            
            int first = low + (high - low)/2;
            System.out.print("First: "+ first);
            int last = first + k - 1;
            System.out.print("last: "+ last);
            if(first!= 0 && x - arr[first-1] <= arr[last] - x)
                high = first - 1;
            else if(last != arr.length -1 && x - arr[first] > arr[last+1] - x)
                low = first + 1;
            else
                return first;
        }
        return low;
    }
}