// Time Complexity : O(log(n-k))
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no

// Your code here along with comments explaining your approach
// Idea is to find the starting index of the k-elements. we calculate the distance between mid and given x
// and mid+k element and given x. We move towards the distance that is closer to x. Adjust low and high based
// on distances. After determining the starting index add them to the vector and return.

#include<vector>

class Solution {
public:
    std::vector<int> findClosestElements(std::vector<int>& arr, int k, int x) {
        int low = 0;
        int high = arr.size() - k;
        while(low < high)
        {
            int mid = (low + (high - low)/2);
            int distS = x - arr[mid];
            int distE = arr[mid+k] - x;
            if(distS > distE)
            {
                low = mid+1;
            }
            else
            {
                high = mid;
            }
        }

        std::vector<int> result;
        for(int i = low; i < low + k; i++)
        {
            result.push_back(arr[i]);
        }
        return result;
    }
};