import java.util.*;
// Time Complexity: O(n log n) for sorting + O(n) for the binary search
// Space Complexity: O(n) for the result list
// LeetCode: https://leetcode.com/problems/find-k-closest-elements/


/**
 * Finds the k closest elements to a given value x in a sorted array.
 * Uses binary search (or two pointers) to efficiently narrow down the window.
 * Time complexity is O(log n + k) and space complexity is O(k).
 */
public class KClosestElement {
    class SolutionWithBinarySearch {
        public List<Integer> findClosestElements(int[] arr, int k, int x) {
            int low = 0;
            int high = arr.length - k;
    
            while (low < high) {
                int mid = low + (high - low) / 2;
    
                int startDistance = x - arr[mid];
                int endDistance = arr[mid + k] - x;
    
                if (startDistance > endDistance) {
                    low = mid + 1;
                } else {
                    high = mid;
                }
            }
            List<Integer> result = new ArrayList<>();
            for (int i = low; i < low+k; i++) {
                result.add(arr[i]);
            }
            return result;
    
        }
    }
    /**
     * Finds the k closest elements to a given value x in a sorted array.
     * Uses binary search (or two pointers) to efficiently narrow down the window.
     * Time complexity is O(log n + k) and space complexity is O(k).
     */
    class SolutionWithTwoPointers{
        class Solution {
            public List<Integer> findClosestElements(int[] arr, int k, int x) {
                int start = 0;
                int end = arr.length - 1;
                List<Integer> result = new ArrayList<>();
        
                while (end - start >= k) {
                    int startDistance = Math.abs(arr[start] - x);
                    int endDistance = Math.abs(arr[end] - x);
        
                    if (startDistance > endDistance) {
                        start++;
                    } else {
                        end--;
                    }
                }
        
                for (int i = start; i <= end; i++) {
                    result.add(arr[i]);
                }
                return result;
            }
        }
    }
    
}
