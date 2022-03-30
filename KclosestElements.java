//TC: O(log(N) + k)
class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        int left = 0;
        int right = arr.length - k;

        while (left < right) {
            int mid = left +( right-left) / 2;
            System.out.println(mid);
            if (x - arr[mid] > arr[mid + k]-x ) {
                left = mid + 1;
                System.out.println("L: "+left);
            } else {
                right = mid;
                System.out.println("R:"+ right);
            }
        }

        List<Integer> result = new ArrayList<Integer>();
        for (int i = left; i < left + k; i++) {
            result.add(arr[i]);
        }

        return result;
    }
}