#include <string>
#include <vector>

using namespace std;

int get_gcd(int a, int b){
    if(b == 0)
        return a;
    return get_gcd(b, a % b);
}

int get_lcm(int a, int b){
    return a * b / get_gcd(a, b);
}

vector<int> solution(int n, int m) {
    vector<int> answer;
    int gcd_val = get_gcd(n, m);
    int lcm_val = get_lcm(n, m);
    
    answer.push_back(gcd_val);
    answer.push_back(lcm_val);
    return answer;
}