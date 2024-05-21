#include <string>
#include <vector>
#include <algorithm>
#include <queue>

using namespace std;

int solution(vector<int> food_times, long long k) {
    int answer = 0;
    
    // basecase
    long long basecase = 0;
    for(auto t : food_times)
        basecase += t;
    
    if(basecase <= k)
        return -1;
    
    
    priority_queue<pair<int, int>, vector<pair<int, int>>,
    greater<pair<int,int>>> pq; // 최소힙 <times, idx>
    for(int i = 0 ; i < food_times.size() ; i++)
        pq.push(make_pair(food_times[i], i + 1));

    
    long long total_time = 0;
    long long prev_time = 0;
    long long size = food_times.size();
    
    while(total_time + (pq.top().first - prev_time) * size <= k 
         ) {
        int cur = pq.top().first;
        pq.pop();
        total_time += (cur - prev_time) * size;
        size--;
        prev_time = cur;
    }
    
    vector<int> result;
    while(!pq.empty()){
        result.push_back(pq.top().second);
        pq.pop();
    }
    
    sort(result.begin(), result.end());
    
    answer = result[(k - total_time) % size];
    
    return answer;
}