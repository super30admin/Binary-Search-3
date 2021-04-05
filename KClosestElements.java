class Solution {

    public List<Integer> findClosestElements(int[] arr, int k, int x) {

        List<Integer> result = new ArrayList<>();
        if(arr == null || arr.length == 0) return result;
        int low = 0; int high = arr.length - k;

        //Implements binary search to find the k elements
        while(low < high){ // O(log(n-k))
            int mid = low  + (high - low) / 2;
            int distL = Math.abs(x - arr[mid]);
            int distR = Math.abs(x - arr[mid + k]);
            if(distL > distR) low = mid +1;
            else high = mid;
        }
        
        for(int i = low; i < low + k; i++){ // O(k)
            result.add(arr[i]);
        }
        return result;
    }
}

// Time Complexity: O(log n)
// Space Complexity: O(1)