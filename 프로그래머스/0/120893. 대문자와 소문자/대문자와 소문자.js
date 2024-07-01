function solution(my_string) {
    var answer = '';
    
    Array.from(my_string).forEach((cur) => {
        if(isupper(cur)){
            answer += (cur.toLowerCase());
        }else{
            answer += (cur.toUpperCase());
        }
    })
    
    
    return answer;
}


function isupper(s){
    return s === s.toUpperCase();
}

function islower(s){
    return s === s.toLowerCase();
}