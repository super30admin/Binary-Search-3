/*
 * TC: O(logn) where n: arr.length - k
 * SC: O(1)
 * 
 * Approach: here initially i am reducing the search space by k and then performing binary search in rder to get the starting index of the 
 * closest element. at the end o f my while loop my low would be pointing to the starting index. At the end, i would just add my 
 * result by adding elements from arr[low] to arr[low+k].
 */

class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        int low = 0, high = arr.length - k;
        List<Integer> result = new ArrayList<>();

        while(low < high){
            int mid = low + (high - low)/2;

            int distM = x - arr[mid];
            int distMToK =  arr[mid+k] - x;

            if(distM > distMToK) low = mid + 1;
            else high = mid;
        }

        for(int i = 0; i < k; i++)
            result.add(arr[low++]);

    return result;
    }
}