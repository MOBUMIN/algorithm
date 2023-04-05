function minPathSum(grid: number[][]): number {
    const m = grid.length;
    const n = grid[0].length;
    const dp = new Array(m).fill(0);
    for(let i=0; i<m; i++) dp[i] = new Array(n).fill(0);

    for(let i=0; i<m; i++) {
        for(let j=0; j<n; j++) {
            if(i===0 && j===0) dp[i][j] = grid[i][j]
            else dp[i][j] = Math.min(dp[i-1]?.[j] ?? 4000000, dp[i][j-1] ?? 4000000) + grid[i][j]
        }
    }

    return dp[m-1][n-1];
};
