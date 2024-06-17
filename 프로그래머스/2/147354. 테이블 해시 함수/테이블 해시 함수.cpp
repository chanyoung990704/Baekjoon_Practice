#include <string>
#include <vector>
#include <algorithm>
#include <cmath>

using namespace std;

int cmp_idx = -1;

bool cmp(const vector<int>& a, const vector<int>& b) {
    if (a[cmp_idx] != b[cmp_idx])
        return a[cmp_idx] < b[cmp_idx];
    else
        return a[0] > b[0];
}

int get_val(const vector<int>& d, int i) {
    int val = 0;
    for (const auto& n : d)
        val += (n % i);
    
    return val;
}

string change_binary(int n) {
    string result;
    
    while (n > 0) {
        result.insert(result.begin(), '0' + (n % 2));
        n /= 2;
    }
    
    return result.empty() ? "0" : result;
}

string xor_op(const string& a, const string& b) {
    string long_s = (a.size() > b.size()) ? a : b;
    string short_s = (a.size() <= b.size()) ? a : b;
    
    // Padding short_s with leading zeros
    short_s.insert(short_s.begin(), long_s.size() - short_s.size(), '0');
    
    for (size_t i = 0; i < short_s.size(); ++i) {
        long_s[i] = (long_s[i] != short_s[i]) ? '1' : '0';
    }
    
    return long_s;
}

int solution(vector<vector<int>> data, int col, int row_begin, int row_end) {
    int answer = 0;
    
    cmp_idx = col - 1;
    sort(data.begin(), data.end(), cmp);
    
    // 3번 과정
    vector<int> result;
    for (int i = row_begin - 1; i <= row_end - 1; ++i)
        result.push_back(get_val(data[i], i + 1));
    
    // XOR
    if (result.size() == 1)
        return result[0];
    
    string prev = change_binary(result[0]);
    
    for (size_t i = 1; i < result.size(); ++i) {
        string r = change_binary(result[i]);
        prev = xor_op(prev, r);
    }
    
    // 계산
    for (size_t i = 0; i < prev.size(); ++i)
        if (prev[i] == '1')
            answer += (1 << (prev.size() - 1 - i));
    
    return answer;
}