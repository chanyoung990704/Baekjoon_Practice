function solution(my_string, num1, num2) {
    var answer = '';
    
    Array.from(my_string).forEach((cur, idx) => {
        if(idx === num1){
            answer += my_string[num2];
        }
        else if(idx === num2) {
            answer += my_string[num1];
        }
        else
            answer += cur;
        
    })
    
    return answer;
}