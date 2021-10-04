/* Time Complexity : O(N-K) As we are using 2 pointers and moving them until they are K distance apart from each other.
Space Complexity : O(1) No extra space used to perform computations
Did this code successfully run on Leetcode : yes
Any problem you faced while coding this : no
Three line explanation of solution in plain english:
Use 2 pointers: low starts at 0 and high starts at arraylength-1.
Now calculate the absolute distance of element at low and high pointer from the X and compare them.
If distance(lowpointerelement) > highpointerelement increment low pointer else decrement high pointer.
Repeat this until distance between the low and the high pointer if k.
*/

// Your code here along with comments explaining your approach

class FindKClosestElements {

    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        List<Integer> result = new ArrayList<>(); //Not an auxillary space this is required to return result
        int low = 0 ;
        int high = arr.length - 1;
        while(high - low >= k){ // O(N-K)
            int distl = Math.abs(arr[low] - x);
            int disth = Math.abs(arr[high] - x);
            if(distl > disth)
                low++;
            else
                high--;
        }

        for(int i = low; i <= high ; i++){ //O(K)
            result.add(arr[i]);
        }

        return result;

    }


}