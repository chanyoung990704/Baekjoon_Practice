#include <algorithm>
#include <iostream>
#include <vector>

using namespace std;

bool isPassword(string password) {

	// ee를 e로 변환
	size_t pos = password.find("ee");
	while (pos != string::npos)
	{
		password.replace(pos, 2, "e");
		pos = password.find("ee", pos + 1);
	}

	//oo를 o로 변환
	pos = password.find("oo");
	while (pos != string::npos)
	{
		password.replace(pos, 2, "o");
		pos = password.find("oo", pos + 1);
	}

	bool prevStatus = false; // false : 자음, true : 모음
	char prevChar = ' '; // 이전 단어
	int cnt = 0; // 연속 자음 / 모음 개수
	bool isM = false; // 모음 있는지 확인

	for (int i = 0; i < password.size(); i++) {
		if (cnt >= 3)
			return false;
		
		if (prevChar == password[i])
			return false;

		// 모음인 경우
		if (password[i] == 'a' || password[i] == 'e' || password[i] == 'i' || password[i] == 'o' || password[i] == 'u') {
			isM = true;
			// 이전 단어가 자음인경우
			if (!prevStatus) {
				prevStatus = true;
				cnt = 1;
			}
			else {
				cnt++;
			}
		}

		// 자음인 경우
		else {
			// 이전 단어가 자음인 경우
			if (!prevStatus)
				cnt++;
			else {
				prevStatus = false;
				cnt = 1;
			}

		}

		// 이전 단어 갱신
		prevChar = password[i];

	}

	if (!isM || cnt >= 3)
		return false;

	return true;

}

int main() {

	ios::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);

	while (true)
	{
		string password;	cin >> password;

		if (password == "end")
			break;

		if (isPassword(password))
			cout << "<" << password << "> is acceptable.\n";
		else
			cout << "<" << password << "> is not acceptable.\n";
	}

}