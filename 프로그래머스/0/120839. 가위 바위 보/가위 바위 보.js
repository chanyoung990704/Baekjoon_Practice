function solution(rsp) {
    var answer = '';
    
    for(let s of rsp){
        
        if(s === "2")
            answer += "0";
        else if(s === "5")
            answer += "2";
        else
            answer += "5";
        
    }
    
    
    return answer;
}