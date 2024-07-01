function solution(sides) {
    var answer = 0;
    
    // 정렬
    sides.sort((a, b) => b - a);
    
    let long_val = sides[0];
    let etc_val = sides[1] + sides[2];
    
    if(long_val < etc_val)
        return 1;
    else
        return 2;
    
}