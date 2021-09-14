using System;
using System.Collections.Generic;
using System.Text;

namespace Binary_Search
{
    class FindKClosestElementsLC
    {
        public List<int> FindClosestElements(int[] arr, int k, int x)
        {
            List<int> result = new List<int>();
            if (arr == null || arr.Length == 0)
            {
                return result;
            }
            int left = 0, right = arr.Length - 1;
            while (right - left + 1 > k)
            {
                int disLeft = x - arr[left];
                int disRight = arr[right] - x;
                if (disLeft > disRight)
                {
                    left++;
                }
                else
                {
                    right--;
                }
            }
            for (int i = left; i <= right; i++)
            {
                result.Add(arr[i]);
            }
            return result;
        }
        //TC: O(logn)
        //SC: O(1)
        public List<int> FindClosestElementsModBS(int[] arr, int k, int x)
        {
            List<int> result = new List<int>();
            if (arr == null || arr.Length == 0)
            {
                return result;
            }
            int low = 0, high = arr.Length - k;
            while (low < high)
            {
                int mid = low + (high - low) / 2; // prevent integer overflow
                int distL = x - arr[mid];
                int distH = arr[mid + k] - x;
                if (distL > distH)
                {
                    low = mid + 1;
                }
                else
                {
                    high = mid;
                }
            }
            for (int i = low; i < low + k; i++)
            {
                result.Add(arr[i]);
            }
            return result;
        }
    }
}
