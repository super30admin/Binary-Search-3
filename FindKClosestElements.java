
// Two pointer approach
public class FindKClosestElements_1 {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        int low = 0, high = arr.length-1;
        while(high-low+1>k){
            int distL = Math.abs(x-arr[low]);
            int distR = Math.abs(arr[high]-x);
            if(distL>distR) low++;
            else high--;
        }
        List<Integer> result = new ArrayList<>();
        for(int i=low;i<=high;i++){
            result.add(arr[i]);
        }
        return result;
    }
}

// Time Complexity - O(n)

// Optmized binary search
public class FindKClosestElements_2 {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        int low = 0;
        int high = arr.length-k;
        while(low<high){
            int mid = low+(high-low)/2;
            int distS = x-arr[mid];
            int distE = arr[mid+k]-x;
            if(distS>distE) low = mid+1;
            else high = mid;
        }
        List<Integer> result = new ArrayList<>();
        for(int i=low;i<low+k;i++){
            result.add(arr[i]);
        }
        return result;
    }
}

// Time Complexity - O(log(n-k)+k)