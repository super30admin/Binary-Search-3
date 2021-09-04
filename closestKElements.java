//Time Complexity:O(n)
//Space Compelxity:O(1)
class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        int front=0;
        int back=arr.length-1;
        while(back-front+1!=k){
            if(Math.abs(arr[front]-x)<=Math.abs(arr[back]-x)){
                back--;
            }
            else{
                front++;
            }
        }
        List<Integer> result=new ArrayList<Integer>();
        for(int i=front;i<=back;i++){
            result.add(arr[i]);
        }
        return result;
    }
}
//Time Complexity:O(n-k)+O(K)
//Space Compelxity:O(1)
class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        //Binary Search
        int low=0;
        int high=arr.length-k;
        while(low<high){
            int mid=low+(high-low)/2;
            int distL=x-arr[mid];
            int distR=arr[mid+k]-x;
            if(distL>distR){
                low=mid+1;
            }
            else{
                high=mid;
            }
        }
        List<Integer> result=new ArrayList<Integer>();
        for(int i=low;i<low+k;i++){
            result.add(arr[i]);
        }
        return result;
    }
}