//Time Complexity: O(log(n-k))
//Space Complexity: O(1)
//Code run successfully on LeetCode.

public class Problem2_3 {

    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        
        if(arr == null|| arr.length == 0)
            return new ArrayList<>();
        
        List<Integer> result = new ArrayList<>();
        
        int low = 0;
        int high = arr.length -k;
        
        while(low < high){
            
            int mid = low + (high - low)/2;
            
            int dStart = x - arr[mid];
            int dEnd = arr[mid + k] - x;
            
            if(dStart > dEnd)
                low = mid +1;
            
            else 
                high = mid;
        }
        
        for(int i = low ; i < low +k ; i++){
            result.add(arr[i]);
        }
        
        return result;
    }
}
