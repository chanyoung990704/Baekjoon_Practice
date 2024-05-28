#include <string>
#include <algorithm>
#include <unordered_set>
#include <unordered_map>

using namespace std;

int solution(string str1, string str2) {
    int answer = 0;
    
    int total_size = 0;
    unordered_set<string> str_set;
    
    unordered_map<string, int> str1_map;
    
    for(int i = 0 ; i < str1.size() - 1 ; i++){
        char c1 = str1[i];
        char c2 = str1[i + 1];
        
        if(isalpha(c1) && isalpha(c2)){
            string tmp;
            tmp.push_back(tolower(c1));
            tmp.push_back(tolower(c2));
            str1_map[tmp]++;
            str_set.insert(tmp);
            total_size++;
        }
    }
    
    unordered_map<string, int> str2_map;
    
    for(int i = 0 ; i < str2.size() - 1 ; i++){
        char c1 = str2[i];
        char c2 = str2[i + 1];
        
        if(isalpha(c1) && isalpha(c2)){
            string tmp;
            tmp.push_back(tolower(c1));
            tmp.push_back(tolower(c2));
            str2_map[tmp]++;
            str_set.insert(tmp);
            total_size++;
        }
    }
    
    int intersection_size = 0;
    int union_size = 0;
    
    for(auto& m : str1_map){
        string key = m.first;
        int cnt1 = m.second;
        int cnt2 = str2_map[key];
        
        intersection_size += min(cnt1, cnt2);
        union_size += max(cnt1, cnt2);
        
    }
    
    for(auto& m : str2_map){
        string key = m.first;
        if(str1_map.find(key) == str1_map.end())
            union_size += m.second;
    }
    
    if(union_size == 0)
        return 65536;
    
    double d = (double)intersection_size / union_size;
    answer = (int)(d * 65536);
    
    return answer;
}