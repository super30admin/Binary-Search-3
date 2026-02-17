import java.util.*;


public class KClosestElements {
    /*
Time Complexity : O(n log k) + O(k log k) - for inserting n values in heap of size k + sorting k elements
Space Complexity : O(k)
Approach :
We can use heap with custom comparator to keep the values first sorted on basis of abs value from x, max difference on top.
So max heap based on abs difference. If the difference is same for 2 values, then we sort the max heap based on the value.
*/
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> {
            int b1 = Math.abs(x - b);
            int a1 = Math.abs(x - a);
            if (a1 == b1) return b - a;
            else return b1 - a1;
        });

        for (int val : arr) {
            pq.add(val);
            if (pq.size() > k) {
                pq.poll();
            }
        }
        List<Integer> result = new ArrayList<>();
        while (!pq.isEmpty()) {
            result.add(pq.poll());
        }
        Collections.sort(result);
        return result;
    }

    // Time :  O(n), Space: O(1)
    // We can have two pointers, one from each end. Change them based on the distance between arr[i] and x. Stop when there
    // are k elements left between the two pointers. Copy the elements between low and high in a result array.
    public List<Integer> findClosestElementsLinear(int[] arr, int k, int x) {
        List<Integer> result = new ArrayList<>();
        int low = 0;
        int high = arr.length - 1;
        if(k == arr.length){
            for(int val : arr){
                result.add(val);
            }
            return result;
        }

        while(high-low+1 > k){
            int distA = Math.abs(x - arr[low]);
            int distB = Math.abs(x- arr[high]);
            if(distA <= distB){
                high--;
            }else{
                low++;
            }
        }

        while(low <= high){
            result.add(arr[low++]);
        }

        return result;
    }

    // Time :  O(log n), Space: O(1)
    // We need to find the start index so the elements from s to s + k index are closest to x.
    // To find the start index(also mid), we can find a mid-value such that startIdx < x < startIdx + k. If the distance from startIdx
    // to x is larger we will need to move the startIdx to the right side by moving low to mid+1.
    // If the distance between x to end is more, we need to move start idx to left by moving high to mid.
    public List<Integer> findClosestElementsBS(int[] arr, int k, int x) {
        List<Integer> result = new ArrayList<>();
        int low = 0;
        int high = arr.length - k;
        while(low < high){
            int mid = low + (high-low)/2;
            int distLeft = x - arr[mid];
            int distRight = arr[mid+k] - x;

            if(distLeft <= distRight){
                high = mid;
            }else {
                low = mid + 1;
            }
        }

        for(int i = low; i < low+k; i++){
            result.add(arr[i]);
        }

        return result;
    }
}
