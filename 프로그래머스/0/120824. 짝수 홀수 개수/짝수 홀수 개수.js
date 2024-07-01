function solution(num_list) {
    var answer = [0, 0];
    
    num_list.forEach((cur) => Number(cur) % 2 === 0 ? answer[0]++ : answer[1]++);
    
    return answer;
}