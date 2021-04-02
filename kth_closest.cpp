//TC: O(logn + k)
//SC: O(k) for the generation of the return vector (no extra space) 

//Can use a binary search based approach here. We first return the element that is closest to the target. Then, based on whether the element to its left or element to its right is closer, we then choose and iterate from there.

class Solution {
public:
    
    int binSer(vector<int>&arr, int x){
        
        int low = 0;
        int high = arr.size()-1;
        
        while(low < high){
            int mid = low + (high-low)/2;
            
            if(x == arr[mid])
                return mid;
            
            if(x > arr[mid])
                low = mid+1;
            else if(x <= arr[mid])
                high = mid;
        }
        
        if(low == 0) return low;
        if(abs(arr[low]-x) < abs(x - arr[low-1])){
            return low;
        } else{
            return low-1;
        }
        
        return 0;
        
    }
    
    
    vector<int> findClosestElements(vector<int>& arr, int k, int x) {
        
        int pos = binSer(arr, x);
        vector<int> result;
        
        int l = pos-1;
        int r = pos+1;
        
        result.push_back(arr[pos]);
        
        while(k > 1){
            if(l < 0){
                result.push_back(arr[r++]);
            } else if(r >= arr.size()){
                result.insert(result.begin(), arr[l--]);
            } else {
                 if(abs(x-arr[l]) <= abs(arr[r] - x)){
                    result.insert(result.begin(), arr[l--]);
                 } else{
                     result.push_back(arr[r++]);
                 }
            }
            k--;
        }
        
        return result;
        
    }
};