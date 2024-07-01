function solution(n) {
    var answer = 0;
    
    let cnt = 0;
    
    while(cnt < n) {
        answer++;
        
        if(isValid(answer))
            cnt++;
        
    }
    
    return answer;
}

function isValid(n){
    // 3의 배수이면 거짓
    if(n % 3 === 0)
        return false;
    
    
    // 3이 들어가면 거짓
    if(String(n).includes('3'))
        return false;
    return true;
}