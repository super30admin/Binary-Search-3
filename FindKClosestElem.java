// Time Complexity : O(log n-k)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
//By taking the length of the window as K and applying Binary search based on the diff between first - x and last - x

import java.util.ArrayList;
import java.util.List;

public class FindKClosestElem {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        List<Integer> result = new ArrayList<>();
        if(arr == null || arr.length ==0){
            return result;
        }

        int low =0; int high = arr.length-k;
        int first = binarysearch(arr, low, high, k, x);

        for(int i = first;i<first+k; i++){
            result.add(arr[i]);
        }
        return result;
    }

    private int binarysearch(int[] arr, int low, int high, int k, int x){
        while(low<high){
            int first = low+(high-low)/2;
            int last = first + (k-1);
            if(first > 0 && x - arr[first-1] <= arr[last] -x){
                high = first -1;
            }else if(last<arr.length-1 && x-arr[first] > arr[last+1]-x){
                low = first+1;
            }else{
                return first;
            }
        }
        return low;
    }

}
