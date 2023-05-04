function fullJustify(words: string[], maxWidth: number): string[] {
    let start = 0;
    let i = 0;
    let len = 0;
    let wordNum = 0;
    const answer: string[] = [];

    const pushWords = (isLastLine) => {
        let left = isLastLine ? 0 : (maxWidth - len) % (wordNum-1);
        const space = () => "".padEnd(isLastLine ? 1 : Math.floor((maxWidth - len) / (wordNum-1 || 1)) + (left-- > 0 ? 1 : 0));
        const lastSpace = "".padEnd(isLastLine ? maxWidth-len : Math.floor((maxWidth - len) / (wordNum-1 || 1)));
        console.log("push", start, i, isLastLine, lastSpace);

        let str = "";
        for(let j = start; j<= i; j++) {
            console.log(str, left);
            str += words[j];
            if(j < i-1) {
                str += space();
            }
            else if(j === i-1 || isLastLine) str += lastSpace;
        }

        answer.push(str);
    }

    while(i < words.length) {
        console.log(i, len + words[i].length + wordNum);
        if(len + words[i].length + wordNum <= maxWidth) {
            len += words[i].length;
            wordNum++;
            
            if(len + wordNum === maxWidth || i+1 === words.length) {
                pushWords(i+1 === words.length);
                start = i + 1;
                len = 0;
                wordNum = 0;
            }
        } else {
            i--;
            pushWords(i+1 === words.length);
            start = i + 1;
            len = 0;
            wordNum = 0;
        }
        i++;
    }

    return answer;
};
