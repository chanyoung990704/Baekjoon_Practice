function solution(my_string) {
    var answer = 0;
    
    my_string.trim();
    
    Array.from(my_string).forEach((cur) => {
        if(!isNaN(cur))
            answer += Number(cur);
    })
    
    return answer;
}