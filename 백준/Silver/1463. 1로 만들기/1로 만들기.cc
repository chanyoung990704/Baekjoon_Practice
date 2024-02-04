#include <iostream>
#include <algorithm>
using namespace std;

#define MAX 1000001
int v[MAX];
int N;
int cnt;

int SolvePro(int N)
{
	if (N == 1)
		return 0;

	if (v[N] != -1)
		return v[N];


	int result = 1000000;

	if (N % 3 == 0)
		result = min(result, SolvePro(N / 3) + 1);
	if (N % 2 == 0)
		result = min(result, SolvePro(N / 2) + 1);
	
	result = min(result, SolvePro(N - 1) + 1);
	

	v[N] = result;


	return v[N];


}



int main()
{
	cin >> N;
	fill(v, v + MAX, -1);

	cout << SolvePro(N) << endl;

}