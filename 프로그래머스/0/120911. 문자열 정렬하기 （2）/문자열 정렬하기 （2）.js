function solution(my_string) {
    var answer = '';
    answer = my_string.toLowerCase();
    
    answer = Array.from(answer).sort(). join('');
    
    return answer;
}