#include <iostream>
#include <algorithm>
#include <queue>

using namespace std;



int main()
{

	queue<int> Deck;
	int N;
	bool isTrue = false;


	cin >> N;

	for (int i = 1; i <= N; i++)
	{
		Deck.push(i);
	}


	while (true) // 사이즈가 1이 아니라면 수행
	{
		if (Deck.size() == 1)
		{
			break;
		}

		// 제일 위 카드 버리기
		Deck.pop();
		if (Deck.size() == 1)
		{
			isTrue = true;
			break;
		}


		// 제일 위 카드 아래로 옮기기
		Deck.push(Deck.front());
		Deck.pop();

	}

	
	cout << Deck.back() << endl;

}