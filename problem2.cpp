/*

// Time Complexity : O(N)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach
You take first and the last pointers. Iterate until high - low breaks the given
distance threshold
Find the distance from both the pointers of the target element if
the distance of left is greater than the right then increase low pointer 
else decrease high pointer even if its equal
Do it until the distance between high and low breaks the threshold k.


*/




//using two pointers

#include<iostream>
#include<vector>

using namespace std;

class Solution {
public:
    vector<int> findClosestElements(vector<int>& arr, int k, int x) {
        int n = arr.size();
        int low{};
        int high{n-1};
        vector<int>res(k,0);
        int count{};
        while(high-low>=k){
            int val1 = abs(arr.at(low)-x);
            int val2 = abs(arr.at(high)-x);
            if(val1>val2){
                ++low;
            }
            else if(val1<=val2){
                --high;
            }
        }
        for(int i{low},j{};i<=high;++i,++j) {
            res.at(j) = arr.at(i);
        }
        return res;
    }
};


//using binary search

/*

// Time Complexity : O(logn)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach


*/

class Solution {
public:
    vector<int> findClosestElements(vector<int>& arr, int k, int x) {
        int n = arr.size();
        int low{},mid{},high{n-k};
        while(low<high){
            mid = low + (high-low)/2;
            int distS = x - arr.at(mid);
            int distE = arr.at(mid+k) - x;
            if(distS>distE) low = mid+1;
            else high = mid;
        }
        vector<int> res(k,0);
        for(int i{low},j{};i<low+k;++i,++j){
            res.at(j) = arr.at(i);
        }
        return res;
    }
};