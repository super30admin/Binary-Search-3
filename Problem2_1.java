//Time Complexity: O(n-k)
//Space Complexity: O(1)
//code run successfully on LeetCode.

public class Problem2_1 {

    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        
        if(arr == null|| arr.length == 0)
            return new ArrayList<>();
        
        int left = 0;
        int right = arr.length -1;
        
        while( right - left +1 > k){
            
            int distLeft = x - arr[left];
            int distRight = arr[right] - x;
            if( distLeft > distRight)
                left++;
            
            else
                right--;
        }
        
        List<Integer> result = new ArrayList<>();
        
        for(int i = left; i <= right; i++)
            result.add(arr[i]);
        
        return result;
    }
}
