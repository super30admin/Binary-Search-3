// Time Complexity :O(log n) where n in the number elements in the vector
// Space Complexity : O(1)  
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

class Solution {
public:
    vector<int> findClosestElements(vector<int>& arr, int k, int x) {
        int low = 0;
        int high = arr.size() - k;
        while(low<high){
            int mid = low + (high-low)/2;
            int lowDiff = x - arr[mid];
            int highDiff = arr[mid+k] -x;
            if(lowDiff > highDiff)
                low = mid+1;
            else high = mid;
        }
        vector<int> ans;
        for(int i = low ;i<low+k;i++){
            ans.push_back(arr[i]);
        }
        return ans;
    }
};