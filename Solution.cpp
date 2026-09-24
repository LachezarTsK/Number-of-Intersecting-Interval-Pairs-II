
#include <span>
#include <ranges>
#include <vector>
using namespace std;

class Solution {

public:
    long long countIntersectingIntervals(vector<vector<int>>& intervals) {
        ranges::sort(intervals, [](const vector<int>& x, const vector<int>& y) {return x[0] < y[0]; });
        long long totalIntersectingIntervals = 0;
        for (int i = 0; i < intervals.size() - 1; ++i) {
            int index = searchUpperBoundInsertionIndex(intervals, i + 1, intervals[i][1]);
            totalIntersectingIntervals += index - i - 1;
        }
        return totalIntersectingIntervals;
    }

private:
    static int searchUpperBoundInsertionIndex(span<const vector<int>> intervals, int startIndex, int target) {
        int left = startIndex;
        int right = intervals.size() - 1;

        while (left <= right) {
            int middle = left + (right - left) / 2;
            if (intervals[middle][0] <= target) {
                left = middle + 1;
            }
            else {
                right = middle - 1;
            }
        }
        return left;
    }
};
