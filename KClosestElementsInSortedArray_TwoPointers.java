import java.util.List;
import java.util.ArrayList;
import java.util.Scanner;

public class KClosestElementsInSortedArray_TwoPointers {

        //TWO POINTERS

        public List<Integer> findClosestElements(int[] arr, int k, int x) {

            // two pointers at ends of array
            int l = 0; int h = arr.length - 1;

            // move pointers till they cover only k elements
            while(h-l+1 > k) {                   // O(n-k)

                int lD = Math.abs(x - arr[l]);
                int hD = Math.abs(x - arr[h]);

                //move away from higher distance pointer
                if(lD > hD) l++;
                else h--;
            }

            List<Integer> result = new ArrayList<>(); // given in question - no extra space

            //add elements between two pointers spanning k minimum distance elements to result
            for(int i = l; i <= h; i++) {        // O(k)

                result.add(arr[i]);
            }
            // output
            return result;
        }

        public static void main(String[] args) {

            KClosestElementsInSortedArray_TwoPointers obj = new KClosestElementsInSortedArray_TwoPointers();

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
TIME COMPLEXITY = O(n-k)

O(max(n-k, k)) to be specific

O(n-k) - pointer movements

O(k) - copy k elements to result

SPACE COMPLEXITY = O(1) - only pointers used
*/