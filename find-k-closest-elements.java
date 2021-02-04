// Time Complexity : O(k+logn)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode :yes
// Any problem you faced while coding this :no


// Your code here along with comments explaining your approach
// binary search to find closest index then linear search k-1 times

class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        int pos = findElement(arr,x);
        LinkedList<Integer> res = new LinkedList<Integer>();
        res.add(arr[pos]);
        int l = pos-1;
        int r = pos+1;
        while(k>1){
            if(l<0) res.addLast(arr[r++]);
            else if(r>=arr.length) res.addFirst(arr[l--]);
            else {
                if(x-arr[l]<=arr[r]-x) res.addFirst(arr[l--]);
                else res.addLast(arr[r++]);
            }
            k--;
        }
        return res;
    }
    
    private int findElement(int[] arr, int x){
        int l = 0;
        int r = arr.length-1;
        while(l<r){
            int mid = l+(r - l)/2;
            if(arr[mid] == x) return mid;
            if(arr[mid] > x){
                r = mid-1;
            } else {
                l = mid+1;
            }
        }
        if(l==0) return l;
        return (Math.abs(arr[l]-x) < Math.abs(arr[l-1]-x)) ? l : l-1;
    }
}