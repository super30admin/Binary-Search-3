/*
Your task is to write an algorithm to optimize the sets of forward/return shipping route pairs that allow the aircraft to be optimally utilized, given a list a of forward routes and a list of return shipping routes.

INPUT
The input to the function/method consisits of three arguments:
maxTravelDist, an integer representing the maximum operating travel distance of the given aircraft;
forwardRouteList, a list of pairs of integers where the first integer represents the unique identifier of a forward shipping
route and the second integer represents the amount of travel distance required bu this shipping route;
returnRouteList, a list of pairs of integers where the first integer represents the unique identifer of a return shipping route
and the second integer represents the amount of travel distance required by this shipping route.

OUTPUT
Return a list of pairs of integers representing the pairs of IDs of forward and return shipping routes that optimally utilize the given aircraft. If no route is possible, return a list with empty pair.

Example 1:
Input:
maxTravelDist = 7000
forwardRouteList = [[1,2000],[2,4000],[3,6000]]
returnRouteList = [[1,2000]]

Output:
[[2,1]]

Explanation:
There are only three combinations [1,1],[2,1],and [3,1], which have a total of 4000, 6000, and 8000 miles, respectively. Since 6000 is the largest use that does tnot exceed 7000, [2,1] is the optimal pair.

Example 2:
Input:
maxTravelDist = 10,000
forwardRouteList = [[1,3000],[2,5000],[3,7000],[4,10000]]
returnRouteList = [[1,2000],[2,3000],[3,4000],[4,5000]]

Output:
[[2,4],[3,2]]*/


///////////////////////////////////////
//sort forward list and return list and use two pointers to compare sum of forward and return distance with capacity.
//first pointer  f is at forward list and second pointer r is at end of return list. 
//if sum>MAX_SUM and less than capacity then f++ add ids into results.if sum ==MAX_sum then f++ ,add ids into result else r-- .

//complexity of time  the sorting part complexity is O(MlogM + NlogN) 
//and two-pointer traversal is O(M + N), the final complexity can be regarded as O(KlogK) where K is the longest input array.


package binarysearch2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

public class AircraftDistance {
	
	public static List<List<Integer>> calculateOptimalRoute(final List<List<Integer>> forwardList, final List<List<Integer>> returnList,int capacity)
    {
        //System.out.println(forwardList);
        //System.out.println(returnList);

        // sort forward list
        Collections.sort(forwardList, new Comparator<List<Integer>>() {
            @Override
            public int compare(List<Integer> o1, List<Integer> o2) {
                return o1.get(1) - o2.get(1);
            }
        });

        // sort return list
        Collections.sort(returnList, new Comparator<List<Integer>>() {
            public int compare(List<Integer> o1, List<Integer> o2) {
                return o1.get(1) - o2.get(1);
            }
        });

        int max = 0;
        int i = 0;
        int j = returnList.size() - 1;

        List<List<Integer>> result = null;
        
        //two pointer method to compare forward+return distance sum with capacity and add into result list
        while(i < forwardList.size() && j >= 0) {
            int currentSum = forwardList.get(i).get(1) + returnList.get(j).get(1);

            //if sum is more than MAX_SUM and less than capacity then add ids into result list
            if ( currentSum> max && currentSum <= capacity) {
                max = forwardList.get(i).get(1) + returnList.get(j).get(1);
                result = new LinkedList<List<Integer>>();
                result.add(new ArrayList<Integer>(Arrays.asList(forwardList.get(i).get(0), returnList.get(j).get(0))));
                i++;
            }
            
            //if sum is equal to MAX_SUM then add ids into result
            else if(forwardList.get(i).get(1) + returnList.get(j).get(1) == max)
            {
                // no need to reset result list
                result.add(new ArrayList<Integer>(Arrays.asList(forwardList.get(i).get(0), returnList.get(j).get(0))));
                i++;
                //if sum is greater than capacity then reduce returndistance index.
            } else
                {
                j--;
            }
        }
        return result;
    }


}
