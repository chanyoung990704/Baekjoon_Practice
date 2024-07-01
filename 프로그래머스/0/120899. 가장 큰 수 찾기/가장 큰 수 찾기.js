function solution(array) {
    var answer = [];
    
    answer.push(array[0]);
    answer.push(array[1]);
    
    
    array.forEach((cur, idx) => 
            cur > answer[0] ? answer = [cur, idx] : answer = answer);
    
    
    return answer;
}