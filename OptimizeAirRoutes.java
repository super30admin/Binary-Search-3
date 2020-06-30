// Time Complexity : O(m + n) where m is length of forward route and n is the length of return route (Assuming list arrays are sorted)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : Another version of two sum
/* Your code here along with comments explaining your approach: Keep pointer p1 at the forward route list and pointer p2 at the return route list.
Move the pointer p1 forward and p2 is intended to move backward while they reach out of the bounds. Compare p1 distance in addition to p2 distance
whether the total distance is lesser than or equal to max travel distance. If yes, keep the max distance got till now satisfying this condition. 
Store the pairs in integer array. Check if the result list has equal max pairs, else remove them from the result list.
*/
class Solution{
    public List<PairInt> getOptimizedUtilize(int maxTravelDist, List<int[]> forwardRouteList, List<int[]> returnRouteList){
    List<int[]> result=new ArrayList<>();
    int[] pair = new int[2];
    int max=Integer.MIN_VALUE;
    int p1 = 0;
    int p2 = returnRouteList.size()-1;
    while(p1 < forwardRouteList.size() && p2 >= 0){                                                         // p1 moving forward and p2 moving backward
            if(forwardRouteList.get(p1)[1] + returnRouteList.get(p2)[1] <= maxTravelDist){
                max = Math.max(max, forwardRouteList.get(p1)[1] + returnRouteList.get(p2)[1]);                  // if total distance is <= Max travel distance
                pair[0] = forwardRouteList.get(p1)[0];                                                          // Get the route number from first list
                pair[1] = returnRouteList.get(p2)[1];                                                               // Get the route number from second list
                result.add(pair);                                                                           // Add the pair to the result
                p1++;                                                                                       // Move forward
            } else {
                p2--;                                                                                       // distance exceeds max travel distance
            }
        }
    for(int i =0 ; i < result.size(); i++)
      if(result.get(i)[1] != max)
            result.remove(i);                                                                                   //Remove the pairs that are not equal to max distance got 
      return result;
  }