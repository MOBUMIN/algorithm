function isScramble(s1: string, s2: string): boolean {

    const scramble = (splittedString1: Array<string>, string2: string): boolean => {
        if (splittedString1.join('') === string2) return true;
        const newSplittedStringList:Array<Array<string>> = [];

        // 분할하기
        for (let i = 0; i < splittedString1.length; i++) {
            if (splittedString1[i].length > 1) {
                const temp: Array<string> = [];
                for (let j = 0; j < i; j++) temp.push(splittedString1[j]);

                temp.push(splittedString1[i].substr(0, Math.floor(splittedString1[i].length / 2)));
                temp.push(splittedString1[i].substr(Math.floor(splittedString1[i].length / 2)));

                for (let j = 1 + 1; j < splittedString1.length; j++) temp.push(splittedString1[j]);

                newSplittedStringList.push(temp);
            }
        }
        console.log(newSplittedStringList);

        // 섞은 버전, 안 섞은 버전

        return false;
    }

    return scramble([s1], s2);
};