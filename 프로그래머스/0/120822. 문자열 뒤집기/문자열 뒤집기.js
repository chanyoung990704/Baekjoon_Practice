function solution(my_string) {
    var answer = '';
    
    answer = String(Array.from(my_string).reverse().join(''))
    
    return answer;
}