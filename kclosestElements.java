/*
Tc --> O(nlogk)
Sc --> O(n)
 */
class Pair {

    int index;
    int diff;

    public Pair(int index, int diff) {
        this.index = index;
        this.diff = diff;
    }//method
}//class

class Solution {

    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        List<Integer> res = new ArrayList<>();
        PriorityQueue<Pair> pq = new PriorityQueue<>((a, b) -> {
            if (a.diff != b.diff) {
                return b.diff - a.diff;
            } else {
                return b.index - a.index;
            }
        });
        int diff = 0;
        for (int i = 0; i < arr.length; i++) {
            diff = Math.abs(arr[i] - x);
            pq.add(new Pair(i, diff));

            if (pq.size() > k) {
                pq.poll();
            }
        }//for

        while (!pq.isEmpty()) {
            Pair p = pq.poll();
            int idx = p.index;
            res.add(arr[idx]);
        }//while
        Collections.sort(res);
        //System.out.print(res);
        return res;

    }
}
