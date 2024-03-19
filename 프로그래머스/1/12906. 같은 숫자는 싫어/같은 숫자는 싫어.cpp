#include <vector>
#include <iostream>
#include <stack>
#include <algorithm>

using namespace std;

vector<int> solution(vector<int> arr) 
{
    stack<int> st;
    vector<int> result;
    for(int n : arr)
        st.push(n);

    int prev = st.top();
    result.push_back(prev);
    
    while(!st.empty()) {
        // 중복인 경우
        if(prev == st.top())
            st.pop();
        else {
            prev = st.top();
            st.pop();
            result.push_back(prev);
        }
    }
    
    reverse(result.begin(), result.end());
    
    return result;
    
}