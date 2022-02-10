/**
 * Time Complexity:
 * The time complexity of the solution is O(log(n-k))
 */

/**
 * Space Complexity:
 * The space complexity is O(1) as we are not creating any extra space 
 * for calculations
 */

/**
 * Approach:
 * Since the given array is sorted we have two options:
 *  a) Two pointer
 *  b) Binary Search
 * For the binary search approach we have TC O(logn) + O(k) as we are looking for the
 * numbers that are closer to the given number and then set the left and right pointers around it.
 * We keep on modifying the sliding window by comparing the right and the left values.
 * 
 * To optimize this further we using binary search to find the range instead of finding the 
 * number. We start with low as 0 and high as n- k where n is the size of the given array
 * and k is the number of closest elements we have to find. We use n-k for high because 
 * there will not be more than k elements to the right of high. Now we find the mid which will be the
 * start of the range. Now we compare the right and left distances and according to it we
 * reduce the search space.
 */

// The code ran perfectly on leetcode






class Solution {
public:
    vector<int> findClosestElements(vector<int>& arr, int k, int x) {
        int low = 0;
        int high = arr.size() - k;
        while(low< high){
            int mid = low + (high - low)/2;
            int lDist = x - arr[mid];
            int rDist = arr[mid+k] - x;
            if(lDist > rDist){
                low = mid+1;
            } else {
                high = mid;
            }
        }
        vector<int> result;
        
        for(int i = low; i < low + k; i++){
            result.push_back(arr[i]);
        }
        
        return result;
    }
};