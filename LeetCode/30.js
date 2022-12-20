/**
 * @param {string} s
 * @param {string[]} words
 * @return {number[]}
 */
 var findSubstring = function(s, words) {
    const len = words[0].length;
    const set = words.length * len;
    const ans = [];
    const originObj = words.reduce((acc, cur) => {
            acc[cur] = (acc[cur] + 1) || 1;
            return acc;
    }, {});
    const a = JSON.stringify(Object.entries(originObj).sort());

    
    for(let i=0; i<s.length; i++) {
        const temp = chunkSubstr(s.slice(i, i+set), len);
        if(temp.length !== words.length) break;

        const compareObj = temp.reduce((acc, cur) => {
                acc[cur] = (acc[cur] + 1) || 1;
                return acc;
        }, {});

        const b = JSON.stringify(Object.entries(compareObj).sort());
        if (a === b) {
            ans.push(i);
        }
    }

    return ans;
};

function chunkSubstr(str, size) {
  const numChunks = Math.ceil(str.length / size);
  const chunks = new Array(numChunks);

  for (let i = 0, o = 0; i < numChunks; ++i, o += size) {
    chunks[i] = str.substr(o, size);
  }

  return chunks;
}