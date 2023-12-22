// Time Complexity : O(log n) + k
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this :

import java.util.ArrayList;
import java.util.List;

public class KClosestElements {


    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        int high = arr.length - 1;
        int low = 0;

        // Adjust pointers based on distances
        while (high - low >= k) {
            int distl = Math.abs(x - arr[low]);
            int disth = Math.abs(arr[high] - x);
            if (distl > disth) {
                low++;
            } else {
                high--;
            }
        }

        // Create a list to store k closest elements
        List<Integer> result = new ArrayList<>();
        for (int i = low; i <= high; i++) {
            result.add(arr[i]);
        }

        return result;
    }

        public static void main(String[] args) {
        KClosestElements solution = new KClosestElements();
        
        int[] arr = {1, 2, 3, 4, 5};
        int k = 3;
        int x = 3;
        
        List<Integer> result = solution.findClosestElements(arr, k, x);
        
        System.out.println("K closest elements: " + result);
    }
}
