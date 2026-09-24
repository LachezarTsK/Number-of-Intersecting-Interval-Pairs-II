
function countIntersectingIntervals(intervals: number[][]): number {
    intervals.sort((x, y) => x[0] - y[0]);
    let totalIntersectingIntervals = 0;
    for (let i = 0; i < intervals.length - 1; ++i) {
        let index = searchUpperBoundInsertionIndex(intervals, i + 1, intervals[i][1]);
        totalIntersectingIntervals += index - i - 1;
    }
    return totalIntersectingIntervals;
};

function searchUpperBoundInsertionIndex(intervals: number[][], startIndex: number, target: number): number {
    let left = startIndex;
    let right = intervals.length - 1;

    while (left <= right) {
        const middle = left + Math.floor((right - left) / 2);
        if (intervals[middle][0] <= target) {
            left = middle + 1;
        } else {
            right = middle - 1;
        }
    }
    return left;
}
