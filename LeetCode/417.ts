function pacificAtlantic(heights: number[][]): number[][] {
    // pacific 은 x=0, y=0 인 곳 어딘가로 흐를 수 있으면 가능
    // atlantic은 x=length-1, y=length-1인 곳 어딘가로 흐를 수 있으면 가능

    const result = [];
    const m = heights.length;
    const n = heights[0].length;

    let canPacific, canAtlantic;

    const visited = new Array(m).fill(false).map(() => new Array(n).fill(false));
    for(let i=0; i<m; i++) {
        for(let j=0; j<n; j++) {
            canPacific = false;
            canAtlantic = false;

            visited[i][j] = true;
            canPacific = dfs(visited, heights, i, j, 0, 0);
            canAtlantic = dfs(visited, heights, i, j, m-1, n-1);
            visited[i][j] = false;

            if(canAtlantic && canPacific) result.push([i, j])
        }
    }
    return result;
};
const dfs = (visited: boolean[][], heights: number[][], i: number, j:number, x:number, y:number) => {
    if(i === x || j === y) return true;
    let result;
    // 위
    if(i - 1 >= 0 && !visited[i-1][j] && heights[i-1][j] <= heights[i][j]) {
        visited[i-1][j] = true;
        result = dfs(visited, heights, i-1, j, x, y);
        visited[i-1][j] = false;
    }
    if(result) return result;

    // 오른쪽
    if(j + 1 <heights[0].length && !visited[i][j+1] && heights[i][j+1] <= heights[i][j]) {
        visited[i][j+1] = true;
        result = dfs(visited, heights, i, j+1, x, y);
        visited[i][j+1] = false;
    }
    if(result) return result;

    // 아래
    if(i + 1 < heights.length && !visited[i+1][j] && heights[i+1][j] <= heights[i][j]) {
        visited[i+1][j] = true;
        result = dfs(visited, heights, i+1, j, x, y);
        visited[i+1][j] = false;
    }
    if(result) return result;

    // 왼쪽
    if(j - 1 >= 0 && !visited[i][j-1] && heights[i][j-1] <= heights[i][j]) {
        visited[i][j-1] = true;
        result = dfs(visited, heights, i, j-1, x, y);
        visited[i][j-1] = false;
    }
    if(result) return result;

    return false;
}
