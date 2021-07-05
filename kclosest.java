//Time Complexity:O(logN+k) where k is for shrinking the array into the k closest elements.
//SPace Complexity:O(k)
//In this problem, I'll be dividing my problem range in such a way that if the difference between my middle index -the given target on the left half is greter, then I'll move to the right half of the array, iterate through and add k closest elements to the resultant list. Else, I'll move to the left half and repeat the same process.
//This code was executed successfully and got accepted in leetcode.
class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        List<Integer> res=new ArrayList<>();
        int low=0;
        int high=arr.length-k;
        while(low<high){
            int mid=low+(high-low)/2;
            if(Math.abs(arr[mid]-x)>Math.abs(arr[mid+k]-x)){
                low=mid+1;
            }
            else{
                high=mid;
            }
            
        }
        for(int i=0;i<k;i++){
            res.add(arr[low+i]);
        }
        return res;
    }
}