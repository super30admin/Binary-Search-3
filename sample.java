class Solution {
    public double myPow(double x, int n) {

        //base
        if ( n == 0) return 1.0;
        //logic
        double result = myPow(x,n/2);
        if(n % 2 == 0){
            return result * result;
        }
        else{
            if (n > 0){
                return result * result * x;
            }
            else{
                return result * result * (1 / x);
            }
        }


    }
    //o(log(n-k)) time o(1) space

    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        int l = 0; int h = arr.length - k;
        List<Integer> result = new ArrayList<>();
        if(arr == null || arr.length == 0) return result;

        while(l < h){
            int mid = l + (h - l)/2;
            int distS = x - arr[mid];
            int distE = arr[mid + k] - x;

            if(distS > distE){
                l = mid + 1;
            }
            else{
                h = mid;
            }
        }
        for (int i = l; i < l + k; i++){
            result.add(arr[i]);
        }
        return result;
    }

}