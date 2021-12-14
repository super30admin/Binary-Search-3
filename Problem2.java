//Time complexity: O(log(n-k))
class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        //THE TRICK IS-----------
        //to find the start of the enter envelope


        int low = 0;
        int high = arr.length - k;
        int mid = 0;

        while(low<high){
            mid = low + (high-low)/2;
            int left = x - arr[mid];
            int right = arr[mid + k] - x;
            if(left > right)
                low = mid + 1;
            else
                high = mid;
        }
        List<Integer> result = new ArrayList<>();
        for(int i = low;i<low + k;i++)
            result.add(arr[i]);

        return result;
    }
}