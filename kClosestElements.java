// Two pointer approach: Time complexity=O(n-k)
// Binary search approach: Time complexity=O(log n)
// Binary search approach: Space complexity=O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
// Binary search approach:
// Here we use a binary search where we initially take start = 0 and end = arr.length()-k
class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        List<Integer> result = new ArrayList<>();
        int n=arr.length;
        if(arr == null || n == 0) return result;
        int low = 0, high = n-k;

        // We are finding the first element to start the result array of k closest elements
        while (low<high) {
            int mid = low+(high-low)/2;

            // if x is closer to mid+k index, we move the search space to mid+1 till high, otherwise we move high to mid
            if (x-arr[mid] > arr[mid+k]-x) {
                low = mid+1;
            }
            else {
                high = mid;
            }
        }

        // At this point we will have k elements in the result starting from low
        for (int i=low; i<low+k; i++) {
            result.add(arr[i]);
        }

        return result;
    }
}