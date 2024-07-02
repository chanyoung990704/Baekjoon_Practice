function solution(num, k) {
    var answer = -1;
    
    let num_str = String(num);
    
    let idx = 1;    
    for(let s of num_str){
        if(Number(s) === k){
            answer = idx;
            break;
        }
        idx++;
    }
    
    return answer;
}