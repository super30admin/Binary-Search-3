class Solution {
    public double myPow(double x, int n) {
        

        if (n ==0) {
            return 1.0;
        } 
        double y = myPow(x, n/2);
        if (n%2 == 0) {
            return y*y;
        } else {
            if (n >0) {
                return y*y*x;
            } else {
                return y*y*1/x;
            }
        }

    }
}
class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        List<Integer> result = new ArrayList<Integer>();
        int l = 0;
        int r = arr.length-1;
        int startD =0;
        int endD = 0;
        while (l<r) {
            if ( r-l+1 == k) {
                break; 
            }
            startD = x-arr[l];
            endD = arr[r] - x;
            if (startD < endD) {
                r--;
            } else if(startD > endD) {
                l++;
            } else if (startD == endD){
                r--;
            }
        }
        for (int i=l;i<=r;i++) {
            result.add(arr[i]);
        }
        return result;
    }
}
