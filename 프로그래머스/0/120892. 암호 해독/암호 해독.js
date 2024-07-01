function solution(cipher, code) {
    var answer = '';
    
    Array.from(cipher).forEach((cur, idx, arr) => {
        if((idx + 1) % code === 0)
            answer += cur;
    })
    
    return answer;
}