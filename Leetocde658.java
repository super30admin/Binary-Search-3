class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        // Solution 1 - Two pointer approach
        // TC - O(n) iterate over the array
        // SC - O(1) res is the result
        // int l = 0;
        // int r = arr.length-1;
        // while((r-l+1)>k) {
        // int distl = Math.abs(arr[l] - x);
        // int distr = Math.abs(arr[r] - x);
        // if(distl <= distr) {
        // r--;
        // } else {
        // l++;
        // }
        // }
        // List<Integer> res = new ArrayList<>();
        // for(int i=l; i<= r; i++ ){
        // res.add(arr[i]);
        // }
        // return res;

        // Solution 2 : use PQ to hold k elements using max heap
        // TC - O(nlog(k))
        // SC - O(log(k)) for Queue
        // List<Integer> res = new ArrayList<>();
        // PriorityQueue<int[]> pq = new PriorityQueue<>((int[] a, int[] b) -> {
        // if(a[1] == b[1]) {
        // return b[0]-a[0];
        // } else {
        // return b[1] - a[1];
        // }
        // });

        // for(int i=0; i<arr.length; i++) {
        // int dist = Math.abs(arr[i]-x);
        // pq.add(new int[]{i, dist});

        // if(pq.size()>k) {
        // pq.poll();
        // }
        // }
        // while(!pq.isEmpty()){
        // res.add(arr[pq.poll()[0]]);
        // }
        // Collections.sort(res);
        // return res;

        // Solution 3 - Binary search to find the start of index.
        // TC - O(log(n))
        // SC - O(1) without res, O(k) with res
        List<Integer> res = new ArrayList<>();
        int low = 0;
        int high = arr.length - k;
        while (low < high) {
            int mid = low + (high - low) / 2;
            int distL = x - arr[mid];
            int distR = arr[mid + k] - x;

            if (distR >= distL) {
                high = mid;

            } else {
                low = mid + 1;
            }

        }
        for (int i = low; i < low + k; i++) {
            res.add(arr[i]);
        }
        return res;

    }
}