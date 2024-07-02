function solution(order) {
    var answer = 0;
    
    const str = String(order);
    
    for(let s of str){
        if(s === "3")
            answer++;
        else if(s === "6")
            answer++;
        else if(s === "9")
            answer++;
    }
    
    return answer;
}