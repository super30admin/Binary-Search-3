/****
 * TC - O(nlogk)
 * SC - O(k)
 */

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

class Solution {

    //Using min heap
    public List<Integer> findClosestElements(int[] arr, int k, int x) {

        //Using min heap
        PriorityQueue<Integer> pQueue = new PriorityQueue<>();
        List<Integer> list = new ArrayList<>();

        for(int i=0; i < arr.length; i++) {

            //Add 1st k elements
            if(k >0) {
                pQueue.add(arr[i]);
                k--;
            }
            else{
                // If min element in heap is farther to x than the current element
                if(Math.abs(pQueue.peek() - x) > Math.abs(arr[i] - x)) {
                    pQueue.poll();
                    pQueue.add(arr[i]);
                }
            }
        }

        while(!pQueue.isEmpty()) {
            list.add(pQueue.poll());
        }

        return list;
    }
}