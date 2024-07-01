function solution(num_list) {
    var answer = [];
    
    let l = num_list.length - 1;
    for(let i = l ; i >= 0 ; i--)
        answer.push(num_list[i]);
    
    return answer;
}