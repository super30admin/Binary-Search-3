/*
Time Complexity: O(nlogk+klogk)

Space Complexity: O(k)
*/

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;

class KClosestElementsHeap
{   //Heap
    public List<Integer> findClosestElements(int[] arr, int k, int x)
    {
        int n = arr.length;

        //max heap => element having higher dist will be at the top of the heap
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b)->{
            //here a and b are numbers in array
            int distA = Math.abs(a-x);
            int distB = Math.abs(b-x);

            if(distA==distB) {
                return b-a;
            }
            return distB-distA;
        });

        for(int num:arr) {
            pq.add(num);
            if(pq.size()>k) {
                pq.poll();
            }
        }

        List<Integer> result = new ArrayList<>();
        while(!pq.isEmpty()) {
            result.add(pq.poll());
        }

        //Sorting the result
        Collections.sort(result);

        return result;
    }
}