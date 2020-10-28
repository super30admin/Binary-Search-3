/*Time Complexity: O(n*k)
Space Complexity: O(n)*/

class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {

        LinkedList<Integer> list = new LinkedList<>();
        TreeMap<Integer, LinkedList<Integer>> map = new TreeMap<>();
        List<Integer> result = new ArrayList<>();

        for(int a: arr)
        {
            int abs = Math.abs(a-x);
            if(!map.containsKey(abs))
            {
                map.put(abs, new LinkedList<>());
            }
            map.get(abs).add(a);
        }

        for(Map.Entry<Integer,LinkedList<Integer>> entry: map.entrySet())
        {
            for(int i:entry.getValue())
            {
                result.add(i);
                if(result.size() == k)
                {
                    break;
                }
            }

            if(result.size() == k)
            {
                break;
            }
        }

        Collections.sort(result);
        return result;

    }
}
