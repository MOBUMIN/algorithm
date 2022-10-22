/**
 * @param {number[][]} intervals
 * @param {number[]} newInterval
 * @return {number[][]}
 */
 var insert = function(intervals, newInterval) {
    // 일단 interval을 output 형태로 다 합치고 new Interval로 또 합치자
    let lastNum;
    if(!intervals[intervals.length-1]) lastNum = newInterval[1];
    else lastNum = intervals[intervals.length-1][1] > newInterval[1] ? intervals[intervals.length-1][1] : newInterval[1];
    const 연결배열 = new Array(lastNum+1).fill(0);
    const 연결배열끝 = new Array(lastNum+1).fill(0);

    // fill
    for(let i=0; i<intervals.length; i++) {
        const s = intervals[i][0];
        const e = intervals[i][1];
        
        for(let j=s; j<e; j++) {
            연결배열[j] = 1;
            연결배열끝[j] = 0;
        }

        if(!연결배열[e]) 연결배열끝[e] = 1;
    }

    // insert
    const newStart = newInterval[0];
    const newEnd = newInterval[1];
    for(let i=newStart; i<newEnd; i++) {
        연결배열[i] = 1;
        연결배열끝[i] = 0;
    }
    if(!연결배열[newEnd]) 연결배열끝[newEnd] = 1;

    // extract
    const answer = [];
    let saveStart = -1;
    let saveEnd = -1;
    for(let i=0; i<=lastNum; i++) {
        if(!연결배열[i] && !연결배열끝[i]) continue;
        if(연결배열[i]) {
            if(saveStart === -1) saveStart = i;
            saveEnd = i;
        } 
        else {
            if(saveStart === -1) {
                saveStart = i;
                saveEnd = i-1;
            }
            answer.push([saveStart, saveEnd+1])
            saveStart = -1;
            saveEnd = -1;
        }
    }

    return answer;
};
