//Time Complexity :O(N+KLog(K)). reduced to O(N+K) using linkedlist
//Space Complexity :O(1)
//Did this code successfully run on Leetcode :yes
//Any problem you faced while coding this :Nope
I think We can make the time complexity to O(Log(N)+K) by using binary search. tried that one but unable to terminate the condition whether to go left or right.

//Your code here along with comments explaining your approach
class Solution {
	
	public List<Integer> findClosestElements1(int[] ar, int k, int x) {
        LinkedList<Integer> result = new LinkedList<>();
        int startIndex = -1, minDiff = Integer.MAX_VALUE, start = 0, end = ar.length -1;
//         while(start < end){
//             int mid = start + (end-start)/2;
//             int midDiff = Math.abs(ar[mid],x);
//             int startDiff = Math.abs(ar[start],x);
//             int endDiff = Math.abs(ar[start],x);
//             int min = Math.min(midDiff,Math.min(startDiff,endDiff));
//             if(min == midDiff){
                
//             }else if(min == startDiff){
//                 end = mid-1;
//             }else{
//                 start = mid + 1;
//             }
//         }
        //binary Search would be better
        for(int i = 0; i < ar.length; i++){
            int diff = Math.abs(x-ar[i]);
            if(minDiff > diff){
                startIndex = i;
                minDiff = diff;
            }
        }
        int leftIndex = startIndex - 1, rightIndex = startIndex+1;
        result.add(ar[startIndex]);
        k--;
        while(k > 0 && leftIndex >= 0 && rightIndex < ar.length){
            int leftDiff = Math.abs(ar[leftIndex]-x);
            int rightDiff = Math.abs(ar[rightIndex]-x);
            if(leftDiff <= rightDiff){
                result.addFirst(ar[leftIndex]);
                leftIndex--;
            }else{
                result.addLast(ar[rightIndex]);
                rightIndex++;
            }
            k--;
        }
        while(k > 0 && leftIndex >= 0){
            result.addFirst(ar[leftIndex]);
            leftIndex--;
            k--;
        }
        while(k > 0 && rightIndex < ar.length){
            result.addLast(ar[rightIndex]);
            rightIndex++;
            k--;
        }
    return result;
    }
	
    public List<Integer> findClosestElements2(int[] ar, int k, int x) {
        List<Integer> result = new ArrayList<>();
        int startIndex = -1, minDiff = Integer.MAX_VALUE, start = 0, end = ar.length -1;
//         while(start < end){
//             int mid = start + (end-start)/2;
//             int midDiff = Math.abs(ar[mid],x);
//             int startDiff = Math.abs(ar[start],x);
//             int endDiff = Math.abs(ar[start],x);
//             int min = Math.min(midDiff,Math.min(startDiff,endDiff));
//             if(min == midDiff){
                
//             }else if(min == startDiff){
//                 end = mid-1;
//             }else{
//                 start = mid + 1;
//             }
//         }
        //binary Search would be better
        for(int i = 0; i < ar.length; i++){
            int diff = Math.abs(x-ar[i]);
            if(minDiff > diff){
                startIndex = i;
                minDiff = diff;
            }
        }
        int leftIndex = startIndex - 1, rightIndex = startIndex+1;
        result.add(ar[startIndex]);
        k--;
        while(k > 0 && leftIndex >= 0 && rightIndex < ar.length){
            int leftDiff = Math.abs(ar[leftIndex]-x);
            int rightDiff = Math.abs(ar[rightIndex]-x);
            if(leftDiff <= rightDiff){
                result.add(ar[leftIndex]);
                leftIndex--;
            }else{
                result.add(ar[rightIndex]);
                rightIndex++;
            }
            k--;
        }
        while(k > 0 && leftIndex >= 0){
            result.add(ar[leftIndex]);
            leftIndex--;
            k--;
        }
        while(k > 0 && rightIndex < ar.length){
            result.add(ar[rightIndex]);
            rightIndex++;
            k--;
        }
        Collections.sort(result);
    return result;
    }
}