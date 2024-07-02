function solution(before, after) {
    var answer = 0;
    
    const before_arr = before.split('').sort().join();
    const after_arr = after.split('').sort().join();
    
    before_arr === after_arr ? answer = 1 : answer = 0;
    
    return answer;
}