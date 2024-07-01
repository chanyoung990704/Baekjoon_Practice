function solution(s1, s2) {
    var answer = 0;
    
    s1.forEach((cur) => {
        s2.forEach((cur2) => {
            if(cur === cur2)
                answer++;
        })
    })
    
    return answer;
}