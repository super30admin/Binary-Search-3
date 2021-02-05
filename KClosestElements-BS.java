//Problem 88 :  Find K Closest Elements - Using Binary Search
//TC: O(log n)+O(k), n is array length
//SC: O(1) 

/*
Optimized : 1) Binary Search : TC:O(log n)+k | SC:O(1)
                1) Find Floor(greatest in all the smallest numbers from target or same as target) of the target element
                2) Initialize leftPointer with floor index and rightPointer with floor index+1;
                3) Iterate for K elements and make sure, if element inserted from left side then it should be on top and if from right side then last;
                4) Conditions 
                  a) if leftPointer>=0 and rightPonter<arr.length then perform similar steps of two pointers but just add the numbers in the result. If inserting using left pointer insert at 0th index otherwise insert at last which is normal insertion.
                  b) if leftPointer>=0 insert into list from front i.e at 0th index and decrement leftPointer
                  c) if rightPonter<arr.length insert into last and increment the right pointer.
        
             
*/

import java.util.*;
//Binary Search
class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        
        //TC:O(log n)+O(k); | SC:O(1)
        List<Integer> result = new LinkedList<>();
        
        //edge
        if(arr==null || arr.length==0){
            return result;
        }
        
        //Binary Search
        //find the closest one i.e floor of the target
        
        int idx = getClosest(arr, x);
        System.out.println(idx);
        int left  = idx;
        int right = idx+1;
        
        //result.add(arr[idx]);
        
        while(k>0){
            if(left>=0 && right<arr.length){
                
                int distL = Math.abs(arr[left]-x);
                int distR = Math.abs(arr[right]-x);
                
                if(distL>distR){
                    result.add(arr[right]);
                    right++;
                }else{//distance of right is bigger or both distances are same and in that case also we have to take the left one.
                    result.add(0,arr[left]);
                    left--;
                }
                
            }else if(left>=0){//right is out of bound
                result.add(0,arr[left--]);
            }else{//left is out of bound
                result.add(arr[right++]);
            }
            
            k--;
        }
         
        return result;
    }
    
    private int getClosest(int[] arr, int target){
        
        int start = 0;
        int end   = arr.length-1;
        int res = -1;
        
        while(start<end){
            
            int mid = start +(end-start)/2;
            
            if(arr[mid]== target){
                return mid;
            }
            
            if(target>arr[mid]){
                res = mid;
                start = mid+1;
            }else{
                end = mid-1;
            }
            
        }
        
        return res==-1 ? 0 : res;//there may be a case when floor not found and then we will return 0 as the floor
    }
    
    
}