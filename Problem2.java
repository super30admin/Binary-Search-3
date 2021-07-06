// Time Complexity: O(max(log(N), K))
// Space Complexity: O(max(log(N), K))
// Passed Leetcode

import java.util.*;

class Solution {
    int x;
    int[] arr;
    public int binarySearch(int low, int high) {
        
        if (high - low == 0) {
            return high;
        }
        
        int mid = low + (high - low) / 2;
        
        if (arr[mid] > x) {
            return binarySearch(low, mid);
        } else {
            return binarySearch(mid + 1, high);
        }
    }
    
    
    public void slice(LinkedList curr, int low, int high) {
        for (int i = low; i < high; i++) {
            curr.add(arr[i]);
        }
    }
    
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        
        this.x = x;
        this.arr = arr;
        int index = binarySearch(0, arr.length - 1);
        
        LinkedList<Integer> curr = new LinkedList<>();
        slice(curr, Math.max(index - k, 0), Math.min(index + k + 1, arr.length));
        while (curr.size() > k) {

            if (Math.abs(curr.getFirst().intValue() - x) == Math.abs(curr.getLast().intValue() - x) || Math.abs(curr.getFirst().intValue() - x) < Math.abs(curr.getLast().intValue() - x))
                curr.removeLast();
            else curr.removeFirst();

        }
        return curr;

        
    }
}