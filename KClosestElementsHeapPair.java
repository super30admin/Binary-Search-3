/*
TC: O(nlogk+2klogk)

Building the Heap (O(n \log k)):
    Adding each of the n elements to the heap (with size maintained as k) costs O(logk), so the total is O(nlogk).

Extracting Elements from the Heap (O(k \log k)):
    Extracting k elements from the heap costs O(logk) per element, totaling O(klogk).

Sorting the Result List (O(k \log k)):
    Sorting k elements in the result list costs O(klogk).

SC: O(k)

Heap Space (O(k)):
The priority queue (min-heap) stores at most k elements at any given time. Each element in the heap is represented
as a pair [distance, number]. This contributes O(k) space.
*/

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;

class KClosestElementsHeapPair
{   //Heap
    public List<Integer> findClosestElements(int[] arr, int k, int x)
    {
        int n = arr.length;

        //using pair
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b)->{ //0 -> dist, 1 -> num

            if(a[0] == b[0]) { //dist is equal
                return b[1] - a[1];
            }
            return b[0]-a[0];
        });

        for(int num:arr) {
            int dist = Math.abs(num - x);
            pq.add(new int[]{dist, num});
            if(pq.size()>k) {
                pq.poll();
            }
        }

        List<Integer> result = new ArrayList<>();
        while(!pq.isEmpty()) {
            result.add(pq.poll()[1]); //adding the number to the result
        }

        //Sorting the result
        Collections.sort(result);

        return result;
    }
}