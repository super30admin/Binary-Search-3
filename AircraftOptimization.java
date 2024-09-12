public static List<List<Integer>> getIdPairsForOptimal(List<List<Integer>> forwardList,List<List<Integer>> backwardList, int maxDistance) {
    List<List<Integer>> result = new LinkedList<>();

    List<List<Integer>> temp = new ArrayList<>();
    int max = Integer.MIN_VALUE;

    for (int i = 0; i < forwardList.size(); i++) {
        for (int j = 0; j < backwardList.size(); j++) {
            int cmax = forwardList.get(i).get(1) + backwardList.get(j).get(1);
            if (cmax <= maxDistance) {
                if (cmax > max) {
                    max = cmax;
                    result = new ArrayList<>();
                    result.add(Arrays.asList(forwardList.get(i).get(0), backwardList.get(j).get(0)));
                } else if (cmax == max) {
                    result.add(Arrays.asList(forwardList.get(i).get(0), backwardList.get(j).get(0)));
                }

            }
        }

    }
return result;
}