
//approach-we are trying to search for the possible start index of the range and we are doing this by applying binarysearch on the first n-k(m) elements. for this m element we perform BS, and see if mid is the starting index. we do this by camparing the distance of mid from x(distS) to the distance of x from mid+k(distE). this way if distS is greater than distE ==> the starting index must be on the right side of mid or distE>distS then start index must be on the left side(i.e mid to mid +k has one extra element then our range,at this case distE>distS we want to include mid rather than mid+k so we can conclude the starting index is on mid or left of mid)
//time complexity-O(log(n-k))as we are cutting the calculations in half at each iteration and search space is n-k.
//space complexity-O(1)
class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        List<Integer> res=new ArrayList<>();
        int left=0;
        int right=arr.length-k;
        while(left<right){
            int mid=left+(right-left)/2;
            int startD=x-arr[mid] ;
            int endD=arr[mid+k]-x;
            if(startD>endD){
                left=mid+1;
            }else right=mid;
        }
        for(int i=right;i<right+k;i++){
            res.add(arr[i]);
        }
        
        return res;

    }

}
