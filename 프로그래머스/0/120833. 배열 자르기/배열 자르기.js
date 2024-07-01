function solution(numbers, num1, num2) {
    var answer = [];
    
    answer = numbers.filter((cur, idx, arr) => (idx >= num1) && (idx <= num2))
    
    return answer;
}