/*
Time complexity: O(log(n-k))
Space complexity: O(1)
Did this code successfully run on Leetcode : Yes
Any problem you faced while coding this : No
*/

class Solution {
public:
	 vector<int> findClosestElements(vector<int>& arr, int k, int x) {
        
        int low=0,high=arr.size()-k;
        
        while(low<high){
            
            int mid=low+(high-low)/2;
            int dist_s = x-arr[mid];
            int dist_e = arr[mid+k]-x;
            
            if(dist_s > dist_e)
            {
                low = mid+1;
            }
            else
            {
                high = mid;
            }
        }

        /* more intuitive solution:

        
        
        */

        // return statement here will traverse through k values (same as for loop)
        return vector<int>(arr.begin() + low, arr.begin() + low + k);
    }
};