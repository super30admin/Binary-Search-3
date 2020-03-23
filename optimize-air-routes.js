// Time Complexity : O((M+N)log(Min(m, n)))
// Space Complexity : O(1) or O(M + N) depending on if you count the result array as part of the space
// Did this code successfully run on Leetcode : This question isn't on LeetCode
// Any problem you faced while coding this : Yes, This is messy code, but it takes care of choosing the minimum of m and n to sort

var optimalTravelDistance = function (forwardRouteList, backwardRouteList, maxTravelDist) {
  if (!forwardRouteList || !forwardRouteList.length ||
      !backwardRouteList || !backwardRouteList.length) return [[]];
  
  // Determine which is shorter, and sort it based on the gasoline usage
  let sortedList, unsortedList;
  if (forwardRouteList.length < backwardRouteList.length) {
    sortedList = forwardRouteList.sort((a, b) => {return a[1] - b[1]});
    unsortedList = backwardRouteList;
  } else {
    sortedList = backwardRouteList.sort((a, b) => {return a[1] - b[1]});
    unsortedList = forwardRouteList;
  }

  // Loop through the unsortedList and find the maximum allotted paths
  let max = -Infinity;
  let result = [];

  for (const route of unsortedList) {
    let compliment = maxTravelDist - route[1];
    // Perform binary search for all compliments
    let low = 0,
        high = sortedList.length - 1;

    while (low <= high) {
      let mid = Math.floor((low + high) / 2);

      if (sortedList[mid][1] > max && <= compliment) {
        // Is this the exact compliment AND are we updating the max?
        if (sortedList[mid][1] == compliment && max < maxTravelDist) {
          max = maxTravelDist;

          result = [];
          // Determine which to push first
          if (unsortedList == forwardRouteList) result.push([route[0], sortedList[mid][0]]);
          else result.push([sortedList[mid][0], route[0]]);

        // Is this the exact compliment?
        } else if (sortedList[mid][1] == compliment) {
          // Determine which to push first
          if (unsortedList == forwardRouteList) result.push([route[0], sortedList[mid][0]]);
          else result.push([sortedList[mid][0], route[0]]);

        // This isn't the exact compliment, but
        // Is this greater than the old max?
        } else if (sortedList[mid][1] + route[1] > max) {
          max = sortedList[mid][1] + route[1];
          // Empty the array
          result = [];

          // Determine which to push first
          if (unsortedList == forwardRouteList) result.push([route[0], sortedList[mid][0]]);
          else result.push([sortedList[mid][0], route[0]]);
        
        // Or is this the same as the old max?
        } else if (sortedList[mid][1] + route[1] == max) {
          // Determine which to push first
          if (unsortedList == forwardRouteList) result.push([route[0], sortedList[mid][0]]);
          else result.push([sortedList[mid][0], route[0]]);
        }
        low = mid + 1;
      } else {
        high = mid - 1;
      }
    }
  }

  return result;
}
