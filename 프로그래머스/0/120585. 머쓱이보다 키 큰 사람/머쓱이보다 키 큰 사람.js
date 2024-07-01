function solution(array, height) {
    var answer = 0;
    
    array.forEach((cur) => cur > height ? answer += 1 : answer += 0);
    
    return answer;
}