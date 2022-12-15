// Time Complexity : O (log n) + k --> log n for binary search and k to copy over the elements to the result 
// Space Complexity : O (1) 
// Did this code successfully run on Leetcode : Yes 

// Binary search for the lower bound or the start of the window 

// The window is of size k and the idea is to find the start of the window using binary search 
// low = 0
// high = length - k because we need k elements left from result to return 

// In binary search, we are comparing the mid with the target and moving low or high
// here the mid is the entire window 

// the window is from arr[mid] - arr[mid+k-1] but we consider an extra elemet 
// The extra element is to decide which of the boundary element is definitely not part of the result. If we had just considered k elements, there would be no way to determine which direction to move. If I have k+1 elemnts, I know if the first element is closer to x or the last and can accordingly move my low/high 

// low = mid + 1 -> when (arr[mid] - x) > (x - arr[mid+k])
// else 
// high = mid 


class Solution {
public:
    vector<int> findClosestElements(vector<int>& arr, int k, int x) {
        if(arr.size() ==0) return arr;

        // Binary search initialise low, high

        int low = 0;
        int high = arr.size()-k;

        while(low<high){
            int mid = low + (high-low)/2; //to avoid integer overflow
            if(x-arr[mid] > arr[mid+k]-x)
                low = mid+1;
            else
                high = mid;
        }
        cout<<low<<high;
        vector<int> result (arr.begin()+low, arr.begin()+low+k);
        return result;
    }
};
