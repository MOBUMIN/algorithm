function numDecodings(s: string): number {
    const encodeArr = {}
    for(let i=1; i<11; i++) encodeArr[`${i}`] = 1;
    for(let i=11; i<27; i++) encodeArr[`${i}`] = 2;
    encodeArr['20'] = 1;

    const makedEncodeArr = {...encodeArr};

    const decode = (shouldDecodedStr) => {
        if(makedEncodeArr[shouldDecodedStr]) return makedEncodeArr[shouldDecodedStr];
        if(shouldDecodedStr[0] === '0') return 0;

        let a = 0, b = 0;
        if(encodeArr[shouldDecodedStr[0]]) {
            a = decode(shouldDecodedStr.slice(1));
        }
        if(encodeArr[shouldDecodedStr[0] + shouldDecodedStr[1]]) {
            b = decode(shouldDecodedStr.slice(2));
        }
        
        makedEncodeArr[shouldDecodedStr] = a + b;
        return a + b;
    }

    return decode(s);
};
