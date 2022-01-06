//TC : O (log(n+k)) 
//SC:  O(1)
class Solution {
    public List<Integer> findClosestElements(int[] A, int k, int x) {
        int low = 0, high = A.length - k; int mid;
        while (low < high) {
            mid = low + (high - low)/2;
            if ( A[mid + k] + A[mid] < 2 * x)
                low = mid + 1;
            else
                high = mid;
        }
        return Arrays.stream(A, low, low + k).boxed().collect(Collectors.toList());
    }
}