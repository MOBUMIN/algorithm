function removeDuplicateLetters(s: string): string {
    let answer = '';
    const chars = 'abcdefghijklmnopqrstuvwxyz'
    const visitArr = new Array(26).fill(false);

    for(let i=0; i<s.length; i++) {
        const curPos = chars.indexOf(s[i]);
        if(visitArr[curPos]) continue;

        visitArr[curPos] = true;

       // 뒤에도 있는데, 나보다 사전순으로 느린게 앞에 있으면 지움
       for(let j=i-1; j>=0; j--) {
           if(s.lastIndexOf(s[j]) < i) continue;
           if(s[i] < s[j] && answer > answer.replace(s[j], '')) {
               answer = answer.replace(s[j], '');
               visitArr[chars.indexOf(s[j])] = false;
           }
       }

        answer = answer.concat(s[i])
    }

    return answer;
};
