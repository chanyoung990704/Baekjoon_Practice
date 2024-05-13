#include <iostream>
#include <vector>
#include <queue>
#include <cstring>
#include <algorithm>
using namespace std;

#define MAX 987654321
#define MAX_V 1000 + 1
#define endl '\n'
typedef pair<int, int> pii;

bool visited[MAX_V];
vector<pii> adj[MAX_V];
int dist[MAX_V][MAX_V]; // [시작점][나머지 값]

int N, M, X;


void makePath(int start)
{

	priority_queue<pii, vector<pii>, greater<pii>> pq;
	dist[start][start] = 0;
	pq.push(pii(dist[start][start], start));


	while (!pq.empty())
	{

		int curr;

		do {

			curr = pq.top().second;
			pq.pop();


		} while (!pq.empty() && visited[curr]);


		if (visited[curr])
			break;


		visited[curr] = true;


		for (pii& n : adj[curr])
		{
			int next = n.first;
			int nextD = n.second;

			if (dist[start][next] > dist[start][curr] + nextD)
			{
				dist[start][next] = dist[start][curr] + nextD;
				pq.push(pii(dist[start][next], next));
			}
		}




	}




}



int main()
{

	ios::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);

	cin >> N >> M >> X;

	int val = 0;

	for (int i = 0; i < M; i++)
	{
		int t, f, c;
		cin >> t >> f >> c;
		adj[t].push_back(pii(f, c));
	}


	for (int i = 0; i < MAX_V; i++)
		for (int j = 0; j < MAX_V; j++)
			dist[i][j] = MAX;


	for (int i = 1; i <= N; i++)
	{
		makePath(i);
		memset(visited, 0, sizeof(visited));
	}


	for (int i = 1; i <= N; i++)
	{
		val = max(val, dist[i][X] + dist[X][i]);
	}


	cout << val << endl;



}