// LeetCode #658. Find K Closest Elements
// Time Complexity : O(log (n-k))
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : None

class Solution {
public:
    int binarySearch(vector<int>& arr, int k, int x) {
        int low = 0;
        int high = arr.size() - k;
        int first;
        int last;
        while(low < high) {
            first = low + ((high-low)/2); // integer overflow
            last = first+k;
            if((x-arr[first] <= arr[last]-x))
                high = first;
            else 
                low = first+1;
        }
        return low;
    }
    vector<int> findClosestElements(vector<int>& arr, int k, int x) {
        int first = binarySearch(arr, k, x);
        vector<int> res;
        for(int i = first; i < first+k; i++) {
            res.push_back(arr[i]);
        }
        return res;
    }
};
