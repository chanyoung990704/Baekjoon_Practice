function solution(n) {
    var answer = 0;
    
    answer = Math.sqrt(n);
    
    
    if(Number.isInteger(answer))
        return 1;
    else
        return 2;
    
}