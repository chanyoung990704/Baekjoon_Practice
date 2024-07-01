function solution(n, t) {
    var answer = n;
    
    let cnt = 1;
    
    while(cnt <= t) {
        answer *= 2;
        cnt++;
    }
    
    return answer;
}