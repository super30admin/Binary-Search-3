// TC: O(log(n) + k)
// SC: O(1)
class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        List<Integer> result = new ArrayList<>();
        if(arr == null || arr.length == 0) {
            return result;
        }

        if(arr.length == k) {
            for(int i = 0; i < k; i++) {
                result.add(arr[i]);
            }
            return result;
        }

        int l, r;
        l = 0;
        r = arr.length;
        while(l < r) {
            int m = l + (r - l)/ 2;
            if(arr[m] >= x) {
                r = m;
            } else {
                l = m + 1;
            }
        }

        l--;
        r = l + 1;
        while(r - l - 1 < k) {
            if(l == -1) {
                r++;
                continue;
            }
            if(r == arr.length || Math.abs(arr[l] - x) <= Math.abs(arr[r] - x)) {
                l--;
            } else {
                r++;
            }
        }

        for(int i = l + 1; i < r; i++) {
            result.add(arr[i]);
        }

        return result;
    }
}