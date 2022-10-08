/**
 * @param {number[][]} matrix
 * @return {void} Do not return anything, modify matrix in-place instead.
 */
 var setZeroes = function(matrix) {
    const colIndex = new Set();
    
    const m = matrix.length;
    const n = matrix[0].length;
    
    matrix = matrix.map((arr) => {
        console.log(arr)
        if(hasZero(arr)) {
            const zeroColIndexs = getZeroIndexArray(arr);
            zeroColIndexs.forEach((index) => colIndex.add(index))
            for(let i=0; i<n; i++)
                arr[i] = 0;
        }
        return arr;
    })
    
    for(let i=0; i<m; i++) {
        for(index of colIndex) matrix[i][index] = 0;
    }
};
    
const hasZero = (arr) => arr.includes(0);
const getZeroIndexArray = (arr) =>  arr.reduce((acc, cur, idx) => {
        if(cur===0) acc.push(idx);
        return acc
    },[])
	