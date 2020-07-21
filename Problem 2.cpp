//Time Complexity : O(n-k)
// Space Complexity :O(n)
// Did this code successfully run on Leetcode :Yes
// Any problem you faced while coding this :No
class Solution {
public:
    vector<int> findClosestElements(vector<int>& arr, int k, int x) {
        //two pointers technique O(n-k) solution
        vector<int> res;
        int low = 0; int high = arr.size()-1;
        
        while(high-low>k-1){
            int l_diff = abs(x-arr[low]);
            int r_diff = abs(x-arr[high]);
            
            if(l_diff>r_diff)
                low++;
            else
                high--;
        }
        
        //O(k)
        for(int i=low; i<low+k;i++){
            res.push_back(arr[i]);
        }
        
        return res;
        
    }
};