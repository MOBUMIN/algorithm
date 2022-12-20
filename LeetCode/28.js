/**
 * @param {string} haystack
 * @param {string} needle
 * @return {number}
 */
 var strStr = function(haystack, needle) {
    const hLen = haystack.length;
    const nLen = needle.length;
    const LCS = new Array(hLen+1).fill(0).map(() => new Array(nLen+1).fill(0));

    /* LCS 채우기 */
    for(let i=0; i< nLen; i++) {
        for(let j=0; j<hLen; j++) {
            if(haystack[j] === needle[i]) {
                LCS[j+1][i+1] = LCS[j][i]+1;
            }
        }
    }

    /* 정답 찾기 */
    for(let i=0; i<hLen; i++) {
        if(LCS[i+1][nLen] === nLen) return i-nLen+1;
    }

    return -1;
};

// 결과가 매우 안 좋다. LCS보다는 브루투포스가 나았을까?
