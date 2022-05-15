//2 Pointer Approach
//TC : O(n)
//SC : O(1)
class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        List<Integer> result = new ArrayList<>();

        int left = 0;
        int right = arr.length-1;

        while(right-left+1 > k)
        {
            int lAns = Math.abs(x-arr[left]);
            int rAns = Math.abs(x-arr[right]);

            if(lAns > rAns)
                left++;
            else
                right--;
        }

        for(int i=left;i<left+k;i++)
        {
            result.add(arr[i]);
        }
        return result;
    }
}