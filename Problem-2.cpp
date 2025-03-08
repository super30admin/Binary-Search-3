// https://leetcode.com/problems/find-k-closest-elements/description/
// Time Complexity : O(log n-k)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
// Perform binary search on n-k elements of the input array.
// If x - mid element is greater then move low pointer else move high pointer.
// Through this process we will find out the lower boundary for our required range. 


class Solution {
    public:
        vector<int> findClosestElements(vector<int>& arr, int k, int x) {
            int n = arr.size();
            int low = 0;
            int high = n-k;
            while(low < high){
                int mid = low + (high-low)/2;
                if(x-arr[mid] > arr[mid+k]-x) low = mid+1; 
                else high = mid;
            }
            vector<int> ans;
            for(int i=low; i<low+k; i++){
                ans.push_back(arr[i]);
            }
            return ans;
        }
    };