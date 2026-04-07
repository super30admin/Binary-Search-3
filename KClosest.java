class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        int l = 0;
        int r = arr.length - 1;
        List<Integer> ans = new ArrayList<>();
        // Time Complexity: O(logn)
        while (l < r) {
            int mid = l + (r - l) / 2;
            if (arr[mid] >= x) {
                r = mid;
            } else {
                l = mid + 1;
            }
        }
        l--;
        // Time Complexity: O(k)
        while (r - l - 1< k) {
            if (l >= 0 && r < arr.length) {
                if (Math.abs(arr[l] - x) > Math.abs(arr[r] - x)) {
                    r++;
                } else {
                    l--;
                }
            } else if (l >= 0) {
                l--;
            } else {
                r++;
            }
        }
        // Time Complexity: O(k)
        for (int i = l + 1; i < r; i++) {
            ans.add(arr[i]);
        }

        return ans;
    }
}