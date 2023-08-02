//MST 최소 스패닝 트리 ==> 크루스칼 알고리즘 구현
// Union, Find(returnParent)
// 스패닝 트리 ==> 모든 노드를 가중치를 가진 간선을 연결하면서 사이클이 없는 경우
//백준 1922
#include <iostream>
#include <algorithm>
#include <queue>
#include <vector>
#include <set>

using namespace std;
int N, M;
int parent_node[1000 + 1];


int returnParent(int node)
{
	if (parent_node[node] == node)
		return node;
	else
		return returnParent(parent_node[node]);
}


void unionParent(int node1, int node2)
{
	int node1_parent = returnParent(node1);
	int node2_parent = returnParent(node2);

	//숫자가 작은 노드를 부모 노드로 지정
	if (node1_parent < node2_parent)
		parent_node[node2_parent] = node1_parent;
	else
		parent_node[node1_parent] = node2_parent;



}


bool isCycle(int node1, int node2)
{
	int node1_parent = returnParent(node1);
	int node2_parent = returnParent(node2);

	//부모 노드가 같다 -> 사이클이 발생한다.
	if (node1_parent == node2_parent)
		return true;
	else
		return false;
}



bool cmp(pair<int, pair<int, int>> a, pair<int, pair<int, int>> b)
{
	return a.first < b.first;
}


int main() {


	ios::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);


	cin >> N >> M;
	
	int result = 0;

	for (int i = 0; i <= N; i++)
	{
		parent_node[i] = i;
	}

	vector<pair<int, pair<int, int>>> adj;
	
	
	//간선 연결
	for (int i = 1; i <= M; i++)
	{
		int from, to, cost;		cin >> from >> to >> cost;

	
		adj.push_back(make_pair(cost, make_pair(from, to)));


	}

	//크루스칼 알고리즘을 사용하기 위해 사전 오름차순 정렬필요!
	sort(adj.begin(), adj.end(), cmp);


	for (int i = 0; i < adj.size(); i++)
	{
		//사이클 발생 x -> 간선 연결 가능
		if (!isCycle(adj[i].second.first, adj[i].second.second))
		{
			result += adj[i].first;
			//간선을 연결했으면 부모 노드를 업데이트 
			unionParent(adj[i].second.first, adj[i].second.second);
		}

	}


	cout << result << "\n";





}

