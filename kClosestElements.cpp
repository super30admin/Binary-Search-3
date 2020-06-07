// Brute Force
// Time Complexity : O(nlogn) - sorting 
// Space Complexity : O(n) - for vector of pairs 
// Did this code successfully run on Leetcode : Yes but for one very long test case
// Any problem you faced while coding this : No

// 1. Create vector of pairs of element and its abs distance from target
// 2. Custom sort as per distance and print first k elements
// 3. Sort final result since ascending order of result is asked 

class Solution {
public:
    vector<int> findClosestElements(vector<int>& arr, int k, int x) {
        vector<int> result;
        if(arr.size()==0)
            return result;
        vector<pair<int,int>> pairs;
        // create vector of pairs
        for(auto el: arr)
            pairs.emplace_back(make_pair(el,abs(x-el)));
        // custom sort
        sort(pairs.begin(), pairs.end(), [](const pair<int,int>& a, const pair<int,int>& b){
           return a.second<b.second; 
        });
        // forming result
        for(auto el:pairs){
            result.emplace_back(el.first);
            k--;
            if(k==0)
                break;
        }
        // sort result
        sort(result.begin(),result.end());
        return result;
    }
};

// Using two pointers
// Time Complexity : O(n)  
// Space Complexity : O(1) 
// Did this code successfully run on Leetcode : Yes 
// Any problem you faced while coding this : No

// 1. Initialize left pointer at start and right at end
// 2. If distance of left element from x is greater than that of right, move left ahead else move right behind
// 3. Stop when r-l==k-1 and add elements between l and r to result

class Solution {
public:
    vector<int> findClosestElements(vector<int>& arr, int k, int x) {
        vector<int> result;
        if(arr.size()==0)
            return result;
        int l=0,r=arr.size()-1;
        cout<<r;
        while(r-l>k-1){
            if(abs(arr[l]-x) > abs(arr[r]-x))
                l++;
            else
                r--;
        }
        for(int i=l;i<=r;i++)
            result.emplace_back(arr[i]);
        return result;
    }
};
