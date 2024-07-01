function solution(n, k) {
    var answer = 0;
    
    answer += (n * 12000);
    answer += (k * 2000);
    answer -= ((parseInt(n / 10)) * 2000);
    
    return answer;
}