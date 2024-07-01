function solution(my_string) {
    var answer = [];
    
    for(let s of my_string)
        if(!isNaN(Number(s)))
            answer.push(Number(s));
    
    answer.sort((a, b) => a - b);
    
    return answer;
}