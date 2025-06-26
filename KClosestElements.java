// Time complexity O(n -k)
// Space Complexity O(1)
// Runs on LeetcCode Yes
class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        int low = 0;
        int high = arr.length - 1;

        while (high - low >= k) {
            int highdiff = Math.abs(arr[high] - x);
            int lowdiff = Math.abs(arr[low] - x);

            if (lowdiff > highdiff) {
                low++;
            } else {
                high--;
            }
        }

        ArrayList<Integer> result = new ArrayList<Integer>();
        for (int i = low; i <= high; i++) {
            result.add(arr[i]);
        }

        return result;
    }
}

