/*
 * Priority Queue Approach: 
 * Create a max heap by distance and if two elements are at the same distance. return min val
 * TC: O(nlogk)-> n elements to iterate over and logk for sorting k elemenets in the queue
 * SC: O(k) -> k sized priority queue
 */

class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        PriorityQueue<Pair<Integer, Integer>> maxPQ = new PriorityQueue<>(
            (a, b) -> {
                if (!a.getKey().equals(b.getKey())) {
                    return Integer.compare(b.getKey(), a.getKey()); // max heap by distance
                } else {
                    return Integer.compare(b.getValue(), a.getValue()); // tie-breaker: larger value first
                }
            }
        );


        List<Integer> res = new ArrayList<Integer>();

        for(int i = 0; i < arr.length; i++){
            int key = Math.abs(arr[i] - x);
            maxPQ.add(new Pair<>(key, arr[i]));

            while(maxPQ.size() > k){
                maxPQ.poll();
            }
        }
        while(maxPQ.size() != 0){
            res.add(maxPQ.poll().getValue());
        }
        Collections.sort(res);
        return res;
    }
}