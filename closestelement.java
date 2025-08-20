//Time Complexity: O(log(n - k) + k) — binary search over start index plus collecting k elements.
//Space Complexity: O(1) auxiliary (excluding output); O(k) including the returned list.

//Binary search the window start s in [0, n - k].
//At mid m, compare distances: if x - arr[m] > arr[m + k] - x, shift right (low = m + 1), else shift left (high = m).
//After convergence, take arr[low .. low + k - 1] as the k closest elements.

class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        
        int n = arr.length;
        int low = 0, high = n - k;
        while(low < high){
            int mid = low + (high - low)/2;

            int distS = x - arr[mid];
            int distE = arr[mid + k] - x;

            if(distS > distE){
                low = mid + 1;
            }else{
                high = mid;
            }
        }
        List<Integer> result = new ArrayList<>();
        for(int i=low; i< low+k; i++){
            result.add(arr[i]);
        }
        return result;
    }
}
