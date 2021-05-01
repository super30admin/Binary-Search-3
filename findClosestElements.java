//runtime - O(log n +k)
// space complexity - O(1)

class Solution {
public List<Integer> findClosestElements(int[] arr1, int k, int x) {
   LinkedList<Integer> result=new LinkedList<>();
    if(arr1==null || arr1.length==0)
        return result;
    int closest=binarysearch(arr1,x);
    int left=closest-1;
    int right=closest+1;
    result.addFirst(arr1[closest]);
    while(k>1)
    {
        if(left<0)
            result.addLast(arr1[right++]);
        else if (right==arr1.length)
            result.addFirst(arr1[left--]);
        else
        {
            if((x-arr1[left])>(arr1[right]-x))
            {
                result.addLast(arr1[right++]);
            }
            else
            {
                result.addFirst(arr1[left--]);
                
            }   
        }
        k--;
    }
    return result;
}
    
    private int binarysearch(int[] arr,int x)
    {
        int low=0;
        int high=arr.length-1;
        while(low<high)
        {
            int mid=(low+high)/2;
            if(arr[mid]==x)
                return mid;
            if(x>arr[mid])
                low=mid+1;
            else
                high=mid;
        }
        
        if(low==0)
            return low;
        if(Math.abs(arr[low]-x)<Math.abs(arr[low-1]-x))
            return low;
        else
            return low-1;
    }
}
