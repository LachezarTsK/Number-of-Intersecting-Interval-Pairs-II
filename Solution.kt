
class Solution {

    fun countIntersectingIntervals(intervals: Array<IntArray>): Long {
        intervals.sortWith() { x, y -> x[0] - y[0] }
        var totalIntersectingIntervals: Long = 0
        for (i in 0..<intervals.size - 1) {
            val index = searchUpperBoundInsertionIndex(intervals, i + 1, intervals[i][1])
            totalIntersectingIntervals += index - i - 1
        }
        return totalIntersectingIntervals
    }

    private fun searchUpperBoundInsertionIndex(intervals: Array<IntArray>, startIndex: Int, target: Int): Int {
        var left = startIndex
        var right = intervals.size - 1

        while (left <= right) {
            val middle = left + (right - left) / 2
            if (intervals[middle][0] <= target) {
                left = middle + 1
            } else {
                right = middle - 1
            }
        }
        return left
    }
}
