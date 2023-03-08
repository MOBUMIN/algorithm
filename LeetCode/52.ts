function totalNQueens(n: number): number {
    let answer = 0;
    const dfs = (board, row) => {
        if(row === n) answer++;
        else {
            for(let i=0; i<n; i++) {
                board[row] = i;
                if(isGoodPos(board, row))
                    dfs(board, row+1);
            }
        }
    }

    const isGoodPos = (board, row): boolean => {
        // 내가 현재 놓은 친구만 검사
        for(let i=0; i<row; i++) {
            if(board[row] === board[i]) return false; // 같은 열
            if(Math.abs(board[row] - board[i]) === row - i) return false; // 대각선
        }
        return true;
    }

    for(let i=0; i<n; i++) {
        const board = new Array(n).fill(-1); // [첫번째행 퀸위치, 두번째행 퀸위치, ... ]
        board[0] = i;
        dfs(board, 1);
    }

    return answer;
};
