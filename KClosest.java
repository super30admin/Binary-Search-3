// Time Complexity: O(nlogk)
// Space Complexity: O(k)

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;

class KClosest {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> {
            if(a[1] == b[1]){
                return b[0]-a[0];
            }
            return b[1]-a[1];
        });

        for(int i = 0; i < arr.length; i++){
            pq.offer(new int[]{arr[i], Math.abs(arr[i]-x)});

            if(pq.size() > k){
                pq.poll();
            }
        }

        List<Integer> res = new ArrayList<>();
        while(!pq.isEmpty()){
            res.add(pq.poll()[0]);
        }

        Collections.sort(res);
        return res;
    }

    // Time Complexity: O(n-k)
    public List<Integer> findClosestElementsSecSol(int[] arr, int k, int x) {
        int left = 0, right = arr.length-1;

        while(right-left >= k){
            int distL = Math.abs(arr[left]-x);
            int distR = Math.abs(arr[right]-x);

            if(distL > distR){
                left++;
            }else{
                right--;
            }
        }

        List<Integer> result = new ArrayList<>();
        for(int i = left; i <= right; i++){
            result.add(arr[i]);
        }
        return result;
    }
}
