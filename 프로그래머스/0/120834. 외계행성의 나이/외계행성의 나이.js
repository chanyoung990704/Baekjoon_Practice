function solution(age) {
    const alphabet = 'abcdefghij';
    return String(age).split('').map((cur) => {
        return alphabet[cur];
    }).join('');
}