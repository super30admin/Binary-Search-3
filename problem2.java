class findKClosestElements {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        List<Integer> result = new ArrayList<>();
        if(arr == null || arr.length == 0) return result;
        
        int low = 0;
        int high = arr.length - k;
        
        while(low < high){
            int mid = low + (high - low)/2;
            int disS = x - arr[mid];
            int disE = arr[mid + k] - x;
            if(disS > disE){
                low = mid + 1;
            }
            else{
                high = mid;
            }
        }
        
        for(int i = low; i < low + k; i++){
            result.add(arr[i]);
        }
        
        return result;
    }
}

//time complexity O(log n-k) + O(k)
//space complexity O(1)