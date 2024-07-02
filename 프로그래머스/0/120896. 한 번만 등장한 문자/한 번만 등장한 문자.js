function solution(s) {
    
    const cnt = {};
    
    for(let cur of s)
        cnt[cur] = (cnt[cur] || 0) + 1;
    
    let result_str = '';
    
    for(let cur of s)
        if(cnt[cur] === 1)
            result_str += cur;
    
    return result_str.split('').sort().join('');
    
}