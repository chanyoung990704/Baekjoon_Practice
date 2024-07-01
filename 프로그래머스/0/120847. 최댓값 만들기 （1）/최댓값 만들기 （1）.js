function solution(numbers) {
    var answer = 0;
    
    numbers.forEach((cur, idx) => {
        
        numbers.forEach((cur2, idx2) => {
            if(idx < idx2)
                answer < cur * cur2 ? answer = cur * cur2 : answer = answer;
        })
        
    })
    
    return answer;
}