// Time Complexity: O(log(n-k)) where n are total number of elements in array and k is num of elements required
// Space Complexity: O(1)
// Idea here is to get the starting point of of window in which the number would fall
// To do that we perform binary search of the window of k elements where distance of start is target  - mid element
// and end is mid+k th element and target value. we move closer to target for the distance which is farther
// and then check again in a window of k+1 elements
// till l is equal to h at thar point we have found the starting index and we can iterate through it for result
class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        List<Integer> result = new ArrayList<>();
        while(arr==null || arr.length == 0) return result;
        int l = 0; int h = arr.length-k;
        while(l<h) {
            int mid = l + (h-l)/2;
            int distS = x-arr[mid];
            int distE = arr[mid+k] - x;
            if(distS>distE) {
                l = mid+1;
            } else {
                h = mid;
            }
        }
        for(int i=l; i<l+k; i++) {
            result.add(arr[i]);
        }
        return result;
    }
}