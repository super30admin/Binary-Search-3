// There three approaches
// Did this code successfully run on Leetcode : No (Problem not available)
// Any problem you faced while coding this : no

import java.util.ArrayList;
import java.util.List;

// Your code here along with comments explaining your approach
// Approach 1: Brute force
// Time Complexity : O(n*m)
//      n: forward routes size
//      m: backward routes size
// Space Complexity : O(1)
class Problem3S1{

    /**class definition of Pair */
    static class Pair{
        int key;
        int value;

        Pair(int k, int v){
            key = k;
            value = v;
        }

        public int getKey(){
            return key;
        }
        public int getValue(){
            return value;
        }

        @Override
        public String toString() {
            return "[" + key + ", " + value + "]";
        }
    }

    /** Get Optimized Routes*/
    public static List<Pair> getOptimizedUtilize(int maxTravelDist, List<Pair> forwardRouteList, List<Pair> returnRouteList){
        // result
        List<Pair> result = new ArrayList<>();

        // edge case
        if((maxTravelDist != 0 && forwardRouteList != null && returnRouteList != null)
         && (forwardRouteList.size()!= 0 && returnRouteList.size() != 0)){

            // initialize with max value as distance min is zero
            int maxValue = 0;

            // iterate forward
            for(int i=0; i< forwardRouteList.size(); i++){

                // distance 
                int currentDist = forwardRouteList.get(i).getValue();

                //iterate return
                for(int j=0; j< returnRouteList.size(); j++){

                    // add to current dist
                    currentDist += returnRouteList.get(j).getValue();

                    // check distace in range of airplance and check if it is greater than previous max
                    if(currentDist <= maxTravelDist  && maxValue <= currentDist){
                        // if greater, previous elements are to be removed
                        if(currentDist > maxValue)
                            result =  new ArrayList<>();
                        // add to result
                        result.add(new Pair(forwardRouteList.get(i).getKey(),returnRouteList.get(j).getKey()));
                        maxValue = currentDist;
                    }
                    // remove return distance from current distance
                    currentDist -= returnRouteList.get(j).getValue();
                }
            }
        }
        // return result
        return result;
        
    }

    // main function
    public static void main(String[] args) {

        // creating forwardRouteList
        int[][] forwardRouteArray = {{1, 2000}, {2, 4000}, {3, 6000}};
        List<Pair> forwardRouteList  = new ArrayList<>();
        for(int[] element : forwardRouteArray)
            forwardRouteList.add(new Pair(element[0], element[1]));

        // creating returnRouteList
        int[][] returnRouteArray = {{1, 2000}};
        List<Pair> returnRouteList  = new ArrayList<>();
        for(int[] element : returnRouteArray)
            returnRouteList.add(new Pair(element[0], element[1]));

        int maxTravelDist = 7000;
        
        // get result
        List<Pair> result = getOptimizedUtilize(maxTravelDist, forwardRouteList, returnRouteList);

        // print result
        for(Pair current:result)
            System.out.print(current+",");       
    }

}


// Your code here along with comments explaining your approach
// Approach 2: Using Two pointer
// Time Complexity : O(n+m)
//      n: forward routes size
//      m: backward routes size
// Space Complexity : O(1)
class Problem3S2{

    /**class definition of Pair */
    static class Pair{
        int key;
        int value;

        Pair(int k, int v){
            key = k;
            value = v;
        }

        public int getKey(){
            return key;
        }
        public int getValue(){
            return value;
        }

        @Override
        public String toString() {
            return "[" + key + ", " + value + "]";
        }
    }

    /** Get Optimized Routes*/
    //global result
    List<Pair> result;
    public List<Pair> getOptimizedUtilize(int maxTravelDist, List<Pair> forwardRouteList, List<Pair> returnRouteList){
        // result
         result = new ArrayList<>();

        // edge case
        if((maxTravelDist != 0 && forwardRouteList != null && returnRouteList != null)
                && (forwardRouteList.size()!= 0 && returnRouteList.size() != 0)){
                
                // making sure high pointer on Bigger list
                if(returnRouteList.get(0).getValue() > forwardRouteList.get(0).getValue())
                    getOptimizedUtilize(maxTravelDist, forwardRouteList, returnRouteList, false);
                else
                    getOptimizedUtilize(maxTravelDist, returnRouteList, forwardRouteList, true);
        }

        // return result
        return result;
    }

    
    private void getOptimizedUtilize(int maxTravelDist, List<Pair> forwardRouteList, List<Pair> returnRouteList, boolean flag){
        int n1 = forwardRouteList.size();
        int n2 = returnRouteList.size();
        int low = 0;
        int high = n2-1;
        int maxValue = 0;
        while(low < n1 && high >= 0){
            // add to current dist
            int currentDist = forwardRouteList.get(low).getValue();
            currentDist += returnRouteList.get(high).getValue();

            // check distance in range of airplane and check if it is greater than previous max
            if(currentDist <= maxTravelDist  && maxValue <= currentDist){
                // if greater, previous elements are to be removed
                if(currentDist > maxValue)
                    result =  new ArrayList<>();
                // add to result
                if(flag)
                    result.add(new Pair(returnRouteList.get(high).getKey(),forwardRouteList.get(low).getKey()));
                else
                    result.add(new Pair(forwardRouteList.get(low).getKey(),returnRouteList.get(high).getKey()));

                maxValue = currentDist;
                low++; high--;
            }
            else if(currentDist > maxTravelDist){
                high--;
            }else{
                low++;
            }

        }
    }

