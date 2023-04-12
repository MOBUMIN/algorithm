function uniquePathsWithObstacles(obstacleGrid: number[][]): number {
    const m = obstacleGrid.length;
    const n = obstacleGrid[0].length;
    const OBSTACLE = -1;

    if(obstacleGrid[m-1][n-1] === 1) return 0; // 도착점이  obstacle
    
    let temp = 1;
    for(let i=0; i<m; i++) {
        if(obstacleGrid[i][0] === 1) {
            obstacleGrid[i][0] = OBSTACLE;
            temp = OBSTACLE;
        }
        obstacleGrid[i][0] = temp;
    }

    if(obstacleGrid[0][0] !== OBSTACLE) temp = 1;
    for(let i=1; i<n; i++) {
        if(obstacleGrid[0][i] === 1) {
            obstacleGrid[0][i] = OBSTACLE;
            temp = OBSTACLE;
        }
        obstacleGrid[0][i] = temp;
    }

    for(let i=1; i<m; i++) {
        for(let j=1; j<n; j++) {
            const top = obstacleGrid[i-1][j] === OBSTACLE ? 0 : obstacleGrid[i-1][j];
            const left = obstacleGrid[i][j-1] === OBSTACLE ? 0 : obstacleGrid[i][j-1];
            obstacleGrid[i][j] = obstacleGrid[i][j] === 1 ? OBSTACLE : top + left;
        }
    }

    return obstacleGrid[m-1][n-1] === OBSTACLE ? 0 : obstacleGrid[m-1][n-1];
}
