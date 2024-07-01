function solution(numbers, direction) {
    var answer = [];
    
    if(direction === "right"){
        const e = numbers.pop();
        numbers.unshift(e);
    }
    else{
        const e = numbers.shift();
        numbers.push(e);
    }
    
    return numbers;
}