// Time complexity = O(n* log(k))
// Space complexity = O(k). the priority queue.

// logic- use max heap(priority queue) and the size of the queue needs to be k.
class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        List<Integer> res = new ArrayList<>();
        PriorityQueue<Integer> pq = new PriorityQueue<Integer>((a,b)-> {
            int distA = Math.abs(a-x);
            int distB = Math.abs(b-x);// distance difference.
            if(distA == distB){// the lower number
                return b-a;
            }
            return distB- distA; // this makes the list descending. 5,4,3,2,1 // like. a max heap.
        });
        for(int el: arr) {
            pq.add(el);
            if(pq.size()>k) {
                pq.poll();
            }
        }
        while(!pq.isEmpty()) {
            res.add(pq.poll());
        }
        Collections.sort(res);
        return res;
    }
}