// Problem2 
// Find K Closest Elements (https://leetcode.com/problems/find-k-closest-elements/)

// Brute force - Time complexity O(nlogn) space O(k)
class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        List<Integer> res = new ArrayList<>();
        if(arr == null || arr.length * k == 0) return res;
        // custom comparator based on distance with target
        arr = Arrays.stream(arr).boxed().sorted((a, b) -> a == b ? a - b : Math.abs(x - a) - Math.abs(x - b)).mapToInt(i -> i).toArray();
     for(int i = 0; i < k; i++){
         res.add(arr[i]);
     }
     Collections.sort(res);
     return res;
    }
}
// Two pointer solution
// Time complexity - O(n) and space complexity is O(1)
class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        List<Integer> res = new ArrayList<>();
        if(arr == null || arr.length * k == 0){
            return res;
        }
        int n = arr.length;
        
        // Step 1: using Two Pointers
        
        int low = 0, high = n - 1;
        while(high - low + 1 > k){
            if(Math.abs(x - arr[low]) > Math.abs(arr[high] - x)){
                low++;
            }else{
                high--;
            }
        }
        
        for(int i = low; i < low + k; i++){
            res.add(arr[i]);
        }
        
        return res;
    }
}

// Binary search solution
// Time complexity - O(logn + k) and space complexity is O(1)
class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        List<Integer> res = new ArrayList<>();
        if(arr == null || arr.length * k == 0){
            return res;
        }
        int n = arr.length;
        
        int low = 0, high = n - k;
        while(low < high){
            int mid = low + (high - low) / 2;
            if(x - arr[mid] > arr[mid + k] - x){
                low++;
            }else{
                high--;
            }
        }
        
        for(int i = low; i < low + k; i++){
            res.add(arr[i]);
        }
        
        return res;
    }
}