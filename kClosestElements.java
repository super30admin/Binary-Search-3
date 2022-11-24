package s30.binarySearch.b3;

import java.util.ArrayList;
import java.util.List;

//ALGO: 2 poniters => find the floor index of the target in the array and implement 2 pointers
// TC: O(logn + n + n)
//SC: O(1)

//ALgo : BinarySearch => n=binary search for the first index on 0 and n-k indices and check if it can be the first index;
//TC O(logn+ n)
//SC: O(1)
public class kClosestElements {

    public List<Integer> findClosestElementsBin(int[] arr, int k, int x) {
        int n = arr.length;
        int start = 0;
        int end = n - k;

        List<Integer> res = new ArrayList();

        while(start < end){

            int mid = start + (end - start) /2;

            if( Math.abs(arr[mid] - x) == Math.abs(arr[mid+k] -x)){

                if( x > arr[mid+k]) start = mid+1;

                else end = mid;
            }
            else if( Math.abs(arr[mid] - x) < Math.abs(arr[mid+k] -x)){
                end = mid;
            }
            else start = mid+1;

        }


        while(k >0){
            res.add(arr[start++]);
            k--;
        }


        return res;
    }
    public static List<Integer> findClosestElements(int[] arr, int k, int x) {

        int start = getIndex(arr, x);
        int end = start+1;

        List<Integer> res = new ArrayList();

        while( k > 0){

            if(end == arr.length || (start >=0 && Math.abs(arr[start] - x) <= Math.abs(arr[end] - x))){
                start--;
            }
            else {
                end++;
            }

            k--;
        }


        for(int i = start+1 ; i < end ; i++){
            res.add(arr[i]);
        }

        return res;
    }


    public static int getIndex(int[] arr, int x){
        int left = 0, right = arr.length-1;
        int mid =0;

        while(left <= right){

            mid = left + (right-left)/2;

            if(arr[mid] == x)
                return mid;
            else if(arr[mid]>x){
                right = mid-1;
            }
            else left = mid+1;
        }
        return right;
    }
    public static void main(String[] args) {

    }
}
