function solution(my_string) {
    var answer = 0;
    
    let str = "";
    
    for(let i = 0 ; i < my_string.length ; i++) {
        // 숫자가 끝나면
        if(isNaN(Number(my_string[i]))){
            if(str.length !== 0){
                answer += Number(str);
                str = "";
            }
        }else{
            str += my_string[i];
        }
    }
    
    if(str.length !== 0)
        answer += Number(str);
    
    return answer;
}