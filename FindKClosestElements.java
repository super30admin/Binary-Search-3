// Time Complexity : O(logn + k) , n is the length of array
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

// Notes : Find the smallest closest element to k from the array using binary search, then have two pointers i.e. left and right from this index, and collect the elements int the result where the distance from x is lower.

public class FindKClosestElements {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {

        LinkedList<Integer> result = new LinkedList<>();
        
        if(arr == null || arr.length == 0 || k == 0) return result;
        
        int xIndex = binarySearch(arr, 0, arr.length - 1, x);

        result.add(arr[xIndex]);
        
        int left = xIndex - 1; 
        int right = xIndex + 1;
        
        while(result.size() < k){            
            if(left >= 0 && right < arr.length){
                if( x - arr[left] <= arr[right] - x ){
                    result.addFirst(arr[left]);
                    left = left - 1;
                } else {
                    result.addLast(arr[right]);
                    right = right + 1;
                }
            } else if(left >= 0 ){
                result.addFirst(arr[left]);
                left = left - 1;
            } else if(right < arr.length ){
                result.addLast(arr[right]);
                right = right + 1;
            }
        }
        
        return result;
    }
    
    private int binarySearch(int[] arr, int low, int high, int x){
        // finding the minimum distance of element from x
        int distX = Integer.MAX_VALUE;

        // index in arr, having minimum distance of element from x
        int newX = 0;

        while(low < high){
            int mid = low + (high - low)/2;

            // check the distance from arr[mid] to x, and record the distance and index
            if(Math.abs(arr[mid] - x) < distX){
                distX = Math.abs(arr[mid] - x);
                newX = mid;
            }
            if(arr[mid] == x){
                return mid;
            } else if(arr[mid] < x) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return newX;
    }
}