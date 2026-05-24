
// Time Complexity : O(log(n - k) + k) where n is the number of elements in the input array and k is the number of closest elements to find.
// Space Complexity : O(1) as we are using constant space.
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No but confused on binary search approach at first.


// Your code here along with comments explaining your approach
// This is an optimal solution using binary search to find the k closest elements to x in the input array.
// We will use binary search to find the starting index of the k closest elements.
// We will compare the distance of the elements at mid and mid + k from x to determine whether to move the low pointer or the high pointer.
// If the distance of the element at mid is less than or equal to the distance of the element at mid + k, we will move the high pointer to mid, otherwise we will move the low pointer to mid + 1.
// After the binary search, the low pointer will be at the starting index of the k closest elements, and we can simply add the elements from low to low + k to the result list and return it.

class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {

        List<Integer> result = new ArrayList<>();

        int n = arr.length;
        int low = 0, high = n - k;

        while (low < high) {

            int mid = low + (high - low) / 2;

            int distL = x - arr[mid];
            int distR = arr[mid + k] - x;

            if (distR >= distL) {
                high = mid;
            } else {
                low = mid + 1;
            }
        }

        for (int i = low; i < low + k; i++) {
            result.add(arr[i]);
        }

        return result;
    }
}