
function isCombNum(n) {
    let cnt = 0;
    for(let i = 1 ; i <= Math.sqrt(n) ; i++){
        if(n % i === 0){
            cnt++;
            if(i !== parseInt(n / i))
                cnt++;
        }
    }
    
    return cnt >= 3;
}

function solution(n) {
    var answer = 0;
    
    for(let i = 4 ; i <= n ; i++)
        if(isCombNum(i))
            answer++;
    
    return answer;
}