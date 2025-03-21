class Solution{
    /*****************PROBLEM-1*********************/
    //TC:0(Log n)
//SC:0(log n)
    class Solution {
        public double myPow(double x, int n) {
            if(n==0 || x==1){
                return 1.0;
            }
            double y=myPow(x,n/2);
            if(n%2==0){ //n is even
                return y*y;
            }else{ // n is odd
                if(n>0){ //n is positive
                    return y*y*x;
                }else{ //n is negative
                    return y*y*1/x;
                }
            }
        }
    }

    //TC: 0(log N-k)+0(k)
//SC: 0(1)
    class Solution {
        public List<Integer> findClosestElements(int[] arr, int k, int x) {
            if(arr.length==0 || arr==null || k==0){
                return new ArrayList<>();
            }
            int low=0,high=arr.length-k;
            List<Integer> result=new ArrayList<>();
            while(low<high){
                int mid=low+(high-low)/2;
                int startDistance=x-arr[mid];
                int endDistance=arr[mid+k]-x;
                if(startDistance>endDistance){
                    low=mid+1;
                }else{
                    high=mid;
                }
            }

            for(int i=low;i<low+k;i++){
                result.add(arr[i]);
            }
            return result;
        }
    }

    /*****************problem-2*********************/

    //TC: 0(N)
//SC: 0(1)
    class Solution {
        public List<Integer> findClosestElements(int[] arr, int k, int x) {
            if(arr.length==0 || arr==null || k==0){
                return new ArrayList<>();
            }
            int left=0,right=arr.length-1;
            List<Integer> result=new ArrayList<>();
            while(right-left+1>k){
                int leftDiff=x-arr[left];
                int rightDiff=arr[right]-x;
                if(leftDiff<=rightDiff){
                    right--;
                }else{
                    left++;
                }
            }

            for(int i=left;i<=right;i++){
                result.add(arr[i]);
            }
            return result;
        }
    }

}