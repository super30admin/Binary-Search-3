// Time Complexity : O(log(n - k)) + O(k)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : yes

// Three line explanation of solution in plain english
/* Window based binary search :- Repeat the following operations till low pointer is less than high pointer.
 *  1. Compute mid.
 *  2. If the distance between element present at mid index and x is less than the distance between element present at mid + k index and x
 *      then window should be moved towards low pointer therefore change the high pointer to mid else window should be moved towards high pointer 
 *      and set low pointer to mid + 1.
 */

class Solution {
public:
    vector<int> findClosestElements(vector<int>& arr, int k, int x) {
        vector<int> result;
        
        if (arr.size() == 0 || k == 0)
            return result;
        
        int low = 0;
        int high = arr.size() - k;
        
        while (low < high)
        {
            int mid = low + (high - low) / 2;
            
            int disL = x - arr[mid];
            int disH = arr[mid + k] - x;
            
            if (disL > disH)
            {
                low = mid + 1;
            }
            else
            {
                high = mid;
            }
        }
        
        for (int i = low; i < low + k; i++)
        {
            result.push_back(arr[i]);
        }
        
        return result;
    }
};