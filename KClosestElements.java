//Time Complexity: O(log n) - binary search on array
//Space Complexity: O(k) - to copy elements into the resultant array
//Did this code run successfully on leetcode: yes
class KClosestElements {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        int low = 0;
        int high = arr.length-k;
        while(low < high) {
            int mid = low+(high-low)/2;
            int distS = x-arr[mid];
            int distE = arr[mid+k]-x;
            if(distS > distE) {
                low = mid+1;
            } else {
                high = mid;
            }
        }
        List<Integer> result = new ArrayList<>();
        for(int i = low; i < low+k; i++) {
            result.add(arr[i]);
        }
        return result;
    }
}