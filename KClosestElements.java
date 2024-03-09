// Time complexity: O(log(n-k))
// Space complexity: O(1)

// Approach: Binary search to find the beginning of the range

class KClosestElements {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        int low = 0;
        int high = arr.length - k;

        while (low < high) {
            int mid = low + (high - low) / 2; // Integer overflow
            int startDistance = x - arr[mid];
            // including another number to make sure we keep moving left if distances are
            // same
            int endDistance = arr[mid + k] - x;

            if (startDistance > endDistance) {
                low = mid + 1;
            } else {
                high = mid;
            }
        }

        List<Integer> res = new ArrayList();

        for (int i = low; i < low + k; i++) {
            res.add(arr[i]);
        }

        return res;
    }
}