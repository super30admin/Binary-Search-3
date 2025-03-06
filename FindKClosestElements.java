//2 pointer approach
class FindKClosestElements {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        int n= arr.length;
        int left=0;
        int right=n-1;
        while(right-left>=k)
        {
            int distL = Math.abs(arr[left] -x);
            int distR = Math.abs(arr[right] -x);
            if(distL > distR){
                    left++;
            }
            else{
                right--;
            }
        }
        List<Integer> res = new ArrayList<>();
        for(int i=left;i<=right;i++)
        {
            res.add(arr[i]);
        }
        return res;
    }
}

//Time Complexity (TC): O(n), where n is the length of the array.
//Space Complexity (SC): O(k), where k is the number of closest elements.