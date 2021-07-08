/*
TC : O(log N) + O(k) + O(k log k), binary search, add k elements, sort k elements 
SC : O(1), just output space, binarySearch is O(1)
Difficulty: followed from class
Did it run on Leetcode: no, bug in binarySearch, get stuck infinitely for [2,3]
Approach:
binary search value of x
try to add k elements from either side by comparing differences with x
*/

class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        int idx = binarySearch(arr, x);
        List<Integer> result = new ArrayList<Integer>();
                
        int left = idx;
        int right = idx+1;
        
        while(k>0){
            if(left>=0 && right<=arr.length-1){
                if(arr[right]-x<x-arr[left]){
                    result.add(arr[right]);
                    right++;                
                }
                else{
                    result.add(arr[left]);
                    left--;
                }                
            }
            else{
                if(left<0){
                    result.add(arr[right]);
                    right++;
                }
                else{
                    result.add(arr[left]);
                    left--;
                }                
            }

            
            k--;
        }
        
        Collections.sort(result);
        
        return result;
    }
    
    public int binarySearch(int[] arr, int x){
        int low = 0;
        int high = arr.length-1;
        int mid = low + (high - low)/2;
        
        while(low<high){
            if(arr[mid]==x){
                return mid;
            }
            else if(arr[mid]>x){
                high = mid-1;
            }            
            else{
                low = mid;
            }
            
            mid = low + (high - low)/2;
        }
        
        return low;
    }
}