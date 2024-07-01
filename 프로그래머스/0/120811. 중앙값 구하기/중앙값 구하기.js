function solution(array) {
    var answer = 0;
    
    array.sort((a, b) => a - b);
    
    let mid = parseInt(array.length / 2);
    
    answer = array[mid];
    return answer;
}