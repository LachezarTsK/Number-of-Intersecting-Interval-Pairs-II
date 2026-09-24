
package main
import "slices"

func countIntersectingIntervals(intervals [][]int) int64 {
    slices.SortFunc(intervals, func(x []int, y []int) int { return x[0] - y[0] })
    totalIntersectingIntervals := int64(0)
    for i := 0; i < len(intervals) - 1; i++ {
        index := searchUpperBoundInsertionIndex(intervals, i+1, intervals[i][1])
        totalIntersectingIntervals += int64(index - i - 1)
    }
    return totalIntersectingIntervals
}

func searchUpperBoundInsertionIndex(intervals [][]int, startIndex int, target int) int {
    left := startIndex
    right := len(intervals) - 1

    for left <= right {
        middle := left + (right - left) / 2
        if intervals[middle][0] <= target {
            left = middle + 1
        } else {
            right = middle - 1
        }
    }
    return left
}
