class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        List<Integer> result = new ArrayList<>();
        int start = 0;
        int end = arr.length-1;
        while(end - start + 1 > k)
        {
            int first = Math.abs(x - arr[start]);
            int last = Math.abs(x - arr[end]);
            if(first > last)
            {
                start++;
            }
            else
            {
                end--;
            }
        }
        for(int i = start; i <= end; i++)
        {
            result.add(arr[i]);
        }
        return result;
    }
}
