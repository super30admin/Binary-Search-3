class Problem2 {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        if(arr == null || arr.length == 0){
            return null;
        }
        if(arr.length < k){
          return Arrays.stream(arr).boxed().collect(Collectors.toList()); 
        }
        int start = 0;
        int end = arr.length - k;
        
        while(start < end){
            int mid = start + (end - start)/2;
            if(Math.abs(arr[mid] - x) > Math.abs(arr[mid+k] - x))
                start = mid+1;
            else
                end = mid;
        }    
        return Arrays.stream(Arrays.copyOfRange(arr,start,start+k)).boxed().collect(Collectors.toList());
    }
}
// Time complexity O(log(n-k)) + O(k)
// Space complexity O(1)
// Tested in leetcode