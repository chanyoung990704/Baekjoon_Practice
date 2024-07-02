function solution(numbers) {
    if (numbers.length < 2) {
        return null; // 배열의 길이가 2 미만일 경우 처리
    }

    numbers.sort((a, b) => b - a); // 내림차순 정렬

    // 가장 큰 두 양수의 곱과 가장 작은 두 음수의 곱 중 큰 값 반환
    return Math.max(numbers[0] * numbers[1], numbers[numbers.length - 1] * numbers[numbers.length - 2]);
}