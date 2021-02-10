class Solution {
    public List<Integer> findClosestElements(int[] A, int k, int x) {
       LinkedList<Integer> res = new LinkedList<>();
        int n = A.length;
        for (int i = 0; i < n; i++) {
            if (res.size() == k) {
                int diff1 = res.peekFirst() - x;
                int diff2 = A[i] - x;
                if (Math.abs(diff1) > Math.abs(diff2)) {
                    res.removeFirst();
                } else {
                    continue;
                }
            }
            res.add(A[i]);
        }
        return res;  
    }
}