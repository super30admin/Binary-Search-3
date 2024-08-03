class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        if(arr == null || arr.length == 0) {
            return new ArrayList<>();
        }
        // 2 pointer solution
        // int start = 0;
        // int end = arr.length - 1;
        // List<Integer> result = new ArrayList<>();
        // while(end - start + 1 > k) {
        //     int distStart = x - arr[start];
        //     int distEnd = arr[end] - x;
        //     if(distStart > distEnd) {
        //         start++;
        //     } else {
        //         end--;
        //     }
        // }
        // for(int i = start; i <= end; i++) {
        //     result.add(arr[i]);
        // }
        // return result;

        // Binary search for starting point of the window where I can pick k elements
        int n = arr.length;
        int low = 0;
        int high = n - k;
        List<Integer> result = new ArrayList<>();
        while(low < high) {
            int mid = low + (high - low) / 2;
            int distS = x - arr[mid];
            int distE = arr[mid + k] - x;
            if(distS > distE) {
                low = mid + 1;
            } else {
                high = mid;
            }
        }
        for(int i = low; i < low + k; i++) {
            result.add(arr[i]);
        }
        return result;
    }
}
