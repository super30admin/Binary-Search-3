// Time Complexity : O(logn) in 2 pointer approach
// Time Complexity : O(logn+k) in 2 pointer approach
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


//Your code here along with comments explaining your approach
// 2 pointer + binary search approach
//Perform binary search once to find the closest element to x.
//Once we have that element, use 2 pointer low = bClosest -1 and high = bClosest + 1 to fine k closest elements


class Solution {

    public List<Integer> findClosestElements(int[] arr, int k, int x) {

        LinkedList<Integer> result = new LinkedList();
        if(arr == null || arr.length == 0) return result;
        int low = 0;
        int high = arr.length -1;

        int bClosest = binarySearch(arr, x, low, high);
        low = bClosest -1;
        high = bClosest + 1;
        result.add(arr[bClosest]);
        while(k>1) {
            if(low < 0) { //low boundary hit, we can only pick values from high
                result.addLast(arr[high]);
                high++;
            } else if (high >= arr.length) { // boundary hit
                result.addFirst(arr[low]);
                low--;
            } else {
                int distL = Math.abs(arr[low] -x);
                int distR = Math.abs(arr[high] -x);
                if(distL > distR) {
                    result.addLast(arr[high]);
                    high++;
                } else { //dist of low element is less than dist of high element, so we pick low element
                    result.addFirst(arr[low]);
                    low--;
                }
            }
            k--;
        }

        return result;
    }

    public int binarySearch(int[] arr, int target, int low, int high) {

        while(low < high) {
            int mid = low + (high - low) /2;
            if(arr[mid] == target) {
                return mid;
            } else if(arr[mid] > target) {
                high = mid; //We dont want to lose mid, incase where the arr[mid] == target wont be true;
            } else {
                low = mid + 1;
            }

        }
        //Low will be at the element closest to x
        if(low == 0) return low;

        //Low-1 can be the closest element, check for that an return low-1 if thats the case
        if(Math.abs(arr[low-1]-target) <= Math.abs(arr[low]-target))
            return low-1;
        else
            return low;
    }


//Basic 2 pointer approach
//Low and High will be incremented/decremented based on the diffL & diffR
//We want to move in the direction of smaller distance

    public List<Integer> findClosestElements2Pointers(int[] arr, int k, int x) {
        List<Integer> result = new ArrayList();
        if(arr == null || arr.length == 0) return result;
        int low = 0;
        int high = arr.length -1;

        while( (high-low) >= k) {
            int distL = Math.abs(arr[low] -x);
            int distR = Math.abs(arr[high] -x);

            if(distL > distR) {
                low++;
            } else {
                high--;
            }
        }

        for(int i = low; i<= high; i++) {
            result.add(arr[i]);
        }

        return result;
    }
}
