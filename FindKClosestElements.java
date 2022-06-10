//Time: O(N-K) | Space: O(1)

// Normal Two pointers soln
class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        int low = 0;
        int high = arr.length -1;
        // finding the range w.r.t size k, i.e, shrinking the range from start and end index down to k
        while((low+k) <= high) {
            int lowDiffX = Math.abs(arr[low]-x);
            int highDiffX = Math.abs(arr[high]-x);
            if(lowDiffX < highDiffX) high--;
            else if(lowDiffX > highDiffX) low++;
            else {
                if(arr[low] <= arr[high]) high--;
            }
        }
        List<Integer> res = new ArrayList<>();
        for(int i=low;i<=high;i++) {
            res.add(arr[i]);
        }
        return res;
    }
}

//Time: O(NLogK) | Space: O(K)
//Max heap soln
class Solution {
    class Node{
        int val;
        int diff;
        public Node(int val, int diff) {
            this.val = val;
            this.diff = diff;
        }
    }
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        PriorityQueue<Node> pq = new PriorityQueue<>((a,b) -> {
            if(a.diff != b.diff) return b.diff-a.diff;
            return b.val - a.val;
        });
        for(int i=0;i<arr.length;i++) { //O(N)
            pq.add(new Node(arr[i], Math.abs(arr[i]-x)));//O(LogK)
            if(pq.size() > k) {
                pq.poll();
            }
        }

        List<Integer> res = new ArrayList<>();
        while(!pq.isEmpty()) {
            res.add(pq.poll().val);
        }
        Collections.sort(res); //O(KLogK)
        return res;
    }
}

// Time: O(LogN)+O(K) | Space: O(1)
//*******PARTIAL WORKING SOLN
// Binary search on initial list, once find the element closest to our X,
// then exploring left and right of it, finding the K closest elements
class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        int low = 0;
        int high = arr.length -1;
        int mid = 0;
        while(low<=high) {
            mid = low+(high-low)/2;
            if(arr[mid] == x) {
                System.out.println(arr[mid]);
                break;
            }else if(arr[mid] < x) {
                low = mid+1;
            } else {
                high = mid-1;
            }
        }
        low = 0;
        high = arr.length -1;
        if(mid == high) {
            low = high-k;
        } else if (mid == low) {
            high = low+k;
        } else {
            int diffK1 = mid-1;
            int diffK2 = mid+1;
            boolean isChanged = false;
            while(diffK2-diffK1 < k) {
                isChanged = true;
                while(diffK1>low && diffK2<high) {
                    int diffX = Math.abs(arr[diffK1]-x);
                    int diffY = Math.abs(arr[diffK2]-x);
                    if(diffX < diffY || (diffX == diffY && arr[diffK1] < arr[diffK2])) {
                        diffK1--;
                    } else {
                        diffK2++;
                    }
                }
                while(diffK2-diffK1 < k && diffK2 < high)
                    diffK2++;
                while(diffK2-diffK1 < k && diffK1 > low)
                    diffK1--;

            }
            if(isChanged)  {
                low = diffK1;
                high = diffK2;
            } else {
                low = mid;
                high = mid+k;
            }
        }
        List<Integer> res = new ArrayList<>();
        if(arr.length <= 1) res.add(arr[0]);
        if(res.size() == 0)
            for(int i=low;i<high;i++) {
                res.add(arr[i]);
            }
        return res;
    }
}


// Time: O(Log(N-K)) | Space: O(1)
// Binary Search with finding the starting index of our K set of elements

class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        int low = 0;
        int high = arr.length-k;
        // applying binary search on low to high
        // until we reach the start index of the required range
        while(low<high) {
            int mid = low+(high-low)/2;
            int distL = x-arr[mid];
            int distR = arr[mid+k]-x;
            if(distL>distR) {
                low = mid+1;
            } else  {
                high = mid;
            }
        }
        List<Integer> result = new ArrayList<>();
        for(int i=low;i<low+k;i++) {
            result.add(arr[i]);

        }
        return result;
    }
}