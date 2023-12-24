// Time Complexity : O(log (n-k) + k)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this :no


class Solution {    
    // Time : O(log (n-k) + k)
    /*
    Optimized Solution:

    We know that this array is sorted, which means we can use binary search 
    We will need to find the optimal window and move the window left or right based on the distance
    Algorithm:
    1) We know that the start of the window can lie between 0 and n-k index (if we go above n-k then our window will exceed the array length remember we are looking for the start of the window)
    2) low pointer on 0 and high pointer on n-k position
    3) Find the mid, this mid will be the potential start of the window , and mid + k (one extra element in the window) will be the potential end of the window
    4) Now we need to use logic to find out where should our window move
    5) We will assume that x lies in the middle, in that case, x will be greater than the low element and less than the high element
    6) We will find the distance of the start of the window to the x which is distStart = x - arr[mid];
    7) we will find the distance of the end of the window to x which is distEnd  = arr[mid+k] - x;
    8) If the distance from the start is higher than the distance from the end , then it means we need to move the start on the right , which is low = mid+4
    9) In all other case , we will move on the left side , which is high = mid - 1. If the distance is lesser on the lower side than high then  makes sense to move the window towards the left side. However, if both are equi distant then according to the property in question i.e |a - x| == |b - x| and a < b
    we should be looking for elements which are lower , and that will be on the lower side.
    10) As soon as the low and high cross each other , then low will be pointing to the start of the window
    11) !! Very Important !!, there is an edge case, where  if mid + k goes out of bounds , then we should break as low is already pointingto the start of the window
    12) Mid + k means that there is one extra item in the window than k, We are looking at the extra element on the right to know that if the distance of that extra element will be lower than one the left.


    */
    public List<Integer> findClosestElements(int[] arr, int k, int x) {

        int low=0,high=arr.length - k;
        int mid =0;

        List<Integer> result = new ArrayList<>();

        while(low <= high){ // the point where they cross, low will be pointing to the starting element of the window
        mid = low + (high-low)/2; // prevent integer overflow
        if ((mid+k) >= arr.length ) break; // Edge case where arr length is 0 and k = 1, in that case we will just break and low will be pointing to  start of the element
        int distStart = x - arr[mid]; // We have the array in ascending order , so we assume that start element will be less than x 
        // In binary search we will find the window instead of a single element, hence we are adding k to mid to form the window of k
        int distEnd = arr[mid+k] - x; // We have the array in ascending order so we assume that end element is of larger value
        // We took Mid+k one extra element from the window to know that if the next element of end of our window is greater or not, maybe it is less distant , which will help us move

        if(distStart > distEnd){
            // This means that we will find lower element after the mid
            low = mid + 1;
        }
        else{
            high = mid-1; // This means we will find lower element before mid
        }
        
        }

        for(int i=low;i<low+(k);i++){
            result.add(arr[i]);
        }

        return result;
        
    }


// Time : O(n-k)+O(k)
// Brute force two pointer solution
    /*
    The question tells us that the array is sorted , which means the elements are in increasing order
    We need to find a window of k elements which are the closest to the element x , i.e distance 
    and the result needs to be sorted. 
    We can approach this problem using two pointers, low on the 0 th index and high on the last index

    We need to shrink the window of pointers to a point that between low and high there are k elements
    We will move the pointers based on the distance , we will assume that x lie in the middle of the array
    We will move the pointer closer to x which is far i.e if high is farther than low , we can move the high pointer towards x
    We will keep on doing it unil the elements between low and high are not k, once this condition is true , then low will be pointing to the 
    start of the resulting window and high will be pointing to the end.

    */
/*
    public List<Integer> findClosestElements(int[] arr, int k, int x) {

        // two pointer solution

        int low = 0, high = arr.length - 1;
        List<Integer> result = new ArrayList<>();

        while((high - low)+1 != k){ // the distances between them not k then   // O(n-k)

        int distLow = Math.abs( x - arr[low]); // assuming x is bigger 
        int distHigh = Math.abs(arr[high] - x); // assuming high is bigger

        if(distLow > distHigh){
            low++; // moving low right to find lower distance
        }
        else{
            high--; // miving high left to find the lower distance
        }
        }

        for(int i=low;i<=high;i++){ // O(k)
            result.add(arr[i]);
        }

        return result;

    }


    */
}