function solution(n) {
    var answer = 0;
    
    var s = String(n);
    
    for(let i of s)
        answer += Number(i);
    
    return answer;
}