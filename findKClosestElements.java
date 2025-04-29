// Time Complexity  :  O(n log n) 
// Space Complexity :  O(n) 

//Approach:
//Insert all elements into a min-heap prioritized by absolute difference from x (and by value if differences are equal).
//Remove the top k elements from the heap and store them in a list.
//Sort the list before returning to ensure the output is in ascending order.

import java.util.*;
class findKClosestElements {

    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        PriorityQueue<Integer> pq = new PriorityQueue<>((Integer a,Integer b) ->
        {
            if(Math.abs(a-x) < Math.abs(b-x))
            {
                return -1;
            }
            else if(Math.abs(a-x) == Math.abs(b-x))
            {
                if(a<b)
                {
                    return -1;
                }
                else
                {
                    return 1;
                }
            }
            else
            {
                return 1;
            }
        });
        for(int i=0;i<arr.length;i++)
        {
            pq.add(arr[i]);
        }
        List<Integer> op = new ArrayList<>();
        int i=0;
        while(i!=k)
        {
            //System.out.println(pq.peek());
            op.add( pq.poll());
            i++;
        }
        Collections.sort(op);
        return op;
    }
}