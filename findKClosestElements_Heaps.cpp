// Time Complexity : O(N log k)

// Space Complexity : O(k)

// Did this code successfully run on Leetcode : YES

// Appoarch: Using max heap to store pair of dist:val. finally we'll be left with
// min values in heap which we can return as ans.

// 658. Find K Closest Elements

#include <bits/stdc++.h>
using namespace std;

class cmp{
    public:
    bool operator()(const pair<int,int>& a,const pair<int,int>& b){
        if(a.second == b.second){
            return a.first < b.first;
        }
        return a.second < b.second;
    }
};

class Solution {
public:
    vector<int> findClosestElements(vector<int>& arr, int k, int x) {
        int n = arr.size();
        vector<int> result;
        priority_queue<pair<int,int>,vector<pair<int,int>>,cmp> pq;
        for(int i=0;i<n;i++){
            int dist = abs(arr[i] - x);
            pq.push({arr[i],dist});
            if(pq.size()>k){
                auto p = pq.top();
                pq.pop();
            }
        }
        while(!pq.empty()){
            auto popped = pq.top();
            pq.pop();
            result.push_back(popped.first);
        }
        sort(result.begin(),result.end());
        return result;
    }
};