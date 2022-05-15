using System;
using System.Collections.Generic;
using System.Text;

namespace ConsoleApp1
{
    public class FindKClosetElement
    {
        //Two pointer solution
        /*
         * T.C: O(N-k)+O(K) where n is number of element in arr and k is no of element needs to return
         * S.C: O(1) since no extra sapce used.
         */
        public IList<int> FindClosestElements(int[] arr, int k, int x)
        {
            int low = 0;
            int high = arr.Length - 1;
            List<int> result = new List<int>();

            while (high - low + 1 > k)
            {
                int reslow = x - arr[low];
                int reshigh = arr[high] - x;

                if (reslow > reshigh)
                {
                    low++;
                }
                else
                {
                    high--;
                }
            }

            for (int i = low; i <= high; i++)
            {
                result.Add(arr[i]);
            }

            return result;
        }

        //Binary Search solution
        //T.C: O(long(n-k) where n is number of element and k is range of elements to return
        //S.C:O(1) constant since we are not using any extra space
        public IList<int> FindClosestElements(int[] arr, int k, int x)
        {
            int low = 0;
            int high = arr.Length - 1;
            List<int> result = new List<int>();

            while (low <= high)
            {
                int mid = low + (high - low) / 2;
                int distLow = x - arr[mid];
                int distHigh = arr[mid + k] - x;
                if (distLow > distHigh)
                {
                    low = mid + 1;
                }
                else
                {
                    high = mid;
                }
            }

            for (int i = low; i <= high; i++)
            {
                result.Add(arr[i]);
            }

            return result;

        }
    }
}
