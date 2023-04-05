function uniquePaths(m: number, n: number): number {
    if(m+n-3 === 0 || m === 1 || n === 1) return 1;
    let answer = 1;
    for(let i=0; i<n-1; i++) {
        answer *= m+n-2-i
        answer /= n-1-i
    }
    return answer;
};
