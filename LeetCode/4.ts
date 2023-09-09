function findMedianSortedArrays(nums1: number[], nums2: number[]): number {
    const arr = [...nums1, ...nums2].sort(function(a, b)  {
        return a - b;
    });
    const a = Math.floor((arr.length + 1) / 2)

    if((arr.length+1) % 2 === 0) return arr[a-1];
    
    return (arr[a] + arr[a-1]) /2
};
