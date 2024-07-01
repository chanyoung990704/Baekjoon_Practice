function solution(my_string) {
    var answer = '';
    
    const m_arr = ["a", "e", "i", "o", "u"];
    const m_set = new Set(m_arr);
    
    for(let i = 0 ; i < my_string.length ; i++){
        if(!m_set.has(my_string[i]))
            answer += my_string[i];
    }

    
    return answer;
}