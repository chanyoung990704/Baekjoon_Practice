#include <iostream>

using namespace std;

int solution(int n, int a, int b)
{

    int round = 1;
    while((a - 1) /2 != (b - 1) / 2) {
        round++;
        // a번호가 홀수라면
        if(a % 2 == 1)
            a = (a + 1) / 2;
        else
            a = a / 2;
        
        if(b % 2 == 1)
            b = (b + 1) / 2;
        else
            b = b / 2;
    }
    
    return round;
}