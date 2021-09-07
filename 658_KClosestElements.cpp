// Time Complexity : O(N + M)
// Space Complexity :O(N) where N is the length of the smallest array
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no

class Solution {
public:
    vector<int> findClosestElements(vector<int>& arr, int k, int x) {
        vector<int> result;
        if(arr.empty() || arr.size() == 0)
            return arr;
        int left = 0;
        int right = arr.size()-1;
        while((right - left + 1) > k){
            int distL = x - arr[left];
            int distR = arr[right] - x;
            if(distL > distR)
                left++;
            else
                right--;
        }
        for(int i=left; i<=right; i++)
            result.push_back(arr[i]);
        return result;
    }
};
