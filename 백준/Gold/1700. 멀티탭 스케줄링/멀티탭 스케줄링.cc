#include <iostream>
using namespace std;

#define MAX 101
int numArr[MAX];
int multitap[MAX];

int N, K;


int main()
{
	cin >> N >> K;

	int result = 0;

	for (int i = 0; i < K; i++)
		cin >> numArr[i];

	for (int i = 0; i < K; i++)
	{
		bool plugged = false;
		// 기기가 꽂혀있는 지 확인
		for (int j = 0; j < N; j++)
		{
			if (multitap[j] == numArr[i])
			{
				plugged = true;
				break;
			}

		}

		if (plugged)
			continue;

		// 비어있는 지 확인
		for (int j = 0; j < N; j++)
		{
			if (!multitap[j])
			{
				multitap[j] = numArr[i];
				plugged = true;
				break;
			}

		}

		if (plugged)
			continue;


		// 가장 나중에 사용 OR 사용되지 않는 플러그 찾기

		int idx = -1;
		int deviceIdx = -1;

		for (int j = 0; j < N; j++)
		{
			int lastIdx = 0;
			for (int k = i + 1; k < K; k++)
			{
				if (multitap[j] == numArr[k])
				{
					break;

				}

				lastIdx++;

			}

			if (lastIdx > deviceIdx)
			{
				idx = j;
				deviceIdx = lastIdx;
			}


		}

		multitap[idx] = numArr[i];
		result++;


	}


	cout << result << endl;

}