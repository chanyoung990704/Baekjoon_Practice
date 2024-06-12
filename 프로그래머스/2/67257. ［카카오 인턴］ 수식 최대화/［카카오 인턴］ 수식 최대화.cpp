#include <string>
#include <vector>
#include <algorithm>
#include <math.h>

using namespace std;

// 계산
long long cal_exp(long long l, long long r, char op) {
    if(op == '+')
        return l + r;
    else if(op == '-')
        return l - r;
    else
        return l * r;
}

long long solve_exp(vector<long long> nums, vector<char> operators, 
                   vector<char>& op) {
    
    for(auto& cur_op : op) {
        
        // 연산자 찾기
        size_t idx = 0;
        
        while(idx < operators.size()) {
            
            // 일치
            if(operators[idx] == cur_op) {
                long long result = cal_exp(nums[idx], nums[idx + 1], cur_op);
                nums.erase(nums.begin() + idx, nums.begin() + idx + 2);
                operators.erase(operators.begin() + idx);
                nums.insert(nums.begin() + idx, result);
            }
            else{
                idx++;
            }
            
        }
        
        
    }
    
    return abs(nums[0]);
}

long long solution(string expression) {
    long long answer = 0;
    
    vector<long long> nums;
    vector<char> operators;
    vector<char> op = {'+', '-', '*'};
    
    // 분리
    string val = "";
    for(auto& cur : expression) {
        if(isdigit(cur))
            val.push_back(cur);
        else{
            operators.push_back(cur);
            nums.push_back(stoll(val));
            val.clear();
        }
    }
    
    nums.push_back(stoll(val));
    
    // 로직
    
    sort(op.begin(), op.end());
    do{
        answer = max(answer, solve_exp(nums, operators, op));
    }while(next_permutation(op.begin(), op.end()));
    
    
    return answer;
}