//Problem 88 :  Find K Closest Elements - Using Two Pointers
//TC: O(n), n is array length
//SC: O(1) 

/*
Bruteforce : 1) Sorting : TC:O(n log n) | SC:O(N) for creating new array or ds where pairs can be stored. Make Pairs of distance and elements . Sort them and return the result 
             2) Heap : TC:O(n log k) | SC:O(k) Make max heap on the basis of distance and store the k elements(pairs) in that.

Optimized : 1) Two Pointers : TC:O(N) | SC:O(1). As array is sorted we can use the concept of two pointers.
               Just put left pointer on start and right pointer on the end and move pointer until distance between left and right is greater than k. After that return the k elemnets that will be the answer.
               If distance of target and left is greater than the distance of target and right increment the left pointer otherwise decrement the right pointer.
               
            2) Binary Search : TC:O(log n)+k | SC:O(1)
                1) Find Floor(greatest in all the smallest numbers from target or same as target) of the target element
                2) Initialize leftPointer with floor index and rightPointer with floor index+1;
                3) Iterate for K elements and make sure, if element inserted from left side then it should be on top and if from right side then last;
                4) Conditions 
                  a) if leftPointer>=0 and rightPonter<arr.length then perform similar steps of two pointers but just add the numbers in the result. If inserting using left pointer insert at 0th index otherwise insert at last which is normal insert.
                  b) if leftPointer>=0 insert into list from front i.e at 0th index and decrement leftPointer
                  c) if rightPonter<arr.length insert into last and increment the right pointer.
        
             
*/

import java.util.*;
class Solution88TwoPointers {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        
        //Two Pointers
        //TC:O(n);
        List<Integer> result = new ArrayList<>();
        
        //edge
        if(arr==null || arr.length==0){
            return result;
        }
        
        int left = 0;
        int right = arr.length-1;
        //TC:O(n-k);
        while(right-left+1>k){
            
            int distL = Math.abs(arr[left]-x);
            int distR = Math.abs(arr[right]-x);
            
            if(distL>distR){
                left++;
            }else{//distR is greater than left or both the distances are same then also we have to take the smaller one and smaller one will be on the left side as array is sorted
                right--;
            }
        }
        //TC:O(k)
        for(int i=left;i<=right;i++){
            result.add(arr[i]);
        }
        
        return result;
    }
}