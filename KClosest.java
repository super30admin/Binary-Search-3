// Time Complexity : 0(k + log n) log n for binary search and k for while loop iteration
// Space Complexity : 0(k) for priority queue
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :

class KClosest {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        int index = binarySearch(arr, 0, arr.length-1, x);

        int left = index - 1, right = index + 1;

        //size 0(k)
        PriorityQueue<Integer> pq = new PriorityQueue<>((a,b) -> (a - b));

        //compare arr[index] & x
        if(arr[index] == x)
            pq.add(arr[index]);
        else if(arr[index] > x)
            right = index;
        else if(arr[index] < x)
            left = index;

        //loop till pq size == k
        if(pq.size()!=k){
            //time complexity - 0(k)
            while(left >= 0 && right < arr.length){
                if(Math.abs(arr[right] - x) < Math.abs(x - arr[left])){
                    pq.add(arr[right]);
                    right++;
                }else{
                    pq.add(arr[left]);
                    left--;
                }

                if(pq.size() == k){
                    break;
                }
            }
        }
        //see if pq is still not filled, then add remaining elements
        if(pq.size()!=k){
            while(left >=0){
                pq.add(arr[left]);
                left--;
                if(pq.size() == k){
                    break;
                }
            }

            while(right < arr.length){
                pq.add(arr[right]);
                right++;
                if(pq.size() == k){
                    break;
                }
            }
        }
        //add elements to list
        List<Integer> result = new ArrayList<>();
        while(!pq.isEmpty()){
            result.add(pq.poll());
        }

        return result;

    }

    //binary search - time complexity - 0(log n)
    public int binarySearch(int[] arr, int start, int end, int target){
        if(end < start){
            return (start + end)/2;
        }

        int mid = start+ (end - start)/2;
        if(arr[mid] == target){
            return mid;
        }else if(arr[mid] > target){
            return binarySearch(arr, start, mid-1, target);
        }else{
            return binarySearch(arr, mid+1, end, target);
        }
    }
}