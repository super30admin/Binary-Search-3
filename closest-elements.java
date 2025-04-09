// TC: O(n log k)
// SC:O(k)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

public List<Integer> findClosestElements(int[] arr, int k, int x) {
    int n = arr.length;

    PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> {
        int distA = Math.abs(a - x);
        int distB = Math.abs(b - x);
        if (distA == distB) {
            return b - a;
        }
        return distB - distA;
    });

    for (int i = 0; i < n; i++) {
        pq.add(arr[i]);
        if (pq.size() > k) {
            pq.poll();
        }
    }

    List<Integer> result = new ArrayList<>();
    while (!pq.isEmpty()) {
        result.add(pq.poll());
    }

    Collections.sort(result);
    return result;
}
