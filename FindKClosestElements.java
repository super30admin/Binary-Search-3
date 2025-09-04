/* 
Time Complexity: O(n log k)
Space Complexity: O(k)
Did this code successfully run on Leetcode: Yes
*/
// Approach:
// - Use a max-heap (by distance, breaking ties by larger value).
// - For each number in arr, compute distance |x - num|.
// - Push (num, dist) into the heap; if heap size > k, pop the farthest element.
// - At the end, extract numbers from the heap, sort them ascending, and return.
// - This ensures the k closest elements remain in the heap.


import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;

public class FindKClosestElements {
    public List<Integer> findClosestElements(int[] arr, int k, int x){
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b)-> { // 0 is num and 1 is dist
            if(a[1] == b[1]){
                return b[0] - a[0];
            }else{
                return b[1] - a[1];
            }
        }); 

        for(int num : arr){
            int dist = Math.abs(x - num);

            pq.add(new int[]{num, dist});
            if(pq.size() > k){
                pq.poll();
            }
        }

        List<Integer> result = new ArrayList<>();
        while(!pq.isEmpty()){
            result.add(pq.poll()[0]);
        }

        Collections.sort(result);
        return result;
    }
}
