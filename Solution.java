
import java.util.Arrays;

public class Solution {

    public long countIntersectingIntervals(int[][] intervals) {
        Arrays.sort(intervals, (x, y) -> x[0] - y[0]);
        long totalIntersectingIntervals = 0;
        for (int i = 0; i < intervals.length - 1; ++i) {
            int index = searchUpperBoundInsertionIndex(intervals, i + 1, intervals[i][1]);
            totalIntersectingIntervals += index - i - 1;
        }
        return totalIntersectingIntervals;
    }

    private static int searchUpperBoundInsertionIndex(int[][] intervals, int startIndex, int target) {
        int left = startIndex;
        int right = intervals.length - 1;

        while (left <= right) {
            int middle = left + (right - left) / 2;
            if (intervals[middle][0] <= target) {
                left = middle + 1;
            } else {
                right = middle - 1;
            }
        }
        return left;
    }
}
