#include <string>
#include <vector>
#include <unordered_set>

using namespace std;

int solution(vector<int> elements) {
    int answer = 0;
    int len = elements.size();
    
    vector<int> elements_2(elements.begin(), elements.end());
    elements_2.insert(elements_2.end(), elements.begin(), elements.end());
    unordered_set<int> element_set;
    
    
    for(int i = 1 ; i <= len ; i++){
        for(int j = 0 ; j < len ; j++){
            int sum = 0;
            for(int k = 0 ; k < i ; k++)
                sum += elements_2[j + k];
            element_set.insert(sum);
        }    
        
    }
    
    answer = element_set.size();
    return answer;
}