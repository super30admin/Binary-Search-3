/*
Approach - modified Binary Search
1. take the lower index as 0 and upper bound as arraylength - k!
2. find the starting point of K elements - as array is sorted, if we just find the starting point, appending later k-1 index values to array list will give us a answer. 
3. this will have a window from 0 to n-k , and will run bs on it.
4. X - arr[mid] < arr[mid+k] - x ; that means move left -> high = mid
else, we have closer values on right side so shift low to mid +1; as mid value is already considered!

TC: log n-k
sc : O(1)
*/

public class Solution {
    public IList<int> FindClosestElements(int[] arr, int k, int x) {
        
        int n = arr.Length;
        
        if(arr == null || n ==0 || k ==0) return new List<int>(){};
        
         IList<int> result = new List<int>();
        //[1,2,3,5,9,10,15,18] ; k =4; x = 6
        
        int index = binarySearch(arr, 0, n-k, k, x);
        
        for(int i=index; i < index + k; i++)
        {
            result.Add(arr[i]);
        }
       
        return result;
    }
    
    private int binarySearch(int[] arr, int low, int high, int k, int num)
    {
        while(low < high)
        {
            //calculate mid
            int mid = low + (high-low)/2;

            //we'll only cosnider mid and mid+k
            int distM =  num - arr[mid];
            int distR = arr[mid+k] - num;
            
            if(distM > distR)
            {
                low = mid+1;
            }
            else
            {
                high = mid;
            }
        }
        return high;
    }
}