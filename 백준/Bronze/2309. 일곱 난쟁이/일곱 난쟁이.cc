#include<iostream>
#include<algorithm>
#include<vector>

#define MAX 9
using namespace std;

unsigned int Arr[MAX];
vector<int> sumArr;
bool selected[MAX] = { 0, };
bool is_finish = false;


void Input()
{
	for (int i = 0; i < MAX; i++)
		cin >> Arr[i];

}




void match_person()
{
	int result = 0;

	for (int i = 0; i < MAX; i++)
	{
		if (selected[i] == true)
			result += Arr[i];
	}

	if (result == 100)
	{
		for (int i = 0; i < MAX; i++)
		{
			if (selected[i] == true)
				sumArr.push_back(Arr[i]);
		}

		sort(sumArr.begin(), sumArr.end());

		for (int i = 0; i < 7; i++)
			cout << sumArr[i] << '\n';

		is_finish = true;
	}



}


void DFS(int idx, int cnt) // 조합 재귀
{
	if (cnt == 7 && is_finish == false)
	{
		match_person();
		return;
	}


	for (int i = idx; i < 9; i++)
	{
		if (selected[i] == true)
			continue;
		selected[i] = true;
		DFS(i, cnt + 1);
		selected[i] = false;

	}
}



void Solution()
{

	DFS(0, 0);

}


void Solve()
{
	Input();
	Solution();
}


int main()
{
	ios::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);

	Solve();

	return 0;
}