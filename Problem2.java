// There are three approaches
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : In Approach 1 for Comparable. Mistake cleared in Channel

import java.util.Collections;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.lang.Comparable;


// Your code here along with comments explaining your approach
// Approach 1: Using Max Heap
// Time Complexity : O(nlogk + klogk)
// Space Complexity :O(k)
class Solution {

    // class definiton of Pair
    class Pair implements Comparable<Pair>{
        Integer key;
        Integer value;

        // constructor
        Pair(Integer k, Integer v){
            this.key = k;
            this.value = v;
        }

        public Integer getKey(){
            return key;
        }

        public Integer getValue(){
            return value;
        }

        public int compareTo(Pair e){
        
            // descending order
           return e.getValue()>this.getValue()? 1:-1;
        }

    }

    /** find closest elements */
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        // result
        List<Integer> result = new ArrayList<>();
        // edge case
        if(arr== null || arr.length == 0)
            return result;
        
        // Max Heap
        PriorityQueue<Pair> pQueue = new PriorityQueue<>();
        // iterate elements
        for(int key: arr){

            // add to queue
            pQueue.add(new Pair(key, Math.abs(x-key)));
            
            // overflow in terms of k
            if(pQueue.size() > k){
                // check current and next element's value and then key
                Pair current= pQueue.poll();

                // if key of next element greater
                if(pQueue.peek().getValue() == current.getValue() && pQueue.peek().getKey() > current.getKey()){
                    // poll next element
                    pQueue.poll();
                    // add current back
                    pQueue.add(current);
                }
            }
        }

        // remove all the elemnts from the queue
        while(!pQueue.isEmpty()){
            Pair current = pQueue.poll();
            result.add(current.getKey());
        }
        
        // sort the result
        Collections.sort(result);
        
        // return result
        return result;

    }
}

// Your code here along with comments explaining your approach
// Approach 2: Using two pointers
// Time Complexity : O(n-k+k) = O(n)
//      n: number of elements
//      k: k closest elements
// Space Complexity : O(1)
class Problem2S2 {

    /** find closest elements */
    public List<Integer> findClosestElements(int[] arr, int k, int x) {

        // result
        List<Integer> result = new ArrayList<>();
        
        // edge case
        if(arr != null && arr.length != 0){
            // initialize 
            int low = 0;
            int high = arr.length-1;

            // difference between low and high is not k
            while(high-low +1 > k){
                // find distance
                int distL = Math.abs(x-arr[low]);
                int distH = Math.abs(x-arr[high]);
                // move pointer of higher distance
                if(distL > distH)
                    low++;
                else        // as we require smaller elements in case both equi-distanced from target
                    high--;
            }
            // add all the elements from the array
            while(low <= high){
                result.add(arr[low++]);
            }
            
        }
        // return result
        return result;
    }
}
// Your code here along with comments explaining your approach
// Approach 3: Using Binary Search(find closest element)
// 1. We are trying to set low to its right position
// Time Complexity :O(log n +k)
//      n: number of elements
//      k: k closest elements
// Space Complexity : O(1)
class Problem2S3 {

    /** find Closest k elemnsts */
    public List<Integer> findClosestElements(int[] arr, int k, int x) {

        // result
        List<Integer> result = new ArrayList<>();
        // edge case
        if(arr != null && arr.length != 0){

            // initialize
            int low = 0;
            int high = arr.length - k;

            // 
            while(low < high){

                // find mid
                int mid = low + (high-low)/2;
                // get distance
                int distL = Math.abs(x-arr[mid]);
                int distR = Math.abs(x-arr[mid+k]);

                // move higher distance
                if(distL > distR)
                    low = mid +1;
                else{

                    // if both are same elements 
                    if(arr[mid] == arr[mid+k]){
                        // move low
                        low = mid + 1;
                    } // not same than move high
                    else {
                        high = mid;
                    }
                }
            }
            // add elements from low to low +k
            high = low+k;
            while(low < high)
                result.add(arr[low++]);
        }
        // return result
        return result;
    }
}