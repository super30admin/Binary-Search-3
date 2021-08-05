//Time : O(N)
//Space : O(N)

class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        List<Integer> result = new ArrayList<>();
        if(arr.length == 0|| arr == null)
            return result;
        int distlow,disthigh;
        int low =0 , high = arr.length - 1;
        while(high-low>=k)
        {
           distlow = x - arr[low];
           disthigh = arr[high] - x;
            if(distlow>disthigh) low++;
            else high--;
        }
        for(int i=low;i<high+1;i++)
        {
            result.add(arr[i]);
        }
        return result;
    }
}