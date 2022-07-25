/*
This approach finds the answer using a modified binary search, that searches for the start of the range of the k closest
elements. It does this by calcualting a midpoint and constantly checking whether that mid point is as close as possible
to the element x, and then returns the closest possible value as the start of the range, which is then used to generate the
actual k closest elements.
This program can also be done in nlog(n) time using a Max Heap, N-k time using two pointers, and log(n) time using regular binary 
search

Did this code run on leetcode: Yes
*/
class Solution {
    //Time Complexity: O(log(n-k))
    //Space Complexity: O(1)
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        
        int n = arr.length;
        int low = 0;
        //We only search uptil n - k since we are finding the start of the range
        int high = n - k;
        
        while(low < high)
        {
            int mid = low + (high - low)/2;
            //Calculate tentative start of the range
            int start = x - arr[mid];
            //Calculate tentative end of range. We take one additional element in order to check for duplicacy, 
            //in case both mid and mid+k+1 elements are at same distance from x, then the lesser element will be chosen.
            int end = arr[mid + k] - x;
                
            if(start > end)
                low = mid + 1;
            else
                high = mid;
        }
        
        List<Integer> result = new ArrayList<>();
        //After the while loop ends, the start of the range will be at the low pointer
        for(int i = low; i < low + k; i++)
            result.add(arr[i]);
        
        return result;
    }
}