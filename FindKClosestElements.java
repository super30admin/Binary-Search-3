// Time Complexity : O(n log (k))
// Space Complexity : O(k)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class FindKClosestElements {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        List<Integer> result = new ArrayList<>();
        if(arr == null || arr.length == 0){
            return result;
        }
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for(int i : arr){
            if(pq.size() < k){
                pq.add(i);
            } else {
                if(Math.abs(x-i) < Math.abs(x - pq.peek())){
                    pq.poll();
                    pq.add(i);
                } else if(Math.abs(x-i) == Math.abs(x - pq.peek()) && i < pq.peek()){
                    pq.poll();
                    pq.add(i);
                }
            }
        }

        while(!pq.isEmpty()){
            result.add(pq.poll());
        }

        return result;
    }
}
