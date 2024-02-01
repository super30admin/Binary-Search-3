// Time Complexity : O(log(n - k)
// Space Complexity : O(1)
// Method used : Binary Search

class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        
        // high would be n - k because I would be doing a operation like arr[mid + k] for that I should be pretty sure that I
        // always have k elements available

        int low = 0, high = arr.length - k;

        // The intuition of this binary search algorithm is that we are trying to find the starting index from where our k 
        // elements start.

        while(low < high)
        {
            int mid = low + (high - low) / 2;

            // I always assume that start would be towards my left and end would be towards my right and x would be somewhere
            // between them. So in that case move these start and end accordingly

            int start = x - arr[mid];

            int end = arr[mid + k] - x;

            // This means that start is near to x but end is somewhere far away, so bring the end closer to x
            // Even though if start == end we still need to bring end closer because we need to consider indices with lower
            // value when they are equal

            if(start <= end) high = mid;

            else low = mid + 1;
        }

        List<Integer> result = new ArrayList();

        for(int i = low; i < low + k; i++) result.add(arr[i]);

        return result;
    }
}