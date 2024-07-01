function solution(numbers) {
    var answer = [];
    
    // map 사용
    answer = numbers.map((cur) => cur *= 2)
    
    return answer;
}