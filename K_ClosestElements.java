public List<Integer> findClosestElements(int[] arr, int k, int x) {
        int lo = 0, hi = arr.length - k;
        while (lo < hi) {
            int mid = (lo + hi) / 2;
            if (x - arr[mid] > arr[mid+k] - x)
                lo = mid + 1;
            else
                hi = mid;
        }
        List<Integer> result = new ArrayList<>();
        for(int i=lo;i<lo+k;i++){
            result.add(arr[i]);          
        }
        return result;
    }