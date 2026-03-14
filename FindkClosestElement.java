/*
Approach: solve using max heap, since we are doing comparison
store the [num,distance] in the heap with integer array, put max distance on the top of heap perform heapify when an element is popped.
sort the left closest elements from the heap and return them.
 */

/*
Time: O(nlogk)
Space: O(k)
 */

class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        PriorityQueue<Integer> pq = new PriorityQueue<>((a,b) -> {
            int dist1 = Math.abs(a - x);
            int dist2 = Math.abs(b - x);

            if(dist1 == dist2){
                return b - a;
            }else{
                return dist2 - dist1;
            }
        });

        for(int num : arr){
            pq.add(num);

            if(pq.size() > k){
                pq.poll();
            }
        }

        List<Integer> result = new ArrayList<>();
        while(!pq.isEmpty()){
            result.add(pq.poll());
        }

        Collections.sort(result);

        return result;
    }
}