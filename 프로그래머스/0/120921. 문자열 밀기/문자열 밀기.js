function solution(A, B) {
    const len = A.length;
    
    for (let i = 0; i < len; i++) {
        if (A === B) return i;
        A = A[len - 1] + A.slice(0, -1);
    }
    
    return -1;
}