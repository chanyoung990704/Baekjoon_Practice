#include <iostream>
#include <algorithm>
#include <queue>
#include <vector>
#include <stack>
#include <set>
#include <string>
#include <cstring>
using namespace std;


bool arr[1000];



int main() {



	memset(arr, true, sizeof(arr));



	for (int i = 100; i < 1000; i++)
	{
		string num = to_string(i);

		if (num[0] == num[1] || num[0] == num[2] || num[1] == num[2])
		{
			arr[i] = false;
		}


		if (  count(num.begin(), num.end(), '0') != 0)
		{
			arr[i] = false;
		}


	}

	


	int n;	cin >> n;


	for (int i = 0; i < n; i++)
	{
		string question_num;
		int strike, ball;
		cin >> question_num >> strike >> ball;

		for (int j = 100; j < 1000; j++)
		{
			if (!arr[j])
				continue;

			string num = to_string(j);
			int tmp_strike = 0;
			int tmp_ball = 0;


			for (int k = 0; k < 3; k++)
			{

				if (question_num[k] == num[k])
					tmp_strike++;
				else
					if (count(num.begin(), num.end(), question_num[k]) != 0)
						tmp_ball++;


			}


			if (strike != tmp_strike || ball != tmp_ball)
				arr[j] = false;


		}




	}


	int result = 0;

	for (int i = 100; i < 1000; i++)
		if (arr[i])
			result++;


	cout << result << "\n";



}

