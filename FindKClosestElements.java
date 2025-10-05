import java.util.ArrayList;
import java.util.List;

//TC: O(log(n - k)), SC: O(1)
public class FindKClosestElements {

    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        final List<Integer> output = new ArrayList<>();

        int low = 0, high = arr.length - k;

        while (low < high) {
            int mid = low + (high - low) / 2;

            int distS = x - arr[mid];
            int distE = arr[mid + k] - x;

            if (distS <= distE) high = mid;
            else low = mid + 1;
        }

        for (int i = low; i < low + k; i++) output.add(arr[i]);
        return output;
    }
}
