function solution(n) {
    // DP 테이블 초기화
    const dp = [1]; // 0!은 1입니다.
    let i = 1;

    // n 이하의 팩토리얼 값을 계산하고 저장
    while (true) {
        const nextFactorial = dp[i - 1] * i;
        if (nextFactorial > n) break;
        dp[i] = nextFactorial;
        i++;
    }

    // 가장 큰 i 반환
    return i - 1;
}