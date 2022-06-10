// Time Complexity : O(log(n-k)) + O(k)
// Space Complexity : O(k)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No
public class FiindKclosestElements {
    class Solution {
        public List<Integer> findClosestElements(int[] arr, int k, int x) {
            //binary search for the range of k numbers closest to x
            //we will just find the start index of the range

            List<Integer> result = new ArrayList<>();

            if(arr == null || arr.length == 0) return result;

            int low = 0; int high = arr.length - k;

            while(low < high){ // O(log(n-k))

                int mid = low  + (high - low) / 2;

                int distL = Math.abs(x - arr[mid]);

                int distR = Math.abs(x - arr[mid + k]);

                if(distL > distR) low = mid +1;

                else high = mid;

            }

            for(int i = low; i < low + k; i++){ // O(k)

                result.add(arr[i]);

            }

            return result;
        }
    }
}
