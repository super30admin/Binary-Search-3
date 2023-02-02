// Time Complexity : O(nlogk), n is the length of the array and k is number of closest elements
// Space Complexity : O(k)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

// Your code here along with comments explaining your approach in three sentences only
/*
 * create a priority queue to store k elements at a time, if new elements come and size of queue is greater than k then we remove the top element and add the new element.
 */
class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        int n = arr.length;
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            int dist = Math.abs(arr[i] - x);
            map.put(i, dist);
        }

        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> {
            int distA = map.get(a);
            int distB = map.get(b);
            if (distA == distB) {
                return b - a;
            } else {
                return distB - distA;
            }
        });

        for (int i = 0; i < n; i++) // nlogk
        {
            pq.add(i);
            if (pq.size() > k)
                pq.poll();

        }

        List<Integer> result = new ArrayList<>();
        while (!pq.isEmpty()) {
            int idx = pq.poll();
            result.add(arr[idx]);
        }

        Collections.sort(result); // klogk

        return result;
    }
}

// 2 pointer approach

// Time Complexity : O(n), n is the length of the array
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

// Your code here along with comments explaining your approach in three
// sentences only
/*
 * using 2 pointer approach, low and high, if the dist of low is greater than
 * high then increment low index else decrement high index
 */
class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        int n = arr.length;
        int low = 0, high = n - 1;
        while (high - low >= k) {
            int distLow = Math.abs(arr[low] - x);
            int distHigh = Math.abs(arr[high] - x);
            if (distLow > distHigh) {
                low++;
            } else {
                high--;
            }
        }
        List<Integer> result = new ArrayList<>();
        for (int i = low; i <= high; i++) {
            result.add(arr[i]);
        }

        return result;
    }
}

// binary search

// Time Complexity : log(n - k) + O(k), n is the length of the array
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

// Your code here along with comments explaining your approach in three
// sentences only
/*
 * Binary search
 */
class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        int n = arr.length;
        int low = 0, high = n - k;
        while (low < high) {
            int mid = low + (high - low) / 2;
            int distLow = x - arr[mid];
            int distHigh = arr[mid + k] - x;
            if (distLow > distHigh) {
                low = mid + 1;
            } else {
                high = mid;
            }
        }
        List<Integer> result = new ArrayList<>();
        for (int i = low; i < low + k; i++) {
            result.add(arr[i]);
        }

        return result;
    }
}