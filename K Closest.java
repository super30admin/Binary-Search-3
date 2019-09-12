class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) 
    {
        List<Integer> result = new ArrayList<>();       // Create a new list to store answer.
        int left = 0;   // Declare left and right variables for binary search.
        int right = arr.length-k; // Right will be length of array - number of closest elements to be calculated. 
        
        while(left<right)
        {
            int mid = left + (right-left)/2;    // calculate mid. 
            
            if(Math.abs(arr[mid]-x) > Math.abs(arr[mid+k]-x))   // Compare elements with given element to move left or right pointers . 
               {
                   left = mid+1;
               }
               else
               right = mid;
        
        }
        
        for(int i=left; i<left+k;i++)   // Once pointers are set, run loop from left to left+k to find the K Closest elements. 
        {
            result.add(arr[i]);
        }
        
        
    return result; // return the list.
}
}