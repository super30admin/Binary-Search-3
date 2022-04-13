// Time Complexity : O(Log (N - k) base 2)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach

class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        //We are finding starting index of range for k closest elements from x
        
        int low = 0;
        int high = arr.length - k; // Possible starting index for our range for k closest elements from x
        
        while(low < high){
            int mid = low + (high-low) / 2;
            
            int left = x - arr[mid]; // If mid is starting index
            int rightEx = arr[mid + k] - x; // Taking K elements from mid and in addition taking one element for what if distance is same to x from 2 numbers
            
            if(left > rightEx){//If left disance is too far from right, our starting index for range would be in right
                low = mid + 1;
            }else{ // If distance is same OR right one is far
                high = mid;
            }
            
            //When Low = high happenes, we got our starting index for range 
        }
        
        List<Integer> data = new ArrayList<>();
        for(int i = low; i < low + k; i++ ){
            data.add(arr[i]);
        }
        
        return data;
    }
}


/*

// Time Complexity : O(LogN) + O(K)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach


class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        int low = 0;
        int high = arr.length - 1;
        
        while(high - low +1 > k){
            int left = x - arr[low];
            int right = arr[high] - x;
            
            if(left > right){
                low++;
            }else{
                high--;
            }
        }
        
        List<Integer> data = new ArrayList<>();
        for(int i = low; i <= high; i++ ){
            data.add(arr[i]);
        }
        
        
        return data;
    
    }
}

*/