class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        List<Integer> result = new ArrayList<>(); // we take a list which has the integer values and the name of the list is given as result.
        if(arr == null || arr.length == 0) return result; //base case where if the array is null or the length of the array is 0, we simply return the new Arraylist
        int low = 0, high = arr.length -k; // we declare the value of low as 0 and the value of high to arraylength - k in the array
        while(low < high) { // when low is less than high
            int mid = low + (high - low) / 2; // compute the mid and we store it in an integer variable called as mid.
            int distA = x - arr[mid]; // we find the distance from x to the mid element and store it in an integer variable called as distA.
            int distB = arr[mid + k] - x; // we find the distance from mid + k element to the current element x and we store it in an integer variable called as distB
            if(distA > distB) { // when distA is greater than distB which means distA is far away from the desired surrounding elements of x.
                low = mid + 1; // we increase the low from index 0 to mid + 1
            }
            else { //// if distB is greater than distA which means distB is far away from the desired surrounding elements of x
                high = mid; // we reduce the high pointer from last element to the mid element
            }
        }
        for(int i = low; i < low + k; i++) { // when we come here we will have low is greater than or equal to high. when low becomes greater than or equal to high, we iterate through the array starting from low until low + k elements
            result.add[arr[i]]; // we add each of the elements to the result array
        }
        return result; // in the end, we return the result.
    }
}
// tc - O(log(n-k)) + O(k) and sc - O(1)