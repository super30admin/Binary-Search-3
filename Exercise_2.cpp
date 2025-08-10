// Time Complexity : O(log(n-k)) where n is the number of elements in the array and k is the number of closest elements to find.
// Space Complexity : O(1)
// Were you able to solve it on Leetcode : Yes
// Any problem you faced while coding this : Understanding the validity condition for the binary search

class Solution {
public:
    vector<int> findClosestElements(vector<int>& arr, int k, int x) {
        // binary search solution
        int n = arr.size();

        // init left and right pointers for binary search
        // left is the start of the array and right is the end of the array minus k
        // startIdx will be used to store the index of the first element of the k closest
        // elements to x
        
        int left = 0, right = n-k, startIdx = 0;
        // we will use binary search to find the leftmost index of the k closest elements to x in the array
        while (left <= right){

            int mid = left + (right-left)/2;

            // check if the mid index is a valid index for the k closest elements
            // we check if this choice of mid leads to a valid range of k elements (i.e. mid+k is last element so we need to consider it)
            // or if the distance from x to arr[mid] is less than or equal to the distance from arr[mid+k] to x
            if (mid+k == n  || x-arr[mid] <= arr[mid+k] - x ){
                startIdx = mid; // found valid answer so update start Idx
                right = mid - 1; // trying to find left most answer
            }
            // search in the right side of the array
            else{
                left = mid + 1; // find the right side 
            }

        }

        // we return the k closest elements starting from startIdx to startIdx + k elements
        return vector<int>(arr.begin() + startIdx, arr.begin() + startIdx + k);
    }
};