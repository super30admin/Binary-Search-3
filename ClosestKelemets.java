//Time : O(n-k)
//Space: O(1)

class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        int start = 0;
        int end = arr.length - 1;
        while (end - start + 1 > k) {
            int dist1 = Math.abs(arr[start] - x);
            int dist2 = Math.abs(arr[end] - x);
            if (dist1 > dist2) {
                start++;
            } else {
                end--;
            }
        }
        List<Integer> result = new ArrayList<>();
        for (int i = start; i <= end; i++) {
            result.add(arr[i]);
        }
        return result;
    }
}