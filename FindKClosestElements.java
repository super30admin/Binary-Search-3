// Time Complexity :O(log(n-k)+k) n is  the given array length
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no


// Your code here along with comments explaining your approach


//Binary Search Optimised
//TC: O(log (n-k) + k)
//SC: O(1)

class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        int low = 0;
        int high = arr.length -k;

        while(low < high){
            int mid = low + (high -low)/2;
            int distS = x - arr[mid];
            int distE = arr[mid+k] - x;

            if(distS > distE){
                low = mid + 1;
            }

            else{
                //if distS < distE or distS == distE
                //we don't do mid + 1 because we might go index out of bound for high+k elements.
                high = mid;
            }
        }

        List<Integer> result = new ArrayList<>();
        for(int i = low ; i < low + k ; i++){
            result.add(arr[i]);
        }
        return result;
    }
}

// Two Pointers Approach
//TC: O(n-k+k) = O(n) n is the length of given array
// n-k for 2 pointers to traverse and k for giving result in list
class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {

        int left = 0;
        int right = arr.length -1;

        while(right - left + 1 > k){
            int distL = Math.abs(x - arr[left]);
            int distR = Math.abs(arr[rigth] - x);

            if(distL > distR){
                left ++;
            }
            //< and = case
            else right --;
        }

        List<Integer> result = new ArrayList<>();
        for(int i = left ; i <= right ; i++){
            result.add(arr[i]);
        }
        return result;
    }
}