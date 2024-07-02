function solution(my_string) {
    var answer = '';
    
    const set = Array.from(new Set(my_string)).join('')
    
    return set;
}