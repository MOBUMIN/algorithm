function longestPalindrome(s: string): string {
    const len = s.length;
    const dp = new Array(len).fill(0).map(() => new Array(len).fill(false));
    let start = 0;
    let maxLen = 1;

    for(let i=0; i<len; i++) dp[i][i] = true;

    for(let i=len-1; i>=0; i--) {
        for(let j=i+1; j<len; j++) {
            if(s[i] === s[j]) {
                if(j-i === 1) dp[i][j] = true;
                else dp[i][j] = dp[i+1][j-1];
            }
            if(dp[i][j] && j-i+1 > maxLen) {
                maxLen= j-i+1;
                start = i;
            }
        }
    }

    return s.substring(start, start + maxLen);
};
