// Time Complexity : O(log(n-k))
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
public IList<int> FindClosestElements(int[] arr, int k, int x) {
    IList<int> result = new List<int>();
    
    if(arr == null || arr.Length == 0)
        return result;
    
    //we low from satrt and higher from n-k
    int low = 0;
    int n = arr.Length;
    int high = n-k;
    
    while(low < high){
        int mid = (low+high)/2;
        
        //we are calculating distance from start and end
        //so that instead of moving one pointer, we can decide what will be our whole window
        int distStart = x - arr[mid];
        int distEnd = arr[mid+k] - x;
        
        //we compare distance from start with distance from end
        //so that high and low move closer
        if(distStart > distEnd)
            low = mid+1;
        else
            high = mid;
    }
    
    for(int i = low; i < low + k; i++)
    {
        result.Add(arr[i]);
    }
    
    return result;
}



//O(n)
public IList<int> FindClosestElements(int[] arr, int k, int x) {
    IList<int> result = new List<int>();
    if(arr == null || arr.Length == 0)
        return result;

    //Two pointers, one at start and one at end
    int left = 0;
    int right = arr.Length - 1;
    //indexes of start and end to see if it equals to k
    while(right - left + 1 > k)
    {
        //Subtract x from both start and end element
        int distLeft = x - arr[left];
        int distright = arr[right] - x;
        //Whichever result is larger, move that pointer
        //If difference of start and end from x is same, then we moved end element, 
        //because requirement is we need to take smaller element as the array is sorted.
        if(distLeft > distright)
            left++;
        else
            right--;
    }

    for(int i = left; i <= right; i++)
    {
        result.Add(arr[i]);
    }
    return result;
}