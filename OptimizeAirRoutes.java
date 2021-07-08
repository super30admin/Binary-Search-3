/*
TC : O(M * N log N)
SC : O(1), just output space, binarySearch is O(1)
Difficulty: followed from class
Did it run on Leetcode: yes
Approach:
Sort one of the lists
iterate over the other list pick one, find that target - element cost in other list by using binary search
*/

import java.io.*;
import java.util.*;

class Solution{
    public List<int[]> getOptimalRoutes(List<int[]> a, List<int[]> b, int target){
        List<int[]> output = new ArrayList<>();
        Collections.sort(b, (r1, r2) -> r1[1] - r2[1]);
        
        int curMax = 0;
        for(int i=0; i<a.size(); i++){
            int idx = binarySearch(b, target - a.get(i)[1]);
            
            if(a.get(i)[1]+b.get(idx)[1] <=target){
               if(a.get(i)[1]+b.get(idx)[1] > curMax){
                   output = new ArrayList<>();
               }
                output.add(new int[]{a.get(i)[0], b.get(idx)[0]});
            }
        }
        
        return output;
    }
    
    public int binarySearch(List<int[]> b, int target){
        int low = 0;
        int high = b.size()-1;
        
        while(low<high){
            int mid = low + (high-low)/2;
            
            if(b.get(mid)[1]==target) return mid;
            
            if(b.get(mid)[1]<target){
                low = mid; 
            }
            else{
                high = mid-1;
            }
        }
        
        return low;
    }
}

public class Main {
    public static void main(String[] args) {
        List<int[]> a = new ArrayList<>();
        a.add(new int[]{1,2});
        a.add(new int[]{2,4});
        a.add(new int[]{3,6});
        
        List<int[]> b = new ArrayList<>();
        b.add(new int[]{1,2});
        
        int target = 7;
        
        Solution sol = new Solution();
        List<int[]> result = sol.getOptimalRoutes(a, b, target);
        
        for(int[] pair : result){
            System.out.println(Arrays.toString(pair));
        }
    }
}