function maximalRectangle(matrix: any[][]): number {
    const row = matrix.length;
    const col = matrix[0].length;
    let ans = 0;

    for(let i=0; i<row; i++) {
        for(let j=0; j<col; j++) {
            if(matrix[i][j] !== "0" && Number(matrix[i][j-1]) > 0) {
                matrix[i][j] = Number(matrix[i][j-1]) + 1;
            } else matrix[i][j] = Number(matrix[i][j])
        }
    }

    for(let j = col-1; j >= 0; j--) {
        const indexList: any= [];

        for (let i = 0; i <= row; i++) {
            while (indexList.length > 0 && (i === row || matrix[i][j] < matrix[indexList[indexList.length - 1]][j])) {
            const height = matrix[indexList.pop()][j];
            const width = indexList.length === 0 ? i : i - indexList[indexList.length - 1] - 1;
            ans = Math.max(ans, height * width);
            }
            
            indexList.push(i);
        }
    }


    return ans;
};