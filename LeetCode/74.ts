function searchMatrix(matrix: number[][], target: number): boolean {
    const row = matrix.length;
    const col = matrix[0].length;

    let rMiddle = 0, cMiddle = 0;
    let rStart = 0;
    let rEnd = row - 1;
    let cStart = 0;
    let cEnd = col - 1;

    while(rStart <= rEnd) {
        if(cStart > cEnd) {
            if(cStart === 0) rEnd = rMiddle - 1;
            else if (cStart === col) rStart = rMiddle + 1;
            else break;

            cStart = 0;
            cEnd = col - 1;
            continue; 
        }

        rMiddle = Math.floor((rStart + rEnd) / 2);
        cMiddle = Math.floor((cStart + cEnd) / 2);

        if(matrix[rMiddle][cMiddle] === target) return true;
        else if(matrix[rMiddle][cMiddle] < target) {
            cStart = cMiddle + 1;
        } else {
            cEnd = cMiddle - 1;
        }
    }

    return false;
};
