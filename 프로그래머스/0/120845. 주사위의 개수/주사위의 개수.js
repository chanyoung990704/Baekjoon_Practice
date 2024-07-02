function solution(box, n) {
    var answer = 1;
    
    answer *= parseInt(box[0] / n);
    answer *= parseInt(box[1] / n);
    answer *= parseInt(box[2] / n);
    
    return answer;
}