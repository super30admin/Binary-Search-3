// Time Complexity : O(n) - Two Pointers 
// Space Complexity : O(1) - Two Pointers
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no

// Find K-th Closest Elements - 5 solutions 

#include<iostream>
#include<vector>

using namespace std;


// TWO POINTERS 
class Solution {
public:
    vector<int> findClosestElements(vector<int>& arr, int k, int x) {
        
        vector<int> res;
        
        if(arr.empty())
            return {};
        
        int high = arr.size() - 1;
        int low = 0;
        
        while(high - low + 1 != k){
            if(abs(arr[low] - x) > abs(arr[high] - x))
                ++low;
            else
                --high;
        }
        
        for(int i = low; i <= high; i++){
            res.push_back(arr[i]);
        }
        
        return res;
    }
};

// BINARY SEARCH Time Complexity = O(log(n - k)), Space : constant

class Solution {
public:
    vector<int> findClosestElements(vector<int>& arr, int k, int x) {
        
        vector<int> res;
        
        if(arr.empty())
            return {};
        
        int high = arr.size() - k;
        int low = 0;
        
        while(low < high){
            int mid = low + (high - low)/2;
            int distL = x - arr[mid];
            int distR = arr[mid + k] - x;
            if(distL > distR)
                low = mid + 1;
            else
                high = mid;
        }
        
        for(int i = low; i < low + k; i++){
            res.push_back(arr[i]);
        }
        
        return res;
    }
};