    // main function
    public static void main(String[] args) {

        // creating forwardRouteList
        //int[][] forwardRouteArray1 = {{1, 2000}, {2, 4000}, {3, 6000}};
        int[][]forwardRouteArray = {{1,2000}, {2, 3500}, {3,4000}};
        List<Pair> forwardRouteList  = new ArrayList<>();
        for(int[] element : forwardRouteArray)
            forwardRouteList.add(new Pair(element[0], element[1]));

        // creating returnRouteList
        //int[][] returnRouteArray1 = {{1, 2000}};
        int[][] returnRouteArray = {{1, 2000}, {2, 3500}, {3,5000}};
        List<Pair> returnRouteList  = new ArrayList<>();
        for(int[] element : returnRouteArray)
            returnRouteList.add(new Pair(element[0], element[1]));

        int maxTravelDist = 7000;

        Problem3S2 p3 = new Problem3S2();
        // get result
        List<Pair> result = p3.getOptimizedUtilize(maxTravelDist, forwardRouteList, returnRouteList);

        // print result
        for(Pair current:result)
            System.out.print(current+",");
    }

}
// Your code here along with comments explaining your approach
// Approach 3: Iterating on 1st and Binary Search on second
// Time Complexity : O(n log m)
//      n: size of lesser list
//      m: size of bigger list
// Space Complexity : O(1)
class Problem3S3{

    /**class definition of Pair */
    static class Pair{
        int key;
        int value;

        Pair(int k, int v){
            key = k;
            value = v;
        }

        public int getKey(){
            return key;
        }
        public int getValue(){
            return value;
        }

        @Override
        public String toString() {
            return "[" + key + ", " + value + "]";
        }
    }

    /** Get Optimized Routes*/
    List<Pair> result;
    public List<Pair> getOptimizedUtilize(int maxTravelDist, List<Pair> forwardRouteList, List<Pair> returnRouteList){
        // result
         result = new ArrayList<>();

        // edge case
        if((maxTravelDist != 0 && forwardRouteList != null && returnRouteList != null)
                && (forwardRouteList.size()!= 0 && returnRouteList.size() != 0)){
            // bigger list is second
            if(returnRouteList.size() > forwardRouteList.size())
                getOptimizedUtilize(maxTravelDist, forwardRouteList, returnRouteList, false);
            else
                getOptimizedUtilize(maxTravelDist, returnRouteList, forwardRouteList, true);

        }
        // return result
        return result;
    }

    private void getOptimizedUtilize(int maxTravelDist, List<Pair> forwardRouteList, List<Pair> returnRouteList, boolean flag){
        int n1 = forwardRouteList.size();
        int maxValue = 0;

        // iterate 1st list
        for(int i=0; i< n1; i++){
            int current = forwardRouteList.get(i).getValue();
            // do closest binary serach on second
            int j  = closestBinarySearch(returnRouteList, maxTravelDist-current);
            // add to current
            current += returnRouteList.get(j).getValue();

            // take max
            if(maxValue <= current){
                // discard if not previous max
                if(current > maxValue)
                    result =  new ArrayList<>();
                // if reverse order
                if(flag)
                    result.add(new Pair(returnRouteList.get(j).getKey(),forwardRouteList.get(i).getKey()));
                else
                    result.add(new Pair(forwardRouteList.get(i).getKey(),returnRouteList.get(j).getKey()));
                maxValue = current;
            }
        }

    }

    /** returns closest value */
    private int closestBinarySearch(List<Pair> list, int target){
        int low = 0;
        int high = list.size()-1;

        // while low and high dont cross
        while(low <= high){
            // find mid
            int mid = low +(high-low)/2;
            // target found
            if(list.get(mid).getValue() == target){
                 return mid;
            // right half
            }else if(list.get(mid).getValue() < target){
                low =  mid+1;
            // left half
            }else{
                high =  mid-1;
            }

        }
        // crossed element is low-1
        return low-1;
    }

    // main function
    public static void main(String[] args) {

        // creating forwardRouteList
        int[][] forwardRouteArray = {{1, 2000}, {2, 4000}, {3, 6000}};
        List<Pair> forwardRouteList  = new ArrayList<>();
        for(int[] element : forwardRouteArray)
            forwardRouteList.add(new Pair(element[0], element[1]));

        // creating returnRouteList
        int[][] returnRouteArray = {{1, 2000}};
        List<Pair> returnRouteList  = new ArrayList<>();
        for(int[] element : returnRouteArray)
            returnRouteList.add(new Pair(element[0], element[1]));

        int maxTravelDist = 7000;
        Problem3S3  p3 =  new Problem3S3();
        
        // get result
        List<Pair> result = p3.getOptimizedUtilize(maxTravelDist, forwardRouteList, returnRouteList);

        // print result
        for(Pair current:result)
            System.out.print(current+",");
        
    }

}