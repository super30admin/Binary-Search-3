// Time Complexity : O(log n + k) where n - length of input array , k - # of closest elements 
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

// Using Binary Search
class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        List<Integer> list = new ArrayList<>();
        int index = binarySearch(arr,x);
        int start = Math.min(arr.length-1,index-1),end = Math.max(0,index);
        for(int i=0;i<k;i++){
            if(start >=0 && end < arr.length){
                int first = Math.abs(arr[start]-x);
                int second = Math.abs(arr[end]-x);
                if(first <= second)
                    list.add(0,arr[start--]);
                else
                    list.add(arr[end++]);
            }
            else if(start >= 0){
                list.add(0,arr[start--]);
            }
            else{
                list.add(arr[end++]);
            }
        }
        return list;
    }
    public int binarySearch(int[] arr,int x){
        int left =0,right = arr.length-1;
        while(left<right){
            int mid = left+(right-left)/2;
            if(arr[mid] == x)
                return mid;
            else if(arr[mid] < x)
                left = mid+1;
            else
                right = mid-1;
        }
        return left;
    }
}

// Approach -2 : Using Two Pointer approach
// Time Complexity : O(n-k) where n - length of input array , k - # of closest elements 
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        int left =0,right = arr.length-1;
        while(right-left >= k){
            if(Math.abs(arr[left]-x) <= Math.abs(arr[right]-x))
                right--;
            else
                left++;
        }
        List<Integer> res = new ArrayList<>();
        while(k > 0){
            res.add(arr[left++]);
            k--;
        }
        return res;
    }
}

// Approach - 3 : Using Min Heap
// Time Complexity : O(n log k), asymptotically O(n logk) - for Heapify and O(k logk) - for Sorting the output list
// Space Complexity : O(k) Heap to store k elements
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        PriorityQueue<Integer> heap = new PriorityQueue<>((a,b) -> Math.abs(a-x)-Math.abs(b-x)==0 ? a-b: Math.abs(a-x)-Math.abs(b-x));
        for(int i:arr)
            heap.add(i);
        List<Integer> res = new ArrayList<>();
        while(k>0){
            res.add(heap.poll());
            k--;
        }
        Collections.sort(res);
        return res;
    }
}

