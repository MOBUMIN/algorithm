function spiralOrder(matrix: number[][]): number[] {
    const ans = [];
    const m = matrix.length;
    const n = matrix[0].length;
    const visited = new Array(m).fill(false).map(() => new Array(n).fill(false));
    let i=0;
    let j=0;
    const direction = ['right', 'down', 'left', 'top'];
    let directionIndex = 0;

    if(m===1) return matrix[0];
    if(n===1) return matrix.map(arr => arr[0])

    while(true) {
        if(visited[i][j]) {
            break;
        }
        visited[i][j] = true;
        ans.push(matrix[i][j]);
        switch(direction[directionIndex]) {
            case 'right':
                if(j+1 === n || visited[i][j+1]) {
                    directionIndex = updateDirection(directionIndex);
                    i = i+1;
                }
                else j = j+1;
            break;
            case 'down':
                if(i+1 === m || visited[i+1][j]) {
                    directionIndex = updateDirection(directionIndex);
                    j = j-1;
                }
                else i = i+1;
            break;
            case 'left':
                 if(j-1 < 0 || visited[i][j-1]) {
                    directionIndex = updateDirection(directionIndex);
                    i = i - 1;
                }
                else j = j-1;
            break;
            case 'top':
             if(i-1 < 0 || visited[i-1][j]) {
                    directionIndex = updateDirection(directionIndex);
                    j = j + 1;
                }
                else i = i-1;
            break;
        }
    }

    return ans;
};

function updateDirection(directionIndex: number): number {
    if(directionIndex < 3) return directionIndex+1;
    return 0;
}
