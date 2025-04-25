// Time Complexity : O(n log k) for heap and O(k log k) for sorting: O(n log k + k log k)
// Space Complexity : O(k) for heap and result list
// Did this code successfully run on Leetcode : Yes

// Approach:
// Use a max-heap to store closest k elements based on distance from x.
// For each number, add to heap and remove the farthest if size greater than k.
// At the end, sort the result list since output needs to be in ascending order.

import java.util.*;
class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        PriorityQueue<Integer> pq=new PriorityQueue<>((a,b)->{
            int dist1=Math.abs(a-x);
            int dist2=Math.abs(b-x);
            if(dist1==dist2){
                return b-a;
            }
            else{
                return dist2-dist1;
            }
        });

        for(int num:arr){
            pq.add(num);
            if(pq.size()>k){
                pq.poll();
            }
        }

        List<Integer> result=new ArrayList<>();
        while(!pq.isEmpty()){
            result.add(pq.poll());
        }
        Collections.sort(result);
        return result;
    }
}



// Time Complexity : O(n - k)
// Space Complexity : O(1) 
// Did this code successfully run on Leetcode : Yes

// Approach:
// Use two pointers to shrink the window until only k elements remain.
// At each step, remove the element either from the left or right that is distant from x.
// Add the remaining elements between l and r as result arraylist.

class Solution2 {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        int n=arr.length;
        int l=0;
        int r=n-1;
        while(r-l>=k){
            int distL=Math.abs(arr[l]-x);
            int distR=Math.abs(arr[r]-x);

            if(distL>distR){
                l++;
            }
            else{
                r--;
            }
        }

        List<Integer> result=new ArrayList<>();
        for(int i=l;i<=r;i++){
            result.add(arr[i]);
        }
        
        return result;
    }
}


// Time Complexity : O(log (n - k) + k)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes

// Approach:
// Use binary search to find the starting index of the window containing the closest k elements.
// Compare distances at the start and end of the window to decide which side to move.
// After finding the starting point, collect the next k elements into the result list.

class Solution3 {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        int n=arr.length;
        int l=0;
        int r=n-k;
        while(l<r){
            int m=l+(r-l)/2;
            int distS=x-arr[m];
            int distE=arr[m+k]-x;
            if(distS>distE){
                l=m+1;
            }
            else{r=m;}
        }

        List<Integer> result=new ArrayList<>();
        for(int i=l;i<l+k;i++){
            result.add(arr[i]);
        }
        
        return result;
    }
}