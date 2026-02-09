//
//  FindKClosestElements.swift
//  DSA-Practice
//
//  Created by Paridhi Malviya on 2/6/26.
//

class KClosestElements {
    
    init() {
        
    }
    
    //O(n-k) + O(k) = O(n) 2 - pointer solution
    //space - O(1)
    func findKClosestElements(arr: [Int], k: Int, x: Int) -> [Int] {
        let n = arr.count
        var result = [Int]()
        var low = 0
        var high = n - 1
        while (high - low + 1 > k) {
            let distLow = abs(arr[low] - x)
            let distHigh = abs(arr[high] - x)
            if (distHigh >= distLow) {
                high -= 1
            } else {
                low += 1
            }
        }
        
        for i in low...high {
            result.append(arr[i])
        }
        return result
    }
    
    //binary search solution
    /*
     log n + O(k) -> If k is really big then going towards linear solution. Find nearest element. Take left and right pointer. Keep on decreasing the left pointer, keep on icreasing the right pointer, until k elements remains
     
     Better approach - somehow find the range of k elements. i. the range of left and right of 4 closest elements.
     Binary serahc for range of k elements. or find the starting idx of range.
     high cant be n - 1 because we need to give k elements after the start point. The mstarting index of range should lie between 0 to (n - k)
     
     When uses index and length together. always do index + length - 1. It should be the last index. Here, intentionally 1 extra index is taken. If the left and index has same distance then take up the smaller element. In order to fix it, taking an extra element.
     
     check if mid is the correct starting index of the range. high will be mid + k. calculate distance from mid and distance form high
     If the distance of end is greater than distance of start, then move high to mid. Now I have more wightange towards the left of the x than right half.
     Ideally we should have x in the middle. To have uniform scenario.
     time complexity - log(n - k)
     space complexity - O(1)
     */
    /*
     if we take absolute difference then there can be issues -
     
     */
    func findKClosestElementsUsingBinarySearch(arr: [Int], k: Int, x: Int) -> [Int] {
        let n = arr.count
        var result = [Int]()
        var low = 0
        var high = n - k
        while (low < high) {
            let mid = low + (high - low)/2
            let disStart = x - arr[mid]
            let disEnd = arr[mid + k] - x
            if (disEnd >= disStart) {
                high = mid
            } else {
                low = mid + 1
            }
        }
        for i in low..<(low + k) {
            result.append(arr[i])
        }
        return result
    }
}



class FindKClosestElements {
    //n logn , n log k
    class PriorityQueue<T> {
        var elements: [T] = []

        var sort: (T, T) -> Bool
        init(sort: @escaping (T, T) -> Bool) {
            self.sort = sort
        }

        var isEmpty: Bool {
            return elements.isEmpty
        }

        var count: Int {
            return elements.count
        }

        var peek: T? {
            return elements.first
        }

        func enqueue(_ element: T) {
            elements.append(element)
            heapifyUp(from: elements.count - 1)
        }

        func heapifyUp(from index: Int) {
            var childIndex = index
            var parentIndex = (childIndex - 1) / 2

            while (childIndex > 0 && sort(elements[childIndex], elements[parentIndex])) {
                elements.swapAt(childIndex, parentIndex)
                childIndex = parentIndex
                parentIndex = (childIndex - 1) / 2
            }
        }

        func dequeue() -> T? {
            if (elements.isEmpty) {
                return nil
            }
            elements.swapAt(0, elements.count - 1)
            let removedOne = elements.removeLast()
            heapifyDown(from: 0)
            return removedOne
        }

        func heapifyDown(from index: Int) {
            var parentIndex = index
            var leftChildIndex = 2 * parentIndex + 1

            while (leftChildIndex < count) {
                var childIndex = leftChildIndex
                var rightChidlIndex = leftChildIndex + 1

                if (rightChidlIndex < count && sort(elements[rightChidlIndex], elements[leftChildIndex])) {
                    childIndex = rightChidlIndex
                }

                if (sort(elements[parentIndex], elements[childIndex])) {
                    break
                }

                elements.swapAt(childIndex, parentIndex)
                parentIndex = childIndex
                leftChildIndex = parentIndex * 2 + 1
            }
        }
    }

        //n logn , n log k
    func findClosestElementsUsingPriorityqueue(_ arr: [Int], _ k: Int, _ x: Int) -> [Int] {
        var pq = PriorityQueue<Int>(sort: {(a, b) in
            let distA = abs(a - x)
            let distB = abs(b - x)
            if (distA != distB) {
                return distA > distB
            } else {
                return a > b
            }
        })

        for num in arr {
            pq.enqueue(num)
            if (pq.count > k) {
                let _ = pq.dequeue()
            }
        }

        var result = [Int]()
        while (!pq.isEmpty) {
            let r = pq.dequeue()!
            result.append(r)
        }
        //sort the result
        result.sort()
        return result
    }
}
