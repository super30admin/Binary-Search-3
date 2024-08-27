/*
    L.C: 658. Find K Closest Elements

    Approach: Binary Search

    Time Complexity - O(log n-k) + O(k)
    Space Complexity - O(1)

*/

class FindKClosestElement {

    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        List<Integer> result = new ArrayList<>();

        int start = 0;
        int end = arr.length - k;

        while (start < end) {
            int mid = start + (end - start) / 2;
            int distanceStart = x - arr[mid];
            int distanceEnd = arr[mid + k] - x;

            if (distanceStart > distanceEnd) {
                start = mid + 1; // Shift to the right half
            } else {
                end = mid; // Shift to the left half
            }
        }

        for (int i = start; i < start + k; i++) {
            result.add(arr[i]); // Add the k closest elements
        }

        return result;
    }
}

