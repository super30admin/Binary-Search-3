// Time Complexity : O( m log n) m = elements in a and n= elements in b.
 
// Space Complexity : O(1)'

// Did this code successfully run on Leetcode :yes. 

// Any problem you faced while coding this :


// Your code here along with comments explaining your approach
// sort one list and iterarate over the non sorted list, then do a binary search using the sorted list.

//Runtime: 0 ms, 
 private static List<int[]> getPairs(List<int[]> a, List<int[]> b, int target) {
    Collections.sort(b, (i,j) -> i[1] - j[1]);
    List<int[]> result = new ArrayList<>();
    int max = Integer.MIN_VALUE;
    for (int i = 0; i < a.size(); i++) {
        int index = bsearch(target - a.get(i)[1], b);
        if (index >= 0 && index <= b.size()) {
            int sum = a.get(i)[1] + b.get(index)[1];
            if (sum <= target && sum >= max) {
                 if (sum > max) {
                    result.clear();
                    max = sum;
                }
                result.add(new int[]{a.get(i)[0], b.get(index)[0]});   
            }
        }
    }
    return result;
} 

private static int bsearch(int target, List<int[]> list) {
    int start = 0, end = list.size() - 1;
    while (start <= end) {
        int mid = start + (end - start)/2;
        int val = list.get(mid)[1];
        if (list.get(mid)[1] == target)
            return mid;
        else if (val < target)
            start = mid + 1;
        else 
            end = mid - 1;
    }
    return end < 0 ? 0 : end;
}

