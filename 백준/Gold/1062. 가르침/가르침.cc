#include <iostream>
#include <algorithm>
#include <queue>
#include <vector>
#include <stack>
#include <set>

using namespace std;

// K:최대 허용 글자 수
int N, K;

// 입력된 단어들을 담는 컨테이너
vector<string> words;


// 알고 있는 글자들을 담는 컨테이너
bool know_alphabet[26];



int brute_force(int idx, int count)
{
	int result = 0;

	//더이상 글자 학습이 불가능한 경우
	if (count == K)
	{
		int cnt = 0;

		for (int i = 0; i < N; i++)
		{
			bool isKnow = true;
			string word = words[i];


			for (int j = 0 ; j < word.size() ; j++)
			{
				// 주어진 글자가 학습이 안 된 경우
				if (know_alphabet[word[j] - 'a'] == false)
				{
					isKnow = false;
					break;
				}

			}


			// 주어진 단어를 아는 경우
			if (isKnow)
				cnt++;

		}


		return cnt;

	}



	// 글자 학습
	for (int i = idx; i < 26; i++)
	{
		// 이미 학습된 글자인 경우 건너뛰기
		if (know_alphabet[i] == true)
			continue;

		// 완전탐색
		know_alphabet[i] = true;
		// 최댓값 계속 갱신
		result = max(brute_force(i, count + 1) , result);
		know_alphabet[i] = false;


	}


	
	return result;

}



int main() {


	ios::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);



	cin >> N >> K;



	// 단어 입력
	for (int i = 0; i < N; i++)
	{
		string word;	cin >> word;

		// anta 다음 단어 시작위치 : 4 , anta/tica 를 제외한 글자 = 나머지 글자의 길이
		string cut_word = word.substr(4, word.size() - 8);

		words.push_back(cut_word);


	}




	// 알고있는 글자 수가 anta/tica 즉 5개를 만족하지 못하면 어떤 단어도 읽지 못 함.
	if (K < 5)
	{
		cout << "0" << "\n";
		exit(0);
	}


	// anta/tica 알파벳 학습

	know_alphabet['a' - 'a'] = true;
	know_alphabet['n' - 'a'] = true;
	know_alphabet['t' - 'a'] = true;
	know_alphabet['i' - 'a'] = true;
	know_alphabet['c' - 'a'] = true;




	// 모든 알파벳 돌면서 완전탐색
	// 시작 idx: 0 , 이미 5개 단어는 알기에 count : 5
	cout << brute_force(0, 5) << "\n";







}

