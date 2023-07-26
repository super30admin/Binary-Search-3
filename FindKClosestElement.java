// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

import java.util.ArrayList;
import java.util.List;
import java.util.TreeSet;

import javafx.util.Pair;

class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        TreeSet<Pair<Integer, Integer>> set = new TreeSet<>((a, b) -> {
            if (a.getValue().equals(b.getValue())) {
                return a.getKey() - b.getKey();
            }
            return a.getValue() - b.getValue();
        });

        for (int num : arr) {
            set.add(new Pair<>(num, Math.abs(x - num)));
            if (set.size() > k) {
                set.pollLast();
            }
        }

        List<Integer> res = new ArrayList<>();
        while (!set.isEmpty()) {
            res.add(set.pollLast().getKey());
        }

        return res;
    }
}