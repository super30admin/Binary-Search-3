// Time Complexity: O(n)
// Space Complexity: O(1)
// Did this code successfully run on Leetcode : Yes

// Approach:
// 1. Find the index of the element closest to x using binary search.
// 2. Initialize left as high and right as high + 1.
// 3. Iterate until k is greater than 0.
// 4. If left is less than 0, increment right.
// 5. If right is greater than or equal to arr.size(), decrement left.
// 6. If the absolute difference between arr[left] and x is less than or equal to the absolute difference between arr[right] and x, decrement left.
// 7. Else, increment right.
// 8. Decrement k.
// 9. Return the elements from left + 1 to right.

class Solution {
    public:
        vector<int> findClosestElements(vector<int>& arr, int k, int x) {
            int low = 0; 
            int high = arr.size() - 1;
    
            while(low <= high){
                int mid = low + (high - low)/2;
                if(arr[mid] < x){
                    low = mid + 1;
                }
                else{high = mid - 1;}
            }
            int left = high, right = high + 1;
            while(k > 0){
                if(left < 0){right++;}
                else if(right >= arr.size()){left--;}
                else if(abs(arr[left] - x) <= abs(arr[right] - x)){left--;}
                else{right++;}
                k--;
            }
            return vector<int>(arr.begin() + left + 1, arr.begin() + right);
    
        }
    };