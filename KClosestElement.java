
import java.util.*;
//Time Complexity : O(N) for Two Pointer Approach,O(log N) for Binary Search
//Space Complexity : O(1) for all operations
//Did this code successfully run on Leetcode : Yes
//Any problem you faced while coding this : No

//Your code here along with comments explaining your approach

/*
 
*/
public class KClosestElement {
    public List<Integer> kclosestElement1(int arr[],int k,int target){
        List<Integer> list = new ArrayList<>();
        if(arr == null || arr.length == 0)
            return list;
        int low = 0,high = arr.length - 1;

        while(k < high - low){
            int leftDiff = arr[low] - target;
            int rightDiff = arr[high] - target;
            if(leftDiff > rightDiff){
                low++;
            }
            else {
                high--;
            }
        }
        for(int index = low; index < high; index++){
            list.add(arr[index]);
        }
        return list;
    }

    public List<Integer> kclosestElement2(int arr[],int k,int x){
        List<Integer> list = new ArrayList<>();
        if(arr == null || arr.length == 0)
            return list;
        int low = 0,high =arr.length - k;
        while(low < high){
            int mid = low + (high - low) / 2;
            int leftDiff = arr[mid] - x;
            int rightDiff = arr[mid + k] - x;
            
            if(leftDiff < rightDiff){
                high = mid - 1;
            }
            else {
                low = mid + 1;
            }
        }
        for(int index = low; index < low + k; index++){
            list.add(arr[index]);
        }
        return list;
    }

    public static void main(String args[]){
        int arr[] = {1,2,3,4,5};
        int k = 4,x = 3;
        KClosestElement closest = new KClosestElement();

        System.out.println(closest.kclosestElement1(arr, k, x));
        System.out.println(closest.kclosestElement2(arr, k, x));;
        k = 4;
        x= - 1;
        System.out.println(closest.kclosestElement1(arr, k, x));;
        System.out.println(closest.kclosestElement2(arr, k, x));;
    }
}