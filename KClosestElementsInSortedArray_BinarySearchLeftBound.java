import java.util.List;
import java.util.ArrayList;
import java.util.Scanner;

public class KClosestElementsInSortedArray_BinarySearchLeftBound {

        //BINARY SEARCH TO FIND LEFT BOUND OF K-RANGE

        public List<Integer> findClosestElements(int[] arr, int k, int x) {

            // high pointer k positions away from last element
            int low = 0; int high = arr.length -k;

            // invariant of binary search
            while(low < high) {   // O(log(n-k))

                // make mid the left pointer
                int mid = low + (high-low)/2;

                // distance from start of k range to x
                int startD = x - arr[mid];

                // distance from element just after k-range to x i.e., next possible left pointer after current k-range
                int endD = arr[mid+k] - x;

                // make binary search balanced based upon distances
                if(startD > endD)   low = mid+1;
                else               high = mid;
            }

            List<Integer> result = new ArrayList<>(); // given in question to return this way

            // add k- minimum distance elements to result
            for(int i = low; i < low+k; i++) { // O(k)

                result.add(arr[i]);
            }
            return result;
        }

        public static void main(String[] args) {

            KClosestElementsInSortedArray_BinarySearchLeftBound obj
                    = new KClosestElementsInSortedArray_BinarySearchLeftBound();

            Scanner scanner = new Scanner(System.in);

            // take k
            System.out.print("Enter k: ");
            int k = scanner.nextInt();

            // take x
            System.out.print("Enter x: ");
            int x = scanner.nextInt();

            // take sorted array
            // Input the size of the array
            System.out.print("Enter the size of the array: ");
            int size = scanner.nextInt();

            // Create an array of the specified size
            int[] arr = new int[size];

            // Input the elements of the array
            System.out.print("Enter the elements of the array: ");
            for (int i = 0; i < size; i++) {
                arr[i] = scanner.nextInt();
            }

            List<Integer> answer = obj.findClosestElements(arr, k, x);

            System.out.println("K closest elements to x in sorted array are ");
            for (int number : answer) {
                System.out.println(number);
            }
        }

}

/*
TIME COMPLEXITY = O(log(n-k))

binary search only over n-k elements

O(k) - copy k elements to result

SPACE COMPLEXITY = O(1) - only pointers used
*/