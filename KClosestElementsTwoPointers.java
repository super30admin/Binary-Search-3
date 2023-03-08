// TC: O()
class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        List<Integer> result = new ArrayList<>();
        if(arr == null || arr.length == 0) {
            return result;
        }
        int l, r;
        l = 0;
        r = arr.length - k;
        while(l < r) {
            int m = l + (r - l) / 2;
            int diffFirst = x - arr[m];
            int diffLast = arr[m + k] - x;
            if(diffFirst > diffLast) {
                l = m + 1;
            } else {
                r = m;
            }
        }
        for(int i = l; i < l + k; i++) {
            result.add(arr[i]);
        }
        return result;
    }
}