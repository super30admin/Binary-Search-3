//Two pointers

/*
Two pointers

Time Complexity (TC): O(n), as we shrink the range in O(n - k) and extract k elements in O(k).
Space Complexity (SC): O(k), as we store only the final k closest elements.

We maintain two pointers (left and right) and shrink the range until exactly k elements remain by eliminating the farthest element in each iteration.
Once we have k elements, we extract and return them as the result.
The approach ensures an optimal contiguous subarray with the closest elements to x.
 */


class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        int n = arr.length;
        int left = 0; int right = n - 1;
        while (right - left >= k) {
            int distL = Math.abs(arr[left] - x);
            int distR = Math.abs(arr[right] - x);
            if (distL > distR) {
                left ++;
            } else {
                right --;
            }
        }
        List<Integer> result = new ArrayList<>();
        for (int i = left; i <= right; i ++){
            result.add(arr[i]);
        }
        return result;
    }
}

//Max Heap 
/*
Time Complexity (TC):
O(n log k) for inserting elements into the priority queue, where n is the array length and k is the number of closest elements.

Space Complexity (SC):
O(k) for storing the k closest elements in the priority queue and the result list.

Explanation:
The code uses a max-heap (priority queue) to track the k closest elements by comparing their distances to x. After collecting the closest elements, it sorts them in increasing order before returning the result.
 */

 // PriorityQueue-based solution to find the 'k' closest elements to 'x' in a sorted array

class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        
        // Create a priority queue to store the array elements along with their distance from 'x'
        // Custom comparator:
        // - If distances are equal, prioritize the larger value to be removed first.
        // - If distances are different, prioritize the larger distance to be removed first.
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> {
            // If both elements have the same distance, prioritize the larger value
            if (a[1] == b[1]) {
                return b[0] - a[0]; // Larger value comes later for the same distance
            }
            // Max-heap by distance: the larger distance will be removed first
            return b[1] - a[1]; 
        });

        // Iterate over the array, calculate distance from 'x', and add elements to the priority queue
        for (int i = 0; i < arr.length; i++) {
            int dis = Math.abs(arr[i] - x);  // Calculate the distance from 'x'
            pq.add(new int[]{arr[i], dis});  // Add the element and its distance to the queue
            
            // If the size of the priority queue exceeds 'k', remove the element with the largest distance
            if (pq.size() > k) {
                pq.poll();
            }
        }

        // List to store the closest elements
        List<Integer> result = new ArrayList<>();

        // Poll elements from the priority queue and add them to the result list
        while (!pq.isEmpty()) {
            int[] polled = pq.poll();  // Get the element with the smallest distance
            result.add(polled[0]);     // Add the element's value (not the distance) to the result
        }

        // Sort the result list in increasing order before returning
        // This ensures that the elements are returned in the correct order
        Collections.sort(result);

        // Return the list of 'k' closest elements
        return result;
    }
}

// Binary Search
/*
Time Complexity (TC):

The time complexity of this solution is O(log(n-k) + k).
The binary search runs in O(log(n-k)) time because it performs a binary search over a range of size (n - k).
The final loop that collects the k closest elements runs in O(k) time.

Space Complexity (SC):
The space complexity is O(k) because we store the result list of k closest elements.

The code uses binary search to find the starting index of the subarray of k closest elements to x. 
It compares the distance of x from the elements at the current middle and middle + k positions to decide whether to move the search range left or right. 
Once the optimal start index is found, the next k elements are returned as the result.
 */

 class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        int low = 0; 
        int high = arr.length - k;  // Initialize the search range for the starting index of the closest k elements
        List<Integer> result = new ArrayList<>();  // List to store the result of k closest elements

        // Perform binary search to find the best starting index
        while (high > low) {
            int mid = low + (high - low) / 2;  // Calculate the middle index
            // Compare distances to x: from arr[mid] and arr[mid + k]
            if (x - arr[mid] > arr[mid + k] - x) {
                // If arr[mid + k] is closer to x, move the low pointer to mid + 1
                low = mid + 1;
            } else {
                // Otherwise, move the high pointer to mid to narrow the range
                high = mid;
            }
        }

        // Once the optimal start index is found, collect the k closest elements
        for (int i = low; i < low + k; i++) {
            result.add(arr[i]);
        }
        return result;  // Return the result list
    }
}
