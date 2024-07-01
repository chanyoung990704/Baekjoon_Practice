function solution(n) {
    var answer = [];
    
    for(let i = 1 ; i <= Math.sqrt(n) ; i++)
        if(n % i === 0){
            answer.push(i);
            if(i !== parseInt(n / i))
                answer.push(parseInt(n / i));
        }
    
    answer.sort((a, b) => a - b)
    
    return answer;
}