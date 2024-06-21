#include <string>
#include <vector>
#include <algorithm>
#include <queue>

using namespace std;

bool cmp(pair<int, int> a, pair<int, int>b){
    return a.second < b.second;
}

int solution(vector<int> food_times, long long k) {
    int answer = 0;
    
    // 예외 처리
    long long total_food_time = 0;
    for(auto& food_time : food_times)
        total_food_time += food_time;
    
    if(total_food_time <= k)
        return -1;
    
    // 메인로직
    priority_queue<pair<int, int>, vector<pair<int, int>>, 
    greater<pair<int, int>>> pq;
    for(int i = 0 ; i < food_times.size() ; i++)
        pq.push(make_pair(food_times[i], i + 1));
    
    int cycle_cnt = 0;
    long long k_cnt = 0;
    int size = pq.size();
    
    while(!pq.empty() && size > 0) {  // size > 0 조건 추가
        // 현재 가장 작은 것
        int cur = pq.top().first;
        
        long long diff = (long long)(cur - cycle_cnt) * size;  // long long으로 형변환
        if(k_cnt + diff <= k) {
            k_cnt += diff;
            size--;
            cycle_cnt = cur;
            pq.pop();
        } else {
            break;
        } 
    }
    
    // 벡터만들기
    vector<pair<int, int>> arr;
    while(!pq.empty()) {
        arr.push_back(pq.top());
        pq.pop();
    }
    
    if(arr.empty()) return -1;  // 모든 음식을 다 먹은 경우
    
    sort(arr.begin(), arr.end(), cmp);
    
    long long remain_time = (k - k_cnt) % size;
    answer = arr[remain_time].second;
    
    return answer;
}