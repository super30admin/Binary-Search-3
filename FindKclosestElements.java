//Time Complexity : O(n)
//Space Complexity : O(1)

class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {

        int low = 0;
        int high = arr.length-1;

        //move pointers till their are k elements between them
        while(high - low + 1 > k)
        {
            //calculate distance from both pointers
            int lowD = x - arr[low];
            int highD = arr[high] - x;
            //move the pointer with higher distance
            if(lowD > highD)
                low++;
            else //if distance is equal, we move the pointer with higher element
                high--;
        }

        List<Integer> result = new ArrayList();

        for(int i=low; i<=high; i++)
        {
            result.add(arr[i]);
        }

        return result;
    }
}
