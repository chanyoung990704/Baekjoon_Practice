#include <vector>
#include <cmath>

using namespace std;

vector<int> solution(int brown, int yellow) {

    int total = brown + yellow;
    vector<int> result;
    // 최소 세로길이인 3부터 시작
    for(int width = 3 ; width <= sqrt(total) ; width++) {
        if(total % width == 0) {
            int height = total / width;
            int curBrown = (width + height) * 2 - 4;
            int curYellow = total - curBrown;
            
            if(curBrown == brown && curYellow == yellow) {
                result.push_back(height);
                result.push_back(width);
                break;
            }
        }
    }
    
    return result;
}
