//Time Complexity :  O(n)
//Space Complexity :  O(1)
//Did this code successfully run on Leetcode : Yes

import java.util.*;

public class FindKClosestElement {

    class Solution {
        public List<Integer> findClosestElements(int[] arr, int k, int x) {
            // int n = arr.length;
            // Map<Integer,Integer> map = new HashMap<>();
            // int cnt =0;
            // for (int num : arr){
            //     map.put(cnt, Math.abs(x-num));
            //     cnt++;
            // }
            // PriorityQueue<Integer> pq = new PriorityQueue<>((a,b)->{
            //     int distA = map.get(a);
            //     int distB = map.get(b);
            //     if (distA == distB){
            //         return b-a;
            //     } else {
            //         return distB-distA;
            //     }
            // });
            // for (int i =0;i<n;i++){
            //     pq.add(i);
            //     if (pq.size() > k) pq.poll();
            // }
            // List<Integer> result = new ArrayList<>();
            // while (!pq.isEmpty()){
            //     //int idx = pq.poll();
            //     //result.add(arr[idx]);
            //     result.add(arr[pq.poll()]);
            // }
            // Collections.sort(result);
            // return result;
    
            // Two pointer solution
            int n = arr.length;
            int low = 0;
            int high = n-1;
            while (high - low >= k){
                int distL = Math.abs(arr[low]-x);
                int distH = Math.abs(arr[high]-x);
                if (distL > distH){
                    low++;
                } else {
                    high--;
                }
            }
            List<Integer> result = new ArrayList<>();
            for (int i=low;i<=high;i++){
                result.add(arr[i]);
            }
            return result;
        }
    }
    
}
