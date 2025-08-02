class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        int left = 0;
        int right = arr.length - k;  // window of size k

        // Binary search to find the best starting index
        while (left < right) {
            int mid = (left + right) / 2;

            if (x - arr[mid] > arr[mid + k] - x) {
                left = mid + 1;  // shift window right
            } else {
                right = mid;     // shift window left
            }
        }

        // Build and return the result from the best window
        List<Integer> result = new ArrayList<>();
        for (int i = left; i < left + k; i++) {
            result.add(arr[i]);
        }
        return result;
    }
}