function restoreIpAddresses(s: string): string[] {
    const validNumberReg = /^(?:25[0-5]|2[0-4]\d|1\d\d|[1-9]\d|\d)$/;
    const isValidNumber = (testStr: string) => validNumberReg.test(testStr)
    const ans: string[] = [];

    const func = (curStr, remainStr, num) => {
        if(num > 4) return;
        if(num === 4) {
            if(remainStr.length === 0) ans.push(curStr);
            return;
        }
        if(remainStr.length === 0) return;
        if(remainStr.length / (4-num)>3) return;
            func(curStr + '.' + remainStr[0] , remainStr.substr(1), num + 1);

        if(remainStr[0] !== "0" && !!remainStr[1]) {
            func(curStr + '.' + remainStr[0] + remainStr[1], remainStr.substr(2), num+1)

            if(!!remainStr[2] && isValidNumber(remainStr[0] + remainStr[1] + remainStr[2])) {
                func(curStr + '.' + remainStr[0] + remainStr[1] + remainStr[2], remainStr.substr(3), num+1)
            }
        }
    }
    func(s[0], s.substr(1), 1);
    if(isValidNumber(s[0] + s[1])) {
        func(s[0] + s[1], s.substr(2), 1)
    }
    if(isValidNumber(s[0] + s[1] + s[2])) {
        func(s[0] + s[1] + s[2], s.substr(3), 1)
    }

    return ans;
};