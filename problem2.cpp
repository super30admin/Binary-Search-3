// Time Complexity :  O(logn + k)
// Space Complexity : O(1) ( i am not considering the result array)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach

// array is sorted, so we can use binary search and should be able to identify the first index of k elements in the array.
// from there, we traverse k elements and store them in arrray and return the array.

// Binary search:
// intention: finding the first index of k closest elements.
// so, lo =0 and hi = n-k
// important thing to keep in mind: we calculate the distance of x from first indexes only. 
//                                  so, one is x-arr[mid] and other one is arr[mid+k] - x, arr[mid+k] is the first index of next k elements.
//                                  we compare both and accordingly update the lo and hi values.

class Solution {
public:
    vector<int> findClosestElements(vector<int>& arr, int k, int x) {
        int n = arr.size();
        int lo = 0;
        int hi = n-k;
        while(lo<hi)
        {
            int mid = lo + (hi-lo)/2;
            int a = x - arr[mid];
            int b = arr[mid+k]-x;
            if(a > b)
            {
                lo = mid+1;
            }
            else
            {
                hi = mid;
            }
        }
        vector<int>result;
        for(int i = lo;i<lo+k;i++)
        {
            result.push_back(arr[i]);
        }
        
        return result;
    }
};