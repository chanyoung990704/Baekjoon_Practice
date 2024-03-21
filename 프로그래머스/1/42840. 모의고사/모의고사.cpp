#include <string>
#include <vector>
#include <algorithm>

using namespace std;

vector<int> solution(vector<int> answers) {
    vector<int> human1 = {1, 2, 3, 4, 5};
    vector<int> human2 = {2, 1, 2, 3, 2, 4, 2, 5};
    vector<int> human3 = {3, 3, 1, 1, 2, 2, 4 ,4, 5, 5};
    
    // 정답 비교
    int correct1 = 0;   int correct2 = 0;   int correct3 = 0;
    for(int i = 0 ; i < answers.size() ; i++) {
        int answer = answers[i];
        
        // 각 사람별 정답
        int answer1 = human1[i % human1.size()];
        int answer2 = human2[i % human2.size()];
        int answer3 = human3[i % human3.size()];
        
        // 정답 비교후 정답수 갱신
        if(answer == answer1)
            correct1++;
        if(answer == answer2)
            correct2++;
        if(answer == answer3)
            correct3++;  
    }
    
    int maxVal = max(max(correct1, correct2), correct3);
    vector<int> result;
    if(correct1 == maxVal)
        result.push_back(1);
    if(correct2 == maxVal)
        result.push_back(2);
    if(correct3 == maxVal)
        result.push_back(3);
    
    return result;
    
}