function solution(n, numlist) {
    var answer = [];
    
    // filter 사용
    
    answer = numlist.filter((cur) => cur % n === 0);
    
    return answer;
}