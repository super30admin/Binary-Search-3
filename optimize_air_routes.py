"""
Leetcode: https://leetcode.com/discuss/interview-question/373202
Approach:
    1. Sort the smaller array and iterate through the bigger array.
    2. For each element in forward try to find the index with closes value lesser than
        the complement with target in backward array.
    3. If the sum of forward value and its complement in backward is higher than
        current max seen so far then result array needs to be discarded and updated
        with current id values. If its the same then just append the current id indexes

Time Complexity: O((n+m) log n) where n is smaller than m (backward)
Space Complexity: O(1)

Did this code successfully run on Leetcode : NA
Any problem you faced while coding this : No
"""


class RouteInfo:
    def __init__(self, id, value):
        self.id = id
        self.value = value

    def __lt__(self, other):
        return self.value < other.value

    def __gt__(self, other):
        return self.value > other.value


class OptimizedRoutes:
    def __binary_search(self, nums, least_closest):
        if not nums:
            return -1
        low = 0
        high = len(nums) - 1
        while low <= high:
            mid = low + (high - low) // 2
            if nums[mid].value == least_closest:
                return mid
            elif nums[mid].value > least_closest:
                high = mid - 1
            else:
                low = mid + 1

        return high  # high will be the nearest closest if we come out of while loop

    def optimizeRoutes(self, forward, backward, target):
        result = []
        if len(forward) < len(backward):
            return self.optimizeRoutes(backward, forward, target)
        if forward is None or len(forward) == 0:
            return 0
        backward.sort()
        max_val = 0
        for i in range(len(forward)):
            complement = target - forward[i].value
            index = self.__binary_search(backward, complement)
            if index != -1:
                curr_sum = forward[i].value + backward[index].value
                if curr_sum >= max_val:
                    if curr_sum > max_val: result = []
                    result.append([forward[i].id, backward[index].id])
        return result


def main():
    optRoutes = OptimizedRoutes()

    #   test case 1
    forward = [RouteInfo(1, 4000), RouteInfo(2, 2000), RouteInfo(3, 6000)]
    backward = [RouteInfo(1, 4000), RouteInfo(2, 2500), RouteInfo(3, 2800)]
    target = 8500

    result = optRoutes.optimizeRoutes(forward, backward, target)
    print(result)  # [[3, 2]]


if __name__ == '__main__':
    main()