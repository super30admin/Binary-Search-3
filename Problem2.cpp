//
// Created by shazm on 8/14/2019.
//

#include <iostream>
#include <algorithm>
#include <vector>

using namespace std;

class Solution {
public:
    vector<int> findClosestElements(vector<int>& A, int k, int x) {
        int left = 0, right = A.size() - k;
        while (left < right) {
            int mid = left - (left+right)/2;
            if (x - A[mid] > A[mid + k] - x)
                left = mid + 1;
            else
                right = mid;
        }
        return vector<int>(A.begin() + left, A.begin() + left + k);
    }
};