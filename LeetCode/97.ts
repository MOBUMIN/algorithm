function isInterleave(s1: string, s2: string, s3: string): boolean {
    const str1Len = s1.length;
    const str2Len = s2.length;
    const str3Len = s3.length;

    if(str1Len + str2Len !== str3Len) return false;

    // dp[i][j] 는 s1 i개와 s2 j개로 s3 i+j개까지 가능한지를 저장    
    const dp = Array.from({ length: str1Len + 1 }, () => Array(str2Len + 1).fill(false));
    dp[0][0] = true;

    for (let i = 0; i <= str1Len; i++) {
        for (let j = 0; j <= str2Len; j++) {
            if (i > 0 && s1[i - 1] === s3[i + j - 1]) {
                dp[i][j] = dp[i][j] || dp[i - 1][j];
            }
            if (j > 0 && s2[j - 1] === s3[i + j - 1]) {
                dp[i][j] = dp[i][j] || dp[i][j - 1];
            }
        }
    }

    return dp[str1Len][str2Len];
};
