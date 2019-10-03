/**
 * Given a sorted array, two integers k and x, find the k closest elements to x
 * in the array. The result should also be sorted in ascending order. If there
 * is a tie, the smaller elements are always preferred.
 * 
 * Idea: 
 * 1. Use a priority queue with absolute difference of the value of element as priority in a max heap. We want k smallest elements now.
 * Space Complexity: O(k)
 * Time Complexity: O(n log k)
 * 
 * 2. As the given array is sorted, we can use binary search to lookup the element and than use 2 pointers to collect k closest elements.
 * Space Complexity: O(k)
 * Time Complexity: O(logn + k)
 * 
 * 
 */
class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {

    }
}