#include <iostream>
#include <algorithm>
#include <queue>
#include <vector>
#include <stack>
#include <set>

using namespace std;

// cur = 0부터 시작한다고 가정
int addMethod(int result, int cur)
{
	// 덧셈으로 목표값에 도달했으면
	if (cur == result)
		return 1;

	// BaseCase = >  무한 루프 방지
	if (cur > result)
		return 0;



	//덧셈 방법의 총 갯수
	int cnt = 0;

	// n을 1, 2, 3의 합으로 표현한다
	for (int i = 1; i <= 3; i++)
	{

		cnt = cnt + addMethod(result, cur + i);


	}


	return cnt;


}


int main() {


	ios::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);


	int T; cin >> T;



	for (int i = 0; i < T; i++)
	{
		int n;	cin >> n;
		cout << addMethod(n, 0) << "\n";
	}





}

