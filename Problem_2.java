// Time Complexity :O(n)
// Space Complexity :o()
// Did this code successfully run on Leetcode :
// Three line explanation of solution in plain english

// Your code here along with comments explaining your approach

//Below is the brute force solution.

class Solution {
    class pair{
        int value;
        int absoluteValue;
        pair(int val,int abs){
            this.value=val;
            this.absoluteValue=abs;
        }
    }
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        List<Integer> result=new ArrayList<>();
        pair[] compArra=new pair[arr.length];
        for(int i=0;i<arr.length;i++){
            compArra[i]=new pair(arr[i],Math.abs(arr[i]-x));
        }
        Arrays.sort(compArra,((a,b)->{
            if(a.absoluteValue==b.absoluteValue){
                return a.value-b.value;
            }else{
                return a.absoluteValue-b.absoluteValue;
            }
        }));
        for(int i=0;i<k;i++){
            result.add(compArra[i].value);
        }
        Collections.sort(result);
        return result;
    }
}