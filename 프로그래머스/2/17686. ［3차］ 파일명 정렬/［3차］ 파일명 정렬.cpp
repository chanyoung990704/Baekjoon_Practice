#include <string>
#include <vector>
#include <algorithm>

using namespace std;


struct File{
public:
    string head;
    int number;
    string tail;
    int idx;
    
    
    File(string head, int number, string tail, int idx){
        this->head = head;
        this->number = number;
        this->tail = tail;
        this->idx = idx;
    }
    
};

bool cmp(File a, File b){
    if(a.head != b.head){
        return a.head < b.head;
    }else if(a.number != b.number){
        return a.number < b.number;
    }else
        return a.idx < b.idx;
    
}


vector<string> solution(vector<string> files) {
    vector<string> answer;
    
    vector<File> file_v;
    
    for(int i = 0 ; i < files.size() ; i++) {
        
        string cur = files[i];
        string head = "";
        string number = ""; // 나중에 string으로 바꿔야 함
        string tail = "";
        int idx = i;
        
        // Head 구하기
        size_t cur_idx = 0;
        while(!isdigit(cur[cur_idx])){
            head.push_back(tolower(cur[cur_idx]));
            cur_idx++;
        }
        
        // number 구하기
        while(isdigit(cur[cur_idx])){
            number.push_back(cur[cur_idx]);
            cur_idx++;
        }
        
        // tail 구하기
        tail = cur.substr(cur_idx);
        
        File cur_to_file = File(head, stoi(number), tail, idx);
        file_v.push_back(cur_to_file);
        
    }
    
    // 정렬
    sort(file_v.begin(), file_v.end(), cmp);
    
    for(auto& f : file_v)
        answer.push_back(files[f.idx]);
    
    
    return answer;
}