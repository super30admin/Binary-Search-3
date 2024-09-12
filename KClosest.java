// Time Complexity : O(logn) N = no of nodes in array
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : 

// Your code here along with comments explaining your approach
// Divide the Search space into half and check for the distance and proceed to either the left or the right side of 
// the array
import java.util.*;

class KClosest {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        int l = 0;
        int h = arr.length - k;

        while (l < h) {
            int mid = l + (h - l) / 2;
            int left = x - arr[mid];
            int right = arr[mid + k] - x;

            if (left > right) {
                l = mid + 1;

            }
            // else{
            // if(arr[mid] == arr[mid + k]){ l = mid + 1;}
            else {
                h = mid;
            }
        }
        // }
        List<Integer> output = new ArrayList<>();
        for (int i = l; i < l + k; i++) {
            output.add(arr[i]);

        }
        return output;
    }

    public static void main(String args[]) {
        KClosest obj = new KClosest();
        int arr[] = { 1, 1, 2, 2, 2, 2, 2, 2, 3, 3 };
        int k = 4;
        int x = 3;
        System.out.println(obj.findClosestElements(arr, k, x));
    }
}