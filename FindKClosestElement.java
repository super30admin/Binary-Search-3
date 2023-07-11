import java.util.ArrayList;
import java.util.List;

public class FindKClosestElement {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        int low = 0, high = arr.length - k;
        while (low < high) {
            int mid = low + (high - low) / 2;

            int distS = x - arr[mid];
            int distE = arr[mid + k] - x;

            if (distS > distE) {
                low = mid + 1;
            } else {
                high = mid;
            }
        }

        List<Integer> result = new ArrayList<>();
        for (int i = low; i < low + k; i++) {
            result.add(arr[i]);
        }
        return result;
    }

    public static void main(String[] args) {
        FindKClosestElement finder = new FindKClosestElement();

        int[] arr = { 1, 2, 3, 4, 5 };
        int k = 4; // 3;
        int x = 3; // 4;

        List<Integer> closestElements = finder.findClosestElements(arr, k, x);

        System.out.println("Closest elements to " + x + ": " + closestElements);
    }
}
