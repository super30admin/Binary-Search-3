// Time - O(log(n - k)) + k

// space - O(1)


class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {

        if(arr == null || arr.length == 0) return new ArrayList<>();

        int low = 0; int high = arr.length - k;

        List<Integer> result = new ArrayList<>();

        while(low < high) {

            int mid = low + (high - low) / 2;
            int distF = x - arr[mid];
            int distL = arr[mid + k] - x; // adding one more element in case if there is a conflict of same difference value we get for high and low pointer

            if(distF > distL) {

                low = mid + 1;

            }
            else {

                high = mid;

            }


        }

        for(int i = low; i < low + k; i++) {  O(k)

            result.add(arr[i]);
        }


        return result;



    }
}
