// TC: O(log(n-k))
// SC: O(k)
class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        List<Integer> result = new ArrayList<>();
        int l = 0;
        int h = arr.length - k;
        while(l<h) {
            int mid = l + (h-l) / 2;
            int diffStart = x - arr[mid];
            int diffEnd = arr[mid + k] - x;
            if(diffStart > diffEnd) {
                l = mid + 1;
            } else {
                h = mid;
            }
        }
        for(int i = 0 ; i< k ; i++) { //k
            result.add(arr[l++]);
        }
        return result;
    }
}
