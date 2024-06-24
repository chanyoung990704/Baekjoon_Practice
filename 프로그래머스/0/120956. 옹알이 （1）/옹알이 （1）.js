function solution(babbling) {
    var answer = 0;
    const can_word = ["aya", "ye", "woo", "ma"];
    
    for (let b of babbling) {
        
        const word_set = new Set();
        
        for(let w of can_word) {
            while(b.includes(w)) {
                if(!word_set.has(w)){
                    word_set.add(w);
                    b = b.replace(w, ' ');
                }
                else
                    break;
            }
        }
        
        if(b.trim().length === 0)
            answer++;
    }
    
    return answer;
}