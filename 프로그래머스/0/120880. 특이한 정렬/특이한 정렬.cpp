#include <string>
#include <vector>
#include <algorithm>
#include <cmath>

using namespace std;

int target;

bool cmp(int a, int b){
    if(abs(a - target) != abs(b - target))
        return abs(a - target) < abs(b - target);
    
    return a > b;
}

vector<int> solution(vector<int> numlist, int n) {
    target = n;
    
    sort(numlist.begin(), numlist.end(), cmp);
    
    return numlist;
}