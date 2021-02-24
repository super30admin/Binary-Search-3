package Binary-Search-3;
// Time Complexity : O(log(n)+k)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode :
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach
public class KClosestElement {
    class Solution {
    
        private int binarySearch(int [] arr, int x)
        {
            int low = 0;
            int high = arr.length-1;
            while(low<high)
            {
                int mid = low + (high-low)/2;
                if(arr[mid] == x) return mid;
                else if(arr[mid]>x) high = mid;
                else low = mid+1;
            }
            if(low==0) return 0;
            if(Math.abs(arr[low]-x)<Math.abs(arr[low-1]-x)) return low;
            return low-1;
        }
        public List<Integer> findClosestElements(int[] arr, int k, int x) {
            List<Integer> result = new ArrayList<>();
            if(arr.length == 0) return result;
            int index = binarySearch(arr,x);
            int left = index -1;
            int right = index + 1;
            result.add(arr[index]);
            while(k>1)
            {
                if(left<0)
                {
                    result.add(arr[right]);
                    right++;
                }else if(right == arr.length)
                {
                    result.add(0,arr[left]);
                    left--;
                }else{
                    
                    if(Math.abs(arr[left]-x)>Math.abs(arr[right]-x))
                    {
                        result.add(arr[right]);
                        right++;
                        
                    }else{
                        result.add(0,arr[left]);
                        left--;
                    }
                }
                k--;
            }
            
            
            return result;
        }
    }    
}
