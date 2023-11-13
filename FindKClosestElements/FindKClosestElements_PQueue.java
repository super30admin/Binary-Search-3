/* Time Complexity : O(nlog k + klog k) 
*   n - length of array - arr 
*   k - num of closest elememts to be found */
/* Space Complexity : O(k) 
*   size of the PriorityQueue */
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :


class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        //pair of num, (|num-x|) - absolute distance from x
        PriorityQueue<int []> pq = new PriorityQueue<>((a,b) ->{
            //max heap
            if(a[1] == b[1]){//If dist from x is same for both a and b then return the min(a,b)
                return b[0] - a[0];
            }
            return b[1] - a[1];
        });
        for(int i = 0; i < arr.length; i++){
            int dist = Math.abs(arr[i] - x);
            pq.add(new int[] {arr[i], dist});
            //max dist would be at the top of queue and we maintain a queue of size k 
            if(pq.size() > k){
                pq.poll();
            }
        }
        List<Integer> result = new ArrayList<>();
        //add to result and sort
        while(!pq.isEmpty()){
            int[] popped = pq.poll();
            result.add(popped[0]);
        }
        Collections.sort(result);
        return result;
    }
}