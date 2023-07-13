import java.util.List;
import java.util.HashMap;
import java.util.PriorityQueue;
import java.util.LinkedList;
import java.util.Collections;
import java.util.Scanner;

public class KClosestElementsInSortedArray_Heap {

        //Heap Sort - Max Heap - Hash Map

        public List<Integer> findClosestElements(int[] arr, int k, int x) {

            HashMap<Integer, Integer> map = new HashMap<>(); // O(n) - size

            // mapping elements to distances
            for(int ele: arr) { //O(n)

                int d = Math.abs(x - ele);

                map.put(ele, d);
            }

            //Max Heap priority queue of elements
            PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a, b) -> {

                int dA = map.get(a);
                int dB = map.get(b);

                //we need lower indexed element inside the heap, and higher indexed element out -> max heap
                if(dA == dB) return b-a;

                // minimum distances capped inside a max heap
                return dB - dA;
            });

            // adding all elements to max heap
            for(int ele : arr) { //O(nlogk)

                maxHeap.add(ele);

                // pegging heap's size at k
                if(maxHeap.size() > k) maxHeap.poll(); //O(k) - size
            }

            List<Integer> result = new LinkedList<>(); //O(k) - size

            // add elements in k size heap to result
            while(!maxHeap.isEmpty()) {

                int closestKel = maxHeap.poll();

                result.add(closestKel);
            }
            Collections.sort(result); // O(klogk)

            return result;
        }

        public static void main(String[] args) {

            KClosestElementsInSortedArray_Heap object = new KClosestElementsInSortedArray_Heap();

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

            List<Integer> answer = object.findClosestElements(arr, k, x);

            System.out.println("K closest elements to x in sorted array are ");
            for (int number : answer) {
                System.out.println(number);
            }
        }

}

/*
TIME COMPLEXITY = O(nlogk)
O(nlogk) time - add n elements to k size max heap
O(klogk) time - sort result
O(n) time - build hash map

SPACE COMPLEXITY = O(n)
HashMap space - O(n)
Max Heap space - O(k)
*/