//Time: log(n-k) + k
//space: O(1)
class KClosestElements{

    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        //list to store results
        List<Integer> res = new ArrayList<>();
        // if input array is empty
        if(arr==null || arr.length==0) return res;
        //initializing low and high pointer
        int l=0, r = arr.length-k;

        //until low meets high
        while(l<r){
            //get mid
            int mid = l+(r-l)/2;
            //distance x from mid element
            int distL = x-arr[mid];
            //distance x from mid+k element
            int distR = arr[mid+k]-x;

            //mid element greater than mid+k element
            if(distL > distR){
                //search to the right
                l = mid+1;
            }
            else{
                //search to the left
                r = mid;
            }
        }
        //add the k element to the result
        for(int i=l; i<l+k; i++){
            res.add(arr[i]);
        }

        return res;
    }
}