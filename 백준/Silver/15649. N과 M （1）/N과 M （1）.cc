#include<iostream>
#include<vector>
#define MAX 8
using namespace std;


int N, M;
vector<int> vec;
bool visited[MAX] = { 0, };
int arr[MAX];


void print()
{
	for (int i = 0; i < vec.size(); i++)
		cout << vec[i] << " ";

	cout << "\n";
}



void dfs(int cnt)
{
	if (cnt == M)
	{
		print();
		return;
	}


	else
	{
		for (int i = 0; i < N; i++)
		{
			if (visited[i] == true)
				continue;

			else
			{
				visited[i] = true;
				vec.push_back(arr[i]);
				dfs(cnt + 1);
				visited[i] = false;
				vec.pop_back();

			}

		}



	}


}




int main()
{
	ios::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);


	cin >> N >> M;

	for (int i = 0; i < N; i++) // arr 초기화
	{
		arr[i] = i + 1;
	}


	dfs(0);

	return 0;
}