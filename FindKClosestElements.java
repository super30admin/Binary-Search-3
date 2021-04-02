class FindKClosestElements {

    // Time Complexity: O(logn + k)
    // Space Complexity: O(1)   (if output array is not considered as extra space) otherwise O(k)

    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        List<Integer> result = new ArrayList<>();
        // Edge Case Checking
        if(arr == null || arr.length == 0 || k <= 0)
            return result;
        
        int n = arr.length - 1;
        // Get the index of element x in the array
        int index = binarySearch(arr, 0, n, x);

        // If index is zero -> then either x is at index zero or is not present in the array
        // Therefore, the first k elements is the final output
        if(index == 0){
            while(k-- > 0){
                result.add(arr[index++]);
            }
        }
        // If index is n+1 -> then the element is not present in the array and is on the higher end
        // Therefore, the last k elements is the final output
        else if(index == n+1){
            int start = index-k;
            while(k-- > 0){
                result.add(arr[start++]);
            }
        }
        // Else - it is somewhere exactly in the array or it lies in the range of elements in the array
        else{
            int low = index-1;
            int high = index;

            // Find the k elements based satisfying the constraints on both right and left side of the index position
            while(low >= 0 && high <= n && k-- > 0){
                if(Math.abs(arr[low] - x) <= Math.abs(arr[high] - x))
                    low--;
                else
                    high++;
            }
            
            // If we reached either boundary of the array - then add k elements from the other valid side (low or high)
            if(k > 0){
                if(low < 0){
                    while(k-- > 0)
                        high++;
                }else{
                    while(k-- > 0)
                        low--;
                }
            }
            
            // Add these k elements to the final output list
            int start = low + 1;
            int end = high - 1;
            while(start <= end){
                result.add(arr[start++]);
            }
        }
        
        return result;
    }
    
    // Gives the index of the target in the array.
    // If its not present -> then gives the index on the higher side of elements present in the array
    private int binarySearch(int[] arr, int low, int high, int target){
        while(low <= high){
            int mid = low + (high - low)/2;
            if(arr[mid] == target)
                return mid;
            else if(arr[mid] < target)
                low = mid + 1;
            else
                high = mid-1;
        }
        return low;
    }
}