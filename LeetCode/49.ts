function groupAnagrams(strs: string[]): string[][] {
    const Dict = new Map();
    
    for(let i=0; i<strs.length; i++) {
        const a = strs[i];
        const sortedA = a.split('').sort().join()
        let aSame = Dict.get(sortedA)
        if(aSame) {
            aSame.push(a);
        } else {
            aSame = [a]
        }

        Dict.set(sortedA, aSame)
    }

    return Array.from(Dict.values())
};
