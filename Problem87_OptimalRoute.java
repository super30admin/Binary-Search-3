
public static List<List<Integer>> getIdPairsForOptimal(List<List<Integer>> fl, List<List<Integer>> bl, int maxDistance) {
        List<List<Integer>> result = new LinkedList<List<Integer>>();
        fl = fl.stream().sorted((x1, x2) -> Integer.compare(x2.get(1), x1.get(1))).collect(Collectors.toList());
        bl = bl.stream().sorted((x1, x2) -> Integer.compare(x1.get(1), x2.get(1))).collect(Collectors.toList());
        int maxDist = maxDistance;
        while (true) {
            for (List<Integer> l : fl) {
                for (List<Integer> b : bl) {
                    int forward = l.get(1);
                    int backward = b.get(1);
                    int tot = (forward + backward);
                    if (tot > maxDist) {
                        break;
                    }
                    if (tot == maxDist) {
                        // print the pair of Id and optimum distance
                        result.add(Arrays.asList(l.get(0), b.get(0), maxDist));
                        break;
                    }

                }
            }
            if (result.size() > 0) {
                break;
            }
            maxDist--;
        }
        return result;
}