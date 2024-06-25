function solution(numlist, n) {
    // 비교 함수 정의
    const cmp = (a, b) => {
        const diffA = Math.abs(a - n);
        const diffB = Math.abs(b - n);
        
        if (diffA !== diffB) {
            return diffA - diffB; // 오름차순 정렬
        }
        
        return b - a; // 내림차순 정렬
    };
    
    // 배열 정렬
    numlist.sort(cmp);
    
    return numlist;
}