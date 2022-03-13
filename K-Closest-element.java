//time complexity:- o(n)
//spcae complexity: o(1)
//two pointers solution
class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        int low =0;
        int high = arr.length-1;
        List<Integer> res = new ArrayList<>();
        
        while((high - low)+1 > k)
        {
            if(Math.abs(x- arr[low]) > Math.abs(arr[high] - x))
            {
                low++;
            }
            else{
                high--;
            }
        }
          
        for(int i = low;i<=high;i++)
        {
            res.add(arr[i]);
        }
        return res;
    }
}
