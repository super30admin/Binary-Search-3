//Time Complexity: O(log (n-k))
//Space Complexity: O(1)
//Did this code run on LeetCode: Yes
//Approach: We are implementing binary search for an entire interval where instead of placing
//high at the last element, we are placing it on (n-k)th element.

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;

public class Closest {
    public static List<Integer> findClosestElements(int[] arr, int k, int x) {
        int n = arr.length;
        int low = 0;
        int high = n - k;
        
        while(low < high)
        {
            int mid = low + (high - low)/2;
            int disA = x - arr[mid];
            int disB = arr[mid + k] - x;
            
            if(disA > disB)
            {
                low = mid + 1;
            }
            else
            {
                high = mid;
            }
        }
        
        List<Integer> result = new ArrayList<>();
        for(int i = low; i<low + k; i++)
        {
            result.add(arr[i]);
        }
        return result;
    }

    public static void main(String[] args) {
        int arr[] = {1,2,3,4,5};
        List<Integer> print = new ArrayList<>();
        print = findClosestElements(arr, 4, 3);
        for(int i = 0; i<print.size();i++)
        {
            System.out.println(print.get(i));
        }
    }
}

/*
 * Approach 2 - Using a Custom comparator in Max Heap Solution
 * TC = O(klogk + nlogk)
 */
class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        PriorityQueue<int []> pq = new PriorityQueue<>((a,b) ->
            {
               if(a[1] == b[1])
               {
                   return b[0] - a[0];
               }
                return b[1] - a[1];
            });
        
        for(int i = 0; i<arr.length;i++)
        {
            pq.add(new int[]{arr[i],Math.abs(arr[i] - x)});
            if(pq.size() > k)
            {
                pq.poll();
            }
        }
        
        List<Integer> result = new ArrayList<>();
        while(!pq.isEmpty())
        {
            int[] pair = pq.poll();
            result.add(pair[0]);
        }
        Collections.sort(result);
        return result;
    }
}

/*
 * Approach 3: 2 pointer method
 * TC - O(n-k)
 * 1) Have two pointers one at the first element, one at the last element.
 * 2)Calculate the abs distance between the elements and check which of the distances is greater than other and the pointers inwards equally.
 * 3)Continue this loop until the distance between both the pointers is n-k
 */
class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        int n = arr.length;
        int l = 0;
        int r = n -1;
        
        while(r-l+1 > k)
        {
            if(Math.abs(arr[l] - x) > Math.abs(arr[r] - x))
            {
                l++;
            }
            else
            {
            r--;}
        }
        
        List<Integer> result = new ArrayList<>();
        for(int i =l;i<=r;i++)
        {
            result.add(arr[i]);
        }
        return result;
    }
}