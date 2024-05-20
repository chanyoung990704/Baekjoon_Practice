#include <string>
#include <vector>

using namespace std;

string solution(int a, int b) {
    string answer = "";
    
    vector<int> days = {0, 31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
    vector<string> day = {"FRI", "SAT", "SUN", "MON", "TUE", "WED", "THU"};
    
    int month = 0;
    for(int i = 1 ; i < a ; i++){
        month += days[i];
    }
    
    month += b - 1;
    
    answer.append(day[month % 7]);
    
    
    return answer;
}