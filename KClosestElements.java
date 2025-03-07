//Time complexity:- O(log(n - k)), Space complexity:- O(1)
class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        
        //Since the array is sorted we can use binary search
        int left = 0;
        int right = arr.length - k;

        while(left < right) {

            int mid = left + (right - left) / 2;

            //cal distance from left index
            int leftDist = x - arr[mid];

            //cal distance of x from right index
            int rightDist = arr[mid + k] - x;

            //if left is < or = to right distance then we count left index and ignore right or else we ignore right index
            if(leftDist > rightDist) {

                left = mid + 1;
            }
            else {

                right = mid;
            }
        }

        //we have go the leftmost index. Count k elements to right
        List<Integer> result = new ArrayList<>();
        for(int i = left; i < left + k; i++) {

            result.add(arr[i]);
        }

        return result;
    }
}