class KClosestElements {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        int index = -1;

        for (int i=0; i<arr.length; i++) {
            if (index == arr[x]) {
                index = i;
            }
        }

        List<Integer> list = new ArrayList<>();
        int count = k / 2;

        for (int i=0; i<count; i++) {
            list.add(arr[count - i])
        }

        return list;
    }
}