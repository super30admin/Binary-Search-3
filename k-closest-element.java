// Time Complexity :O(n)+O(nlogk)
// Space Complexity :0(k)
// Did this code successfully run on Leetcode :yes
class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            map.put(arr[i], Math.abs(arr[i] - x));
        }
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> {
            int distA = map.get(a);
            int distB = map.get(b);
            if (distA == distB) {
                return b - a;

            } else {
                return distB - distA;
            }

        });

        for (int i = 0; i < arr.length; i++) {
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
}
