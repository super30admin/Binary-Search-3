// 658. Find K Closest Elements
// https://leetcode.com/problems/find-k-closest-elements/description/

// Solution 1 => Max Heap

/**
 * Approach: We use a max heap of size k which maintains the distance of numbers from x
 * When the heap size is more than k, we pop fromthe heap which removes the number with maximum distance
 * At end, we remain with k elements which has minimum distance from k
 * We sort elements from heap since we want to return elements in sorted order
 */

/**
 * Time Complexity: O(n log k) where n is number of elements and k is heap size
 * Space Complexity: O(k)
 */

class Solution {

  public List<Integer> findClosestElements(int[] arr, int k, int x) {
    // max heap
    PriorityQueue<Integer> heap = new PriorityQueue<>((a, b) -> {
      int distA = Math.abs(x - a);
      int distB = Math.abs(x - b);

      if (distA == distB) {
        return b - a;
      } else {
        return distB - distA;
      }
    });

    for (int num : arr) {
      heap.add(num);

      if (heap.size() > k) {
        heap.poll();
      }
    }

    List<Integer> result = new ArrayList<>();
    while (!heap.isEmpty()) {
      result.add(heap.poll());
    }

    Collections.sort(result);

    return result;
  }
}

/**
 * Approach: If we find the starting point of the range, we can return k numbers from starting point
 * We find the start of the range using binary search.
 * We search from 0th index to n-kth index, since start point needs to have k elements to it's right
 * We calculate mid, and check if mid is the starting point by checking below conditions
 *      1. We compare distance of mid with distance of element mid + k, which is one more than k.
 *         If that distance of mid is greater than distance mid + k, we are sure than start lies right to mid (discard left),
 *         hence we update start to mid + 1
 *      2. Else distance of start is less than distance mid + k, there can be a possibility of more closest elements lying on left of mid
 *         but its just possibility, we are not sure, hence we dont discard mid. We reduce search space to end = mid, taking mid into consideration
 *      3. If number at mid and number at mid + k are same, they would have same distance. And we can't directly  discard right search space
 *         We discard search space by comparing x with mid number. 
 *         If x is greater than mid, we can have more closest elements towards right
 *         If x is smaller than mid, we can have more closest elemetns towards left          
 */

/**
 * Time Complexity: O(log n - k)
 * Space Complexity: O(k)
 */

class Solution {

  public List<Integer> findClosestElements(int[] arr, int k, int x) {
    int start = 0;
    int end = arr.length - k;

    while (start < end) {
      int mid = start + (end - start) / 2;

      int startNum = arr[mid];
      int endNum = arr[mid + k];

      int startDist = Math.abs(x - startNum);
      int endDist = Math.abs(x - endNum);

      if (startNum == endNum) {
        if (x > startNum) {
          start = mid + 1;
        } else {
          end = mid;
        }

        continue;
      }

      if (startDist > endDist) {
        start = mid + 1;
      } else {
        end = mid;
      }
    }

    List<Integer> result = new ArrayList<>();

    while (k > 0) {
      result.add(arr[start]);
      start++;
      k--;
    }

    return result;
  }
}
