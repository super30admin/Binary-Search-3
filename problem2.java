    /**
    Time Complexity : O(log(N - K) + K)
    Explanation:
    - Binary search runs on range [0, N-K] → O(log(N-K))
    - Collecting K elements → O(K)

    Space Complexity : O(K)
    Explanation:
    Result list stores K elements.

    Did this code successfully run on LeetCode : Yes

    Any problem you faced while coding this :
    Initially tried using two pointers which became tricky to manage.
    Then switched to binary search on window starting index.
    The key insight was comparing:
        x - arr[mid]  vs  arr[mid + k] - x
    to decide whether to move left or right.
    */
    class Solution {



        public List<Integer> findClosestElements(int[] arr, int k, int x) {
    
            List<Integer> res = new ArrayList<>();
    
            int n = arr.length;
            int low = 0;
            int high = n - k;
    
            // Binary search for correct window start
            while (low < high) {
    
                int mid = low + (high - low) / 2;
    
                int leftDist = x - arr[mid];
                int rightDist = arr[mid + k] - x;
    
                if (rightDist >= leftDist) {
                    high = mid;
                } else {
                    low = mid + 1;
                }
            }
    
            // Collect k elements from starting index
            for (int i = low; i < low + k; i++) {
                res.add(arr[i]);
            }
    
            return res;
        }
    }