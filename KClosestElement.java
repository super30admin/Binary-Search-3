// 0(n-k)
/*
class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        if(arr==null || arr.length==0)
        {
            return new ArrayList<>();
        }
        int left=0;
        int right=arr.length-1;
        while(right- left+1>k)
        {
            int leftdistance=x-arr[left];
            int rightdistance=arr[right]-x;
            if(rightdistance>=leftdistance)
            {
                right--;
            }
            else
            {
                left++;
            }
        }
        List<Integer> result= new ArrayList<>();
        for(int i=left;i<=right;i++)
        {
            result.add(arr[i]);
        }
        return result;

    }
*/
class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        if(arr==null || arr.length==0)
        {
            return new ArrayList<>();
        }
        int low =0;
        int high = arr.length-k;
        int mid=0;
        while(low<high)
        {
            mid =low+(high-low)/2;
            int left_dis=x-arr[mid];
            int right_dis=arr[mid+k]-x;
            if(right_dis>=left_dis)
            {
                high=mid;
            }
            else
            {
                low=mid+1;
            }
        }
        List<Integer> result= new ArrayList<>();
        for(int i=low;i<low+k;i++)
        {
            result.add(arr[i]);
        }
        return result;

    }
}