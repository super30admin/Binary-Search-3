class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {

        int low = 0;
        int high = arr.length-1;



        while(high-low>=k)
        {
            int leftdist = x-arr[low];
            int rightdist = arr[high] - x;
            if(leftdist > rightdist) low++;
            else high--;
        }

        List<Integer> res = new ArrayList<>();

        for(int i=low ; i<low+k ; i++)
        {
            res.add(arr[i]);
        }

        return res;

    }
}
