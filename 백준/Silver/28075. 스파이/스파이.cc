#include <iostream>
#include <algorithm>
#include <queue>
#include <vector>
#include <math.h>
#include <stack>
#include <set>
#include <string>
#include <cstring>
using namespace std;



int N, M;
int values[2][3];
int selected[2][3];


int isPossibie(int days, int val, int prevColumn)
{

	if (days == N && val >= M)
		return 1;

	if (days == N && val < M)
		return 0;


	int cnt = 0;

	// val 구하기
	for (int i = 0; i < 2; i++)
		for (int j = 0; j < 3; j++)
		{
			int getVal = val;
			if (prevColumn == j)
				getVal += values[i][j] / 2;
			else
				getVal += values[i][j];

			cnt += isPossibie(days + 1, getVal , j);
		}


	return cnt;




}





int main() {


	ios::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);

	
	cin >> N >> M;


	for(int i = 0 ; i < 2 ; i++)
		for (int j = 0; j < 3; j++)
		{
			cin >> values[i][j];
		}





	int result = 0;



	result = isPossibie(0, 0, -1);

	cout << result << "\n";


}

