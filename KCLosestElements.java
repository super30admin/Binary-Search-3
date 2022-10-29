// tc: O(n-k)
// sc: O(1)
class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        if (arr == null || arr.length == 0 || k ==0) return new ArrayList<>();

        int n = arr.length;
        int left = 0;
        int right = n-1;
        List<Integer> result = new ArrayList<>();

        while (right - left + 1 > k) {
            // continue computing the distance
            int distanceLeft = x - arr[left];
            int distanceRight = arr[right] - x;
            if (distanceLeft > distanceRight) {
                left++;
            } else {
                right--;
            }
        }

        for (int i = left; i <= right; i++) {
            result.add(arr[i]);
        }

        return result;
    }
}
