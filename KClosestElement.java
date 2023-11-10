// Time Complexity : O(log(n-k)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : None

public class KClosestElement {
    class Solution {
        public List<Integer> findClosestElements(int[] arr, int k, int x) {
            // //try priority queue O(nlogk)//
            // PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> {
            //     if(b[1] == a[1]){
            //         return b[0] - a[0];
            //     }
            //     return b[1] - a[1];
            // });
            // int n = arr.length;
            // for(int i = 0; i < n; i++){
            //     int dist = Math.abs(arr[i] - x);
            //     pq.add(new int[]{arr[i], dist});
            //     if(pq.size() > k)
            //         pq.poll();
            // }

            // List<Integer> result = new ArrayList<>();
            // while(!pq.isEmpty()){
            //     result.add(pq.poll()[0]);
            // }
            // Collections.sort(result);
            // return result;

            // //try two pointers O(n-k)//
            // int low =0, high = arr.length - 1;
            // while(high - low >= k){
            //     int distS = Math.abs(x - arr[low]);
            //     int distE = Math.abs(arr[high] - x);

            //     if(distS > distE){
            //         low++;
            //     }
            //     else{
            //         high--;
            //     }
            // }

            // List<Integer> result = new ArrayList<>();
            // for(int i = low; i <= high; i++){
            //     result.add(arr[i]);
            // }
            // return result;


            // find start of range in O(log(n-k))//
            int low = 0, high = arr.length - k;

            while(low < high){
                int mid = low + (high - low) / 2;
                int distS = x - arr[mid];
                int distE = arr[mid + k] - x;
                if(distS > distE){
                    low = mid + 1;
                }
                else{
                    high = mid;
                }
            }

            List<Integer> result = new ArrayList<>();
            for(int i = low; i < low + k; i++){
                result.add(arr[i]);
            }
            return result;
        }
    }
}
