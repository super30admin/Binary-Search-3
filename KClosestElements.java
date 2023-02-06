// Approach 1: Two pointer
// Time Complexity : O(n-k)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

// Your code here along with comments explaining your approach
// We use two pointers at either end of arr
// We move the pointer inwards where the distance of element at that index is greater so that it gives us a better answer
// We do this till we have the pointers at a distance k from each other

class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        int start = 0;
        int end = arr.length-1;
        List<Integer> res = new ArrayList<>();
        while(end-start+1>k){
            if(Math.abs(arr[start]-x)>Math.abs(arr[end]-x))
                start++;
            else
                end--;
        }
        for(int i=start;i<=end;i++){
            res.add(arr[i]);
        }
        return res;
    }
}

// Approach 2: Binary Search
// Time Complexity : O(log(n-k))
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

// Your code here along with comments explaining your approach
// We can use binary search to find the starting index of the result array
// In each iteration we compare arr[mid] and arr[mid+k] with x
// These numbers are significant because both of them can't be together in the final solution

class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        List<Integer> res = new ArrayList<>();
        int low = 0;
        int high = arr.length-k;
        while(low < high){
            int mid = low + (high-low)/2;
            if(x - arr[mid] > arr[mid+k]-x)
                low = mid + 1;
            else
                high = mid;
        }
        for(int i=low;i<low+k;i++)
            res.add(arr[i]);
        return res;
    }
}
