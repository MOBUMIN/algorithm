function minWindow(s: string, t: string): string {
    let start = 0;
    let end = 0;
    let ans = "";

    const dict = new Map();

    for (const char of t) {
        const count = dict.get(char) || 0;
        dict.set(char, count + 1);
    }

    function checkAnswer() {
        for (let value of dict.values()) {
            if (value > 0) {
                return false;
            }
        }
        return true;
    }
    
    while(end < s.length) {
        if(dict.has(s[end])) {
            const val = dict.get(s[end]) - 1
            dict.set(s[end], val)


            while(!dict.has(s[start])) start++;

            if(val < 0 && s[end] === s[start]) {
                while(start < end) {
                    if(dict.has(s[start])) {
                        const startVal = dict.get(s[start])
                        if(startVal < 0) {
                            dict.set(s[start], startVal + 1);
                            start++;
                        }
                        else break;
                    } else start++;
                }
            }
            
            if(checkAnswer() && ( ans.length || 1000000 ) > end-start+1)
                ans = s.substring(start, end+1);
        }
         end++;
    }

    return ans;
};
