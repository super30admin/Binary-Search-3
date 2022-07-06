class Solution 
{
    public List<Integer> findClosestElements(int[] arr, int k, int x) 
    {
        List<Integer> output = new ArrayList<>();

        if(arr == null || arr.length ==0)
            return output;

        int low = 0;
        int high = arr.length -1;

        while(high-low + 1 > k)
        {
            int diffLow = Math.abs(arr[low]-x);
            int diffHigh = Math.abs(arr[high]-x);

            if(diffLow <= diffHigh)
                high--;
            else
                low++;
        }

        for(int i = low; i <=high; i++)
        {
            output.add(arr[i]);
        }

        return output;

    }
} 