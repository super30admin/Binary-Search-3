/*
Author: Akhilesh Borgaonkar
Problem: Find k closest elements to x in an array.
Approach: I have used sliding window here to find the perfect window of k elements that are close to x. To do this,
    I am first checking if the mid element fits in the window of k elements close to x. If not and left element of window
    is greater then I know that I have to look into left subset of input array. Else look into right subset of input array.
Time Complexity: O(logn+k) where n is number of elements in array and k is number of closest elements to be found
Space Complexity: O(k) where k is number of closest elements to be found
LC verified.
*/

class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        ArrayList<Integer> output = new ArrayList<>();
        int low = 0;
        int high = arr.length - k;
        int mid;
        
        while(low<high){
            mid = low + (high - low)/2;     //get the middle element index
            if(x-arr[mid] > arr[mid+k]-x)   //check if the element in current window falls into k elements range
                low = mid + 1;              //look into right subset
            else
                high = mid;                 //look into left subset
        }
        
        for(int i = low; i < low+k ; i++)   //fetch k elements from the k width window
            output.add(arr[i]);
        return output;
    }
}