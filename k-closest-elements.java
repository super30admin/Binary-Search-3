// Time Complexity : O(log n)
// Space Complexity : O(k) k is result list size
// Did this code successfully run on Leetcode : Yes

public class Solution {
	public List<Integer> findClosestElements(int[] InputArr, int k, int x) {
        LinkedList<Integer> result = new LinkedList<>();
        if(InputArr == null || InputArr.length == 0)
            return result;
        
        int size = InputArr.length - 1;
        if(InputArr[0] > x){
            //return first k elements in arr
            for(int i = 0; i < k; i++)
                result.addLast(InputArr[i]);
            return result;
        }
        if(InputArr[InputArr.length - 1] < x){
            // return last k elements in arr
            for(int i = size-k+1; i <= size; i++)
                result.addLast(InputArr[i]);
            return result;
        }
        
        int index = binarySearch(InputArr, x);
        result.addLast(InputArr[index]);
        
        int l = index - 1;
        int r = index + 1;
        while(k > 1){
            if(l < 0){
                result.addLast(InputArr[r]);
                r++;
            }
            else if(r == InputArr.length){
                result.addFirst(InputArr[l]);
                l--;
            }
            else{
                if(x - InputArr[l] <= InputArr[r] - x){
                    result.addFirst(InputArr[l]);
                    l--;
                }
                else{
                    result.addLast(InputArr[r]);
                    r++;
                }
            }
            k--;
        }
        
        return result;
	}
    private int binarySearch(int[] arr, int x){
        int low = 0;
        int high = arr.length - 1;
        while(low < high){
            int mid = low + (high - low)/2;
            if(arr[mid] == x)
                return mid;
            else if(arr[mid] > x){
                high = mid;
            }
            else{
                low = mid + 1;
            }
        }
        if(low == 0)
            return 0;
        if(Math.abs(arr[low - 1] - x) <= Math.abs(arr[low] - x))
            return low - 1;
        else
            return low;
    }
}

/*
// Time Complexity : O(n)
// Space Complexity : O(k) k is result list size
// Did this code successfully run on Leetcode : Yes
// two pointer solution

public class Solution {
	public List<Integer> findClosestElements(int[] InputArr, int k, int x) {
        List<Integer> result = new ArrayList<>();
        if(InputArr == null || InputArr.length == 0)
            return result;
        
        int lowPtr = 0;
        int highPtr = InputArr.length - 1;
        
        if(InputArr[0] > x){
            //return first k elements in arr
            for(int i = lowPtr; i < k; i++)
                result.add(InputArr[i]);
            return result;
        }
        if(InputArr[InputArr.length - 1] < x){
            // return last k elements in arr
            for(int i = highPtr-k+1; i <= highPtr; i++)
                result.add(InputArr[i]);
            return result;
        }
        
        while((highPtr - lowPtr) >= k){
            if(Math.abs(InputArr[lowPtr]-x)  <= Math.abs(InputArr[highPtr] -x))
                highPtr--;
            else
                lowPtr++;
        }
        for(int i = lowPtr; i <= highPtr; i++)
            result.add(InputArr[i]);
        return result;
	}
}
*/