class Solution {
    //tc - o(n-k+n) n-k until we find k elemtns and k to give o/p result
    //so its tc = o(n)
    public List<Integer> findClosestElements(int[] arr, int k, int x) {

        int low = 0;
        int high = arr.length-1;

        while((high-low)+1 > k)
        {
            int distL = x - arr[low];
            int distR = arr[high] - x;
            if(distL > distR)
            {
                low++;
            }
            else
            {
                high--;
            } 

        }
        List<Integer> result = new ArrayList<>();
        for(int i=low;i <= high;i++)
        {
            result.add(arr[i]);
        }

        return result;
    }
}