//Time Complexity:O(n)
//Space Complexity:O(1)
//Two pointers approach
class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        int n = arr.length;
        int low = 0;
        int high = n-1;

        while(high-low >=k){
            int distS=Math.abs(x-arr[low]);
            int distE=Math.abs(arr[high]-x);

            if(distS > distE)
                low++;
            else
                high--;
        }

        List<Integer> result = new ArrayList<>();
        for(int i =low;i<=high;i++)
            result.add(arr[i]);
        return result;
    }
}

//Time Complexity:O(n log k) +o(k log k)
//Space Complexity:O(1)
//Max heap of size k approach
class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        int n = arr.length;
        int low = 0;
        int high = n-1;

        PriorityQueue<int[]> pq = new PriorityQueue<>( //0 - num, 1 - dist
            (a,b)->{
                if(a[1]==b[1])
                    return b[0]-a[0];
                else
                    return b[1]-a[1];
            }
        );

        for(int i =0;i<n;i++){
            int[] temp = new int[2];
            temp[0]=arr[i];
            temp[1]= Math.abs(x-arr[i]);

            pq.add(temp);
            if(pq.size()>k)
                pq.poll();

        }

        List<Integer> result = new ArrayList<>();
        while(!pq.isEmpty())
            result.add(pq.poll()[0]);
        Collections.sort(result);
        return result;
    }
}

//Time Complexity:O(log (n-k))
//Space Complexity:O(1)
//Binary search to find start index of range, then find find k elements
class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        int n = arr.length;
        int low = 0;
        int high = n-k;

        while(low < high){
            int mid = low+(high-low)/2;

            int distS = x - arr[mid];
            int distE = arr[mid+k] - x;

            if(distS  > distE)
                low = mid+1;
            else
                high = mid;
        }

        List<Integer> result = new ArrayList<>();
        for(int i = low;i<low+k;i++)
            result.add(arr[i]);

        return result;
       
    }

}

