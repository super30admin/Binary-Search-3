import java.util.ArrayList;
import java.util.List;

/*
Time Complexity: O(log(n-k)+k) n is the number of elements in the array and k is the number of elements we want to return
Space Complexity: O(1) constant space as the result arraylist is not a part of algorithm
Run on leetcode: yes

Approach:
Attempted once discussed in the class
 */
public class FindKClosestElements {
    public static List<Integer> kClosestElements(int[] arr, int k, int x){
        int left = 0;
        int right = arr.length-k;

        while(left<right){
            int mid = left+(right-left)/2;

            if(x-arr[mid] > arr[mid+k]-x){
                left = mid+1;
            }else{
                right = mid;
            }
        }

        List<Integer> result = new ArrayList<>();
        for(int i = left; i<left+k; i++){
            result.add(arr[i]);
        }
        return result;
    }

    public static void main(String[] args){
        int[] nums = {1,2,3,4,5};

        System.out.println("Missing elements: "+kClosestElements(nums, 4,3));
    }
}
