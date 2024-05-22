#include <string>
#include <vector>
#include <stack>

using namespace std;

int solution(vector<int> ingredient) {
    int answer = 0;
    
    stack<int> st;
    
    for(auto& i : ingredient){
        st.push(i);
        
        if(st.size() >= 4){
            int bread2 = st.top();
            st.pop();
            int meat = st.top();
            st.pop();
            int veg = st.top();
            st.pop();
            int bread1 = st.top();
            st.pop();
            
            if(bread2 == 1 && meat == 3 && veg == 2 && bread1 == 1)
                answer++;
            else{
                st.push(bread1);
                st.push(veg);
                st.push(meat);
                st.push(bread2);
            }
            
        }
    }
    
    return answer;
}