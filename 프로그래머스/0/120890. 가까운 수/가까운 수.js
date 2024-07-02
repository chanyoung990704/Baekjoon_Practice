function solution(array, n) {
    var answer = 0;
    
    array.sort((a, b) => {
        if(Math.abs(a - n) === Math.abs(b - n))
            return a - b;
        else
            return Math.abs(a - n) - Math.abs(b - n);
    })
    
    return array[0];
}