#include <iostream>
#define MAX 8
using namespace std;

int arr[MAX];
int N, M;
bool visited[MAX] = { 0, };

void print()
{

	for (int i = 0; i < N; i++)
	{
		if (visited[i] == true)
			cout << arr[i] << " ";
	}

	cout << "\n";
}


void dfs(int cnt, int idx)
{
	if (cnt == M)
	{
		print();
		return;
	}

	for (int i = idx; i < N; i++)
	{
		if (visited[i] == true)
			continue;

		visited[i] = true;
		dfs(cnt + 1, i + 1);
		visited[i] = false;

	}
	

}


int main()
{
	ios::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);
	cin >> N >> M;


	for (int i = 0; i < N; i++)
	{
		arr[i] = i + 1;
	}

	
	dfs(0, 0);



}