#include <algorithm>
#include <iostream>
#include <vector>

using namespace std;

int dfs(const vector<int>& numbers, const int& target, int result, int cnt) {
	// baseCase
	if (cnt == numbers.size())
		if (result == target)
			return 1;
		else
			return 0;

	return dfs(numbers, target, result + numbers[cnt], cnt + 1) + dfs(numbers, target, result - numbers[cnt], cnt + 1);

}

int solution(vector<int> numbers, int target) {
    int answer = dfs(numbers, target, 0, 0);
    return answer;
}