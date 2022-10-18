function longestCommonSubsequence(text1: string, text2: string): number {
    const aLen = text1.length+1;
    const bLen = text2.length+1;
    const a = text1.split('');
    const b = text2.split('');

    const arr = new Array(aLen).fill(0).map(() => new Array(bLen).fill(0));
    for(let i=1; i<aLen; i++) {
        for(let j=1; j<bLen; j++) {
            if(a[i-1] === b[j-1])
                arr[i][j] = arr[i-1][j-1] + 1;
            else
                arr[i][j] = arr[i-1][j] > arr[i][j-1] ? arr[i-1][j] : arr[i][j-1];
        }
    }

    return arr[aLen-1][bLen-1]
};
