//Problem 1: x raised to pow n
// Time Complexity : O(logn)
// Space Complexity : O(logn) stack space
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no
// Your code here along with comments explaining your approach
//Each iteration give recursive call to self function with n/2 , if n reaches 0, return 1.0.
class Solution {
    public double myPow(double x, int n) {
        //base
        if(n==0) return 1.0;
        //logic
        double result=myPow(x,n/2);
        if(n%2==0) return result*result;
        else{
            if(n<0) return result*result*(1/x);
            else
                return result*result*x;
        }
    }
}



//Problem 2: find K closest elements
// Time Complexity : O(log(n-k))
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no


// Your code here along with comments explaining your approach
//Search for starting index of the range for k closest elements, do it via binary search in log n manner
class Solution {
    List<Integer> res;
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        this.res=new ArrayList<>();

        //Best Solution O(log(n-k))
        int low=0,high=arr.length-k;
        while(low<high){
            int mid=low+(high-low)/2;
            int distS= x-arr[mid];
            int distE=arr[mid+k-1+1] -x;
            if(distS>distE) low=mid+1;
            else
                high=mid;
        }
        for(int i=low;i<low+k;i++)
            res.add(arr[i]);
        
        return res;








        //O(n-k) +O(k) worst case O(n)
        // int low=0, high=arr.length-1;

        // while(high-low+1>k){ //O(n-k)
        //     int distL=Math.abs(x-arr[low]);
        //     int distH=Math.abs(x-arr[high]);

        //     if(distL>distH){
        //         low++;
        //     }else
        //         high--;
        // }

        // for(int i=low;i<=high;i++) //O(k)
        //     res.add(arr[i]);
        // return res;

        //find number which is just greater than or just smaller than x, then iteratively add elements in arr.


        //heap Solution O(n+k+klogk)=O(n)
        // PriorityQueue<int[]> pq=new PriorityQueue<>((a,b)->{ //max heap(b-a)
        //     if(a[0]==b[0])
        //         return b[1]-a[1];
        //     return b[0]-a[0];
        // });
        // for(int i=0;i<arr.length;i++){ //O(n)
        //     int dist=Math.abs(arr[i]-x);
        //     int[] p= new int[]{dist, arr[i]};
        //     pq.add(p);
        //     if(pq.size()>k) pq.poll();
        // }

        // while(!pq.isEmpty()){ //O(k)
        //     int[] pair=pq.poll();
        //     res.add(pair[1]);
        // }
        // Collections.sort(res);//O(klogk)
        // return res;
    }
}
