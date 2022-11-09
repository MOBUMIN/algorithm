function exist(board: string[][], word: string): boolean {
    let result;
    const m = board.length;
    const n = board[0].length;

    const visited = new Array(m).fill(false).map(() => new Array(n).fill(false));
    for(let i=0; i<m; i++) {
        for(let j=0; j<n; j++) {
            result = false;
            if(board[i][j] === word[0]) {
                visited[i][j] = true;
                result = dfs(word.slice(1), board, i, j, visited);
                visited[i][j] = false;
            }
            if(result) return true;
        }
    }
    return false;
};

const dfs = (word: string, board: string[][], i:number, j: number, visited: boolean[][]): boolean => {
    let result;
    if(word === '') return true;
    // 위
    if(i - 1 >= 0 && !visited[i-1][j] && board[i-1][j] === word[0]) {
        visited[i-1][j] = true;
        result = dfs(word.slice(1), board, i-1, j, visited);
        visited[i-1][j] = false;
    }
    if(result) return result;

    // 오른쪽
    if(j + 1 <board[0].length && !visited[i][j+1] && board[i][j+1] === word[0]) {
        visited[i][j+1] = true;
        result = dfs(word.slice(1), board, i, j+1, visited);
        visited[i][j+1] = false;
    }
    if(result) return result;

    // 아래
    if(i + 1 < board.length && !visited[i+1][j] && board[i+1][j] === word[0]) {
        visited[i+1][j] = true;
        result = dfs(word.slice(1), board, i+1, j, visited);
        visited[i+1][j] = false;
    }
    if(result) return result;

    // 왼쪽
    if(j - 1 >= 0 && !visited[i][j-1] && board[i][j-1] === word[0]) {
        visited[i][j-1] = true;
        result = dfs(word.slice(1), board, i, j-1, visited);
        visited[i][j-1] = false;
    }
    if(result) return result;

    return false;
}
