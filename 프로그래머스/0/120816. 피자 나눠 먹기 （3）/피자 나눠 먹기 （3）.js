function solution(slice, n) {
    var answer = 0;
    
    answer = parseInt(n / slice);
    n %= slice;
    
    n != 0 ? answer++ : answer = answer;
    
    
    return answer;
}