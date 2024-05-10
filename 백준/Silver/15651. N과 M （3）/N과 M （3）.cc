#include <iostream>
#include<vector>
#define MAX 8
using namespace std;

int arr[MAX];
int N, M;
bool visited[MAX] = { 0, };
vector<int> vec;

void print()
{

	for (int i = 0; i < vec.size(); i++)
	{
		cout << vec[i] << " ";
	}

	cout << "\n";
}


void dfs(int cnt)
{
	if (cnt == M)
	{
		print();
		return;
	}

	for (int i = 0; i < N; i++)
	{

		visited[i] = true;
		vec.push_back(arr[i]);
		dfs(cnt + 1);
		vec.pop_back();
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

	
	dfs(0);



}