# Time complexity:O(n)
# Space complexity: 0(n)
# Did code run successfully on leetcode: yes
# Any problem you faced: No

class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        List<Integer> result = new ArrayList<>();

        if(arr == null || arr.length == 0) {
            return result;
        }

        int low = 0;
        int high = arr.length - k;

        while(low < high) {
            int mid = low + (high - low)/2;
            if(Math.abs(x - arr[mid]) > Math.abs(arr[mid + k] - x)) {
                low = mid + 1;
            } else {
                high = mid;
            }
        }

        for(int i = 0; i < k; i++) {
            result.add(arr[low + i]);
        }

        return result;
    }
}

