import java.util.*;

class Solution {
    // Priority Queue solution
    // Time complexity is O(n(logk))
    // Space complexity is O(n)
    // This solution is submitted on leetcode with zero errors
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        List<Integer> result = new ArrayList<>();
        // Edge case
        if(arr == null || arr.length == 0) return result;
        
        // making a custom max priority queue
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> {
            if(a[1]== b[1]){
                return b[0] - a[0];
            }
            return b[1] - a[1];
        });
        
        for(int i = 0; i< arr.length; i++){
            pq.add(new int[] {arr[i],Math.abs(arr[i]-x)});
            if(pq.size()>k) pq.poll();
        }
        
        for(int i = 0; i<k;i++){
            int [] temp = pq.poll();
            result.add(temp[0]);
        }
        
        Collections.sort(result);
        return result;
    }
}