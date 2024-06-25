function solution(lines) {
    let answer = 0;
    const map = new Map();
    
    for (const line of lines) {
        for (let i = line[0]; i < line[1]; i++) {
            const key = `${i}, ${i + 1}`;
            map.set(key, (map.get(key) || 0) + 1);
        }
    }
    
    for (const count of map.values()) {
        if (count > 1) {
            answer++;
        }
    }
    
    return answer;
}