package Binary-Search-3;

public class FindKClosest {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        List<Integer> result = new ArrayList<>();
        int n = arr.length;
        int lo = 0;
        int high = n - k;

        while (lo < high) {
            int mid = lo + (high - lo) / 2;
            int distS = x - arr[mid];
            int distE = arr[mid + k] - x;
            if (distS > distE) {
                lo = mid + 1;
            } else {
                high = mid;
            }
        }

        for (int i = lo; i < lo + k; i++) {
            result.add(arr[i]);
        }

        return result;
    }
}
