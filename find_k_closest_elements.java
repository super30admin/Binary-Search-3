class Solution {
    //Time O(logN)
    //Space O(1)
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        if(arr == null || arr.length == 0)
        {
            return new ArrayList<>();
        }
        int low = 0 , high = arr.length-k , mid = 0;
        while(low < high)
        {
            mid = low + (high-low)/2;
            int disL = x - arr[mid] , disH = arr[mid+k] - x;
            if(disL > disH)
            {
                low = mid+1;
            }
            else
            {
                high = mid;
            }
        }
        List<Integer> list = new ArrayList<>();
        for(int i = low ; i< low+k ; i++)
        {
            list.add(arr[i]);
        }
        return list;
    }
}