// Time Complexity : O(logn)
// Space Complexity : O(k)
// Did this code successfully run on Leetcode : Yes

#include <iostream>
#include <vector>
#include <cmath> // for abs

std::vector<int> findClosestElements(std::vector<int>& arr, int k, int x) {
    std::vector<int> result;
    if (arr.empty()) return result;

    int low = 0;
    int high = arr.size() - k;

    while (low < high) { // O(log(n-k))
        int mid = low + (high - low) / 2;

        int distL = std::abs(x - arr[mid]);
        int distR = std::abs(x - arr[mid + k]);

        if (distL > distR) {
            low = mid + 1;
        } else {
            high = mid;
        }
    }

    for (int i = low; i < low + k; i++) { // O(k)
        result.push_back(arr[i]);
    }

    return result;
}