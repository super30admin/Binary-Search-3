using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

//https://leetcode.com/discuss/interview-question/373202
//https://leetcode.com/discuss/interview-question/1025705/Amazon-or-OA-or-Prime-Air-time/824897

// TC => O(mlogn + nlogn)
// SC => O(1)
namespace Solution
{
    internal class OptimalUtilizationClass
    {
        public IList<int[]> Utilize(int[][] forwardRouteList, int[][] returnRouteList, int maxTravelDist)
        {
            IList<int[]> result = new List<int[]>();

            if (forwardRouteList == null || returnRouteList == null)
            {
                return result;
            }

            Array.Sort(forwardRouteList, (a, b) => a[1].CompareTo(b[1]));
            Array.Sort(returnRouteList, (a, b) => a[1].CompareTo(b[1]));

            int forwardIndex = 0;
            int returnIndex = returnRouteList.Length - 1;
            int max = Int32.MinValue;

            while (forwardIndex < forwardRouteList.Length && returnIndex >= 0)
            {
                int currentTravelDist = forwardRouteList[forwardIndex][1] + returnRouteList[returnIndex][1];
                if (currentTravelDist <= maxTravelDist)
                {
                    if (currentTravelDist < max)
                    {
                        forwardIndex++;
                        continue;
                    }
                    if (currentTravelDist > max)
                    {
                        max = currentTravelDist;
                        result.Clear();
                    }
                    result.Add(new int[] { forwardRouteList[forwardIndex][0], returnRouteList[returnIndex][0] });
                    forwardIndex++;
                }
                else
                {
                    returnIndex--;
                }
            }

            return result;

        }
    }
}
