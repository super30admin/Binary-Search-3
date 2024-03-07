//TC: log(n-k)
//SC: O(1)
class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        int low=0;
        int high=arr.length-k;
        List<Integer> result=new ArrayList<>();
        while(low<high)
        {
            int mid=low+(high-low)/2;
            int ds=x-arr[mid];
            int de=arr[mid+k]-x;
            if(ds>de)
            low=mid+1;
            else
            high=mid;
        }
        for(int i=0;i<k;i++)
        {
            result.add(arr[low]);
            low++;
        }
        return result;
    }
}