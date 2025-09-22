#include<iostream>
#include<bits/stdc++.h>
#include<vector>
using namespace std;
/*
We apply binary search and find the number to be found from their we check on either
side of that element which one is the closest checking the distance between them
and then we iterate through the array from low to the low+kth element to put it in a result vector
and return it
*/
class Solution{
public:
    vector<int> findClosestElements(vector<int>& arr, int k, int x){
        int low = 0, high = arr.size()-1;
        while(low < high){
            int mid = low + (high - low)/2;
            int distS = x - arr[mid];
            int distE = arr[mid+k] - x;
            if(distS > distE) low = mid+1;
            else high = mid; 
        }
        vector<int> result;
        for(int i=low; i<low+k; i++){
            result.push_back(arr[i]);
        }
        return result;
    }
};
