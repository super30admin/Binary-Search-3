//T.C = O(n-k)
//S.C = O(1)
class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        
        
        
        
        int low = 0;
        int high = arr.length-1;
        List<Integer> res = new ArrayList<>();
        if(arr.length==0 || arr==null)
        {
            return res;
        }
        
        while(high - low + 1 > k)
        {
            
            if(Math.abs(x-arr[low]) > Math.abs(x-arr[high]))
            {
                low++;
            }
            else
            {
                high--;
            }
        }
        
        for(int i = low ;i<=high;i++)
        {
            res.add(arr[i]);
        }
        return res;
        
    }
}