// Time Complexity : O(n-k)

// Space Complexity : O(1)

// Did this code successfully run on Leetcode : YES

// Appoarch: Using two pointers to check the dist diff and keep moving pointers until we reach k.

// 658. Find K Closest Elements

#include <bits/stdc++.h>
using namespace std;

class Solution {
public:
    vector<int> findClosestElements(vector<int>& arr, int k, int x) {
        int n = arr.size();
        vector<int> result;
        int left = 0;
        int right = n-1;
        while(right - left >= k){
            int distR = abs(arr[right] - x);
            int distL = abs(arr[left] - x);
            if(distR < distL){
                left++;
            }
            else{
                right--;
            }
        }
        for(int i=left;i<=right;i++){
            result.push_back(arr[i]);
        }
        return result;
    }
};