import java.util.*;
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :No 


// Your code here along with comments explaining your approach
// 
// Time Complexity : O(n-k) moving the two pointers to n-k distance+ O(k) time required to add it to the resultant list
// Space Complexity :O(1) no extra space required
class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        if(arr==null|| arr.length==0)
            return new ArrayList<>();
        List<Integer> result= new ArrayList<>();
        int low=0;
        int high=arr.length-1;
        while(high-low+1>k){
            
            int distL= Math.abs(x-arr[low]);
            int distR=Math.abs(x-arr[high]);
            if(distL>distR)
                low++;
            else
                high--;
        }
        
        for(int i=low;i<=high;i++){
            result.add(arr[i]);
        }
        return result;
    }

    // Time Complexity :log(n-k) finding teh position of the left pointer+O(k) moving from let tk k distance to add elements in the resultant lists
// Space Complexity :O(1) no extra space required
    public List<Integer> findClosestElements2(int[] arr, int k, int x) {
        if(arr==null|| arr.length==0)
            return new ArrayList<>();
        List<Integer> result= new ArrayList<>();
        int low=0;
        int high=arr.length-k;
        while(low<high){
            int mid= low+(high-low)/2;
            
            int distL=x-arr[mid];
            int distR=arr[mid+k]-x;
            if(distL>distR){
                low=mid+1;
            }
            else{
                high=mid;
            }
        }
        
        for(int i=low;i<low+k;i++){
            result.add(arr[i]);
        }
        return result;
    } 
}