// Time Complexity - O(logn) where n is the length of the input array
// Space Complexity - O(1)

class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        List<Integer> result = new ArrayList<>();
        int low = 0;
        int high = arr.length-k;

        while(low<high){
            int mid = low + (high-low)/2;

            int distS = x - arr[mid];
            int distE = arr[mid+k] - x;

            if(distS > distE){
                low = mid+1;
            }
            else{
                high = mid;
            }
        }  

        while(k>0){
            result.add(arr[low++]);
            k--;
        }
        return result;
          
    }
}