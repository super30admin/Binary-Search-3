//Pow(x,n)
// Time Complexity :0(logn)
// Space Complexity :O(1)
// Did this code successfully run on Leetcode :yes
// Any problem you faced while coding this :no


// Your code here along with comments explaining your approach

class Solution {
    public double myPow(double x, int n) {
      if(n==0)
          return 1;
        double recurr= myPow(x,n/2);
        
        
        if(n%2==0)
            return recurr*recurr;
        else{
            if(n<0)
            {
                return recurr*recurr*1/x;
            }
            else
            return recurr*recurr*x;
        }
    }
}

//Find K closest Elements
// Time Complexity :O(logn)
// Space Complexity :O(1)
// Did this code successfully run on Leetcode :yes
// Any problem you faced while coding this :no


// Your code here along with comments explaining your approach

class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        int l=0;
        int h= arr.length-k;
        
        while(l<h)
        {
            int mid= l +(h-l)/2;
            int L_D= Math.abs(x-arr[mid]);
            int R_D=Math.abs(x-arr[mid+k]);
            
            if(L_D>R_D)
            {
                l=mid+1;
            }
            else {
                if(arr[mid]==arr[mid+k])
                {
                    l=mid+1;
                }
                else
                {
                    h=mid;
                }
            }
        }
        List<Integer> output = new ArrayList<>();
        for(int i=l;i<l+k;i++)
        {
            output.add(arr[i]);
        }
        return output;
    }
}

//optimised routes
// Time Complexity :O(logn)
// Space Complexity :O(1)
// Did this code successfully run on Leetcode :yes
// Any problem you faced while coding this :no




import java.util.*;
class Solution{
    
     public static void main(String[] args){

       Solution s =new Solution();

       int[][] forward= {{1, 2000}, {2, 4000}, {3, 6000}};

       int[][] backward={{1, 2000}};

       int target=7000;
       
       List<int[]> res=s.optimalAirRoute(forward,backward,target);

       if(res!=null){

           for(int i=0;i<res.size();i++){

           System.out.println(res.get(i)[0]+","+res.get(i)[1]);

       }

       }

   }
    public List<int[]> optimalAirRoute(int[][]forward,int[][] backward, int target){

       List<int[]> output=new ArrayList<>();

       if(forward.length==0||backward.length==0||target==0){

           return output;

       }

       int max=0;

       Arrays.sort(backward,(a,b)->(a[1]-b[1]));

       for(int i=0;i<forward.length;i++){

           int index=binarySearch(backward,target-forward[i][1]);

           if(index!=-1){

               int sum=forward[i][1]+backward[index][1];

               if(sum>=max){

                   if(sum>max){

                       output=new ArrayList<>();

                   }

                   max=Math.max(max,sum);

                   output.add(new int[]{forward[i][0],backward[index][0]});

               }

           }

       }

       return output;

   }

   public int binarySearch(int[][] backward,int target){

       int left=0;

       int right=backward.length-1;

       while(left<right);

       int mid=left+(right-left)/2;

       if(backward[mid][1]==target){

           return mid;

       }

       else if(backward[mid][1]<target){

           left=mid;

       }

       else{

           right=mid-1;

       }

       return right;

   }

   

}
