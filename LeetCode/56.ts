function merge(intervals: number[][]): number[][] {
    intervals.sort((a,b) => a[0] - b[0]);
    const answer = [intervals[0]];

    for(let i=1; i<intervals.length; i++) {
        if(answer[answer.length-1][1] >= intervals[i][0])
            answer[answer.length-1][1] = Math.max(answer[answer.length-1][1], intervals[i][1]);
        else answer.push(intervals[i]);
    }

    return answer;
};
