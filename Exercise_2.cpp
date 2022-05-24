/* 
    Time Complexity                              :  O(Log N) for binary search approach and O(N) for two pointer approach
    Space Complexity                             :  O(1)
    Did this code successfully run on Leetcode   :  Yes
    Any problem you faced while coding this      :  No
*/

#include <bits/stdc++.h> 
using namespace std;  

class Solution {
public:
    vector<int> findClosestElements(vector<int>& arr, int k, int x) {
        return binarySearch(arr, k, x);
        // return twoPointer(arr, k, x);
    }
    
    vector<int> binarySearch(vector<int>& arr, int k, int x) { 
        int l=0, r=arr.size()-k;
        while(l < r) {
            int mid = (l+r)/2;
            if(x - arr[mid] <= arr[mid+k] - x) {
                r = mid;
            } else {
                l = mid+1;
            }
        }
        return vector<int>(begin(arr) + l, begin(arr) + l + k);
    }
    
    vector<int> twoPointer(vector<int>& arr, int k, int x) {
        int l=0, r=arr.size()-1;
        
        while(l <= r and r-l >= k) {
            if(x - arr[l] > arr[r] - x) {
                l++;
            } else {
                r--;
            }
        }
        
        return vector<int>(begin(arr)+l, begin(arr)+l+k);
    }
};