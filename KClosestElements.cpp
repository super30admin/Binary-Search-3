/*
Intuition: 

Solution 1) Use 2 pointers until the size of array between the 2 pointers == k. We can traverse towards minimum difference by comparing the abs difference of x and first element and x and last element.
Solution 2) Binary Seach can be used to find the range. Considering that we already have a result range from 0,n-k. We move this range to the left if the difference is higher as compared to the last element.
#####################################################################
Solution 1: 2 Pointer
Time Complexity : O(n) 
Space Complexity : O(1)
#####################################################################
Solution 2: Binary search
Time Complexity : O(log(n-k) ) 
Space Complexity : O(1)
#####################################################################
*/

class Solution {
public:
    vector<int> findClosestElements(vector<int>& arr, int k, int x) {
        vector<int> result;
        int low = 0;
        int high = arr.size()-1;
        while ( (high- low+1) >k){
            
            int distF = abs(arr[low]-x);
            int distL = abs(arr[high]-x);
            if ( distF > distL){
                low++;
            }else{
                high--;
            }
        }
        for ( int i =low; i <= high; i++ ){
            result.push_back(arr[i]);
        }
        return result;
    }
};

class Solution {
public:
    vector<int> findClosestElements(vector<int>& arr, int k, int x) {
        int left = 0;
        int right = arr.size() - k;
        
        while (left < right) {
            int mid = (left + right) / 2;
            if (x - arr[mid] > arr[mid + k] - x) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        
        vector<int>result;
        for (int i = left; i < left + k; i++) {
            result.push_back(arr[i]);
        }
        
        return result;
    }   
};