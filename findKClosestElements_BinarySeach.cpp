// Time Complexity : O(log(n-k)) - BS is done on n-k elements only

// Space Complexity : O(1)

// Did this code successfully run on Leetcode : YES

// Appoarch: Using binary search, to look for the start point from the target.

// 658. Find K Closest Elements

#include <bits/stdc++.h>
using namespace std;

class Solution {
public:
    vector<int> findClosestElements(vector<int>& arr, int k, int x) {
        int n = arr.size();
        vector<int> result;
        int low = 0;
        int high = n-k;
        while(low<high){
            int mid = low + (high-low)/2;
            int distS = x - arr[mid];
            int distE = arr[mid+k] - x;
            if(distS > distE){
                low = mid+1;
            }
            else{
                high = mid;
            }
        }
        for(int i=low;i<low+k;i++){
            result.push_back(arr[i]);
        }
        return result;
    }
};