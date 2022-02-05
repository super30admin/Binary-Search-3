
import java.util.ArrayList;
import java.util.List;

// Time Complexity : Add : O(log(n-k))
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

public class FindKClosestElements_BinarySearch {
    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5};
        int k = 4, x = 3;
        findClosestElements(arr, k, x);
    }

    public static List<Integer> findClosestElements(int[] arr, int k, int x) {
        List<Integer> result = new ArrayList<>();
        int low = 0;
        int high = arr.length-k;

        while(low<high){
            int mid = low + (high-low)/2;
            int distL = x-arr[mid];
            int distH = arr[mid + k]-x;

            if(distL>distH)
                low=mid+1;
            else
                high=mid;
        }

        for(int i=low; i<low+k; i++){
            result.add(arr[i]);
        }

        return result;
    }
}

