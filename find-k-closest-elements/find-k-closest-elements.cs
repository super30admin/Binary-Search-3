public class Solution {
    public IList<int> FindClosestElements(int[] arr, int k, int x) {
        List<int> result = new List<int>();
        if(arr==null || arr.Length==0)
        {
            return new List<int>();
        }
        
        int n = arr.Length;
        int low =0;
        int high = n-k;
       
        int temp = binarysearch(arr,k,x,low,high);
        for(int i=temp;i<temp+k;i++)
        {
            result.Add(arr[i]);
        }
        
        return result;
        
        
    }
    
    private int binarysearch(int[] arr,int k,int x,int low,int high)
    {
         while(low<=high)
        {
             int first = low + (high-low)/2;
             int last = first + k -1;
            if(first-1>=0 && (x-arr[first-1] <= arr[last]-x))
            {
                high = first-1;
            }
            else if (last+1 <arr.Length && (x-arr[first] > arr[last+1]-x))
            {
                low = first+1;
            }
            else
            {
                return first;
            }
        }
        return low;
    }
}
