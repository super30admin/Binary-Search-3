class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        int left = 0, right = arr.length - 1;
        while (right - left >= k) {
            if (Math.abs(arr[left] - x) > Math.abs(arr[right] - x)) {
                left++;
            } else {
                right--;
            }
        }

        // Return the sublist of the k closest elements
        List<Integer> result = new ArrayList<>();
        for (int i = left; i <= right; i++) {
            result.add(arr[i]);
        }

        return result;
    }
}
/* 
   Time Complexity: O(log n + k)
   - The binary search part takes O(log n) to find the closest element.
   - The while loop runs until we find k closest elements, which takes O(k).
   Therefore, the total time complexity is O(log n + k).
   
   Space Complexity: O(k)
   - We are storing the k closest elements in a list, so the space complexity is O(k).
*/