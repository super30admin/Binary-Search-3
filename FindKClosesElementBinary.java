// binary search solution
// Time complexity = O(log(n-k))
// space complexity = O(1)
// The logic is to get the start index of the array using binary search.
class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        List<Integer> res = new ArrayList<>();
        int n = arr.length;
        int low =0;
        int high = n -k;
        while(low< high) {
            int mid = low + (high-low)/2;
            int distS = x- arr[mid];
            int distE = arr[mid+k] -x;// i took k+1 elements here, so that I can move my low and/or high pointer confidently.`
            if(distS<= distE) {
                high = mid;
            } else {
                low = mid+1;
            }
        }
        
        for(int i = low ;i< low+k ; i++ ) {
            res.add(arr[i]);
        }
        return res;
    }
}