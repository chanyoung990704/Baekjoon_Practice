function get_gcd(a, b) {
    
    if(b === 0)
        return a;
    
    return get_gcd(b, a % b);
    
}

function get_lcm(a, b) {
    return parseInt(a * b / get_gcd(a, b));
}



function solution(n) {
    var answer = 0;
    
    answer = parseInt(get_lcm(n, 6) / 6)
    
    return answer;
}