// Two pointer approach
class Solution {
    // T.C : O(n-k)
    // S.C : O(1)
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        if (arr == null || arr.length == 0 || k == 0)
            return new ArrayList<>();
        
        int n = arr.length;
        int left = 0;
        int right = n - 1;
        
        List<Integer> result = new ArrayList<>();
        
        while (right - left + 1 > k) {
            int distanceLeft = x - arr[left];
            int distanceRight = arr[right] - x;
            if (distanceLeft > distanceRight) {
                left++;
            }
            else {
                right--;
            }
        }
        
        for (int i = left; i <= right; i++) {
            result.add(arr[i]);
        }
        return result;
    }
}