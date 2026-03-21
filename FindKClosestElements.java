// Time Complexity : O(log(n - k)) + O(k) ~ O(log(n - k))
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no

// Your code here along with comments explaining your approach
/*
The idea is to perform a binary search but by considering the range only from low(0) to high(n - k) elements as
our output is only going to exist in that range.Now, to decide out start point of our output range, we need to
compute mid element and check the distances from mid to the input x and kth element from mid to x.Accordingly,
we compare and move our low and high pointers until they cross each other. The reason we move high to mid instead
of mid -1(as regular) is because we are unsure if mid can be considered as start range or not.So, its better to
include mid.
 */
class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        int low = 0, high = arr.length - k;

        while(low < high) {
            int mid = low + (high - low) / 2;
            int distS = x - arr[mid];
            int distE = arr[mid + k] - x;

            if(distS > distE)
                low = mid + 1;
            else
                high = mid;
        }

        List<Integer> result = new ArrayList<>();
        for(int i = low ; i < low + k ; i++) {
            result.add(arr[i]);
        }
        return result;
    }
}