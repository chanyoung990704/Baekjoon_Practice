function solution(i, j, k) {
    var answer = 0;
    
    for( ; i <= j ; i++){
        answer += (String(i).split('').filter((cur) => cur === String(k)).length)
    }
    
    return answer;
}