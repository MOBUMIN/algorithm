function lengthOfLongestSubstring(s: string): number {
    let string = "";
    let maxLen = 0;
    for(let i=0; i<s.length; i++) {
       if (string.includes(s[i])) {
            string = string.slice(string.indexOf(s[i]) + 1);
        }
        string += s[i];
        if (maxLen < string.length) {
            maxLen = string.length;
        }  
    }
    return maxLen;
};
