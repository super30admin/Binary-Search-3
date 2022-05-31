// Time Complexity : O(1)
// Space Complexity : O(log n) where n is power
// Did this code successfully run on Leetcode : yes

// Three line explanation of solution in plain english
/* Two pointer approach :- Set low and high pointers to start and end of i/p array. 
 * Goal is to have exactly k elements in between low and high pointers by performing following operations repeatedly.
 * If distance between x and element pointed by low pointer is greater than distance between x and element pointed by high pointer 
 * then increment low pointer else decrement high pointer.
 */

class Solution {
public:
    vector<int> findClosestElements(vector<int>& arr, int k, int x) {
        vector<int> result;
        
        if (arr.size() == 0 || k == 0)
            return result;
        
        int low = 0;
        int high = arr.size() - 1;
        
        while (high - low + 1 > k)
        {
            int disL = abs(x - arr[low]);
            int disH = abs(x - arr[high]);
            
            if (disL > disH)
            {
                low++;
            }
            else
            {
                high--;
            }
        }
        
        for (int i = low; i <= high; i++)
        {
            result.push_back(arr[i]);
        }
        
        return result;
    }
};