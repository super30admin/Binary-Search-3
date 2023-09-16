//TC = O(logn+k) 
//SC = (k) auxilary.
//Here we are found the window of (right-left+1 > k) then get the distance from left and righ direction. 
//then iterate over left to right and return.

class FindKClosest{
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
    int left = 0;
    int right = arr.length-1;
    //ArrayList<Integer> list = new ArrayList<>();
    while(right-left+1 > k){
        int distL = x-arr[left];
        int distR = arr[right]-x;
        if(distL>distR){
            left++;
        }else{
            right--;
        }
    }
        List<Integer> result = new ArrayList<>();
        for(int i = left; i<=right; i++ ){
            result.add(arr[i]);
        }
        return result;
    }
}
