// Time Complexity :O(n-k)
// Space Complexity :O(k)
// Did this code successfully run on Leetcode :Yes
// Any problem you faced while coding this :No


// Your code here along with comments explaining your approach
// In this apparoach we are using two pointers
class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        
      int l = 0;
      int r = arr.length-1;
      
      List<Integer> result = new ArrayList<>();
      
      if(arr==null || arr.length==0)
      {
        return result;
      }
      
      
      
      while(r-l>=k)
      {
        //check the difference of the left element with x and right element with x
        //if the difference is more as compared to right then we move to the right 
        //else we move to the left
        //and we do this till we get the window equal to k

        if(Math.abs(arr[l]-x)>Math.abs(arr[r]-x))
        {
          l++;
          
        }
        
        else
        {
          r--;
        }
      }
      
      for(int i=l;i<=r;i++)
      {
        result.add(arr[i]);
      }
      return result;
    }
}









// Time Complexity :O(logn+k)
// Space Complexity :O(k)
// Did this code successfully run on Leetcode :Yes
// Any problem you faced while coding this :No


// Your code here along with comments explaining your approach
// In this apparoach we are using two pointers with binary search



class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
      
      List<Integer> result = new ArrayList<>();
      if(arr==null || arr.length==0)
      {
        return result;
      }
       
      int low = 0;
      // high  to be k distance away from the last element in the array
      int high = arr.length-k;
      //binary search to find the first element after which we add k elements to the result
      int first = binarySearch(arr,low,high,k,x);

      //add k elements from the starting position the result
      for(int i=first;i< first+k ;i++)
      {
        result.add(arr[i]);
      }
      return result;
    }
      private int binarySearch(int[] arr,int low,int high,int k ,int x)
      {
        while(low<high)
        {
          int first = low + (high-low)/2;
          int last = first + k -1;
          //find the starting element on the left side of mid as distance in less in the left side
          if(first >0 &&(x-arr[first-1]<=arr[last]-x))
          {
            high = first -1;
          }
          //find the starting element on the right side of mid as difference is less on the right side
          else if(last<arr.length-1&&(x-arr[first]>arr[last+1]-x))
          {
            low = first + 1;
          }
          else
          {
            return first;
          }
        }
        return low;
      }
        
    
}