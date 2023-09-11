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

int A, T, op;

int bundaegi()
{
	int b_cnt = 0;
	int c_cnt = 0;

	int cnt = 2;

	while (true)
	{


		for (int i = 0; i < 4; i++)
		{
			if (i % 2 == 0)
				b_cnt++;
			else
				c_cnt++;

			if (op == 0 && b_cnt == T)
				return (b_cnt + c_cnt - 1) % A;
			if (op == 1 && c_cnt == T)
				return (b_cnt + c_cnt - 1) % A;


		}



		for (int i = 0; i < cnt; i++)
		{
			b_cnt++;
			if (op == 0 && b_cnt == T)
				return (b_cnt + c_cnt - 1) % A;

		}

		for (int i = 0; i < cnt; i++)
		{
			c_cnt++;
			if (op == 1 && c_cnt == T)
				return (b_cnt + c_cnt - 1) % A;

		}

		cnt++;


	}
}


int main() {


	ios::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);

	
	cin >> A >> T >> op;

	


	cout << bundaegi() << "\n";



}

