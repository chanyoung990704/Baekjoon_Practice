#include <iostream>
using namespace std;

int P1(int num) {

	int result = num;

	while (num != 0) {
		int value = num % 10;
		result += value;
		num /= 10;
	}

	return result;
}



int P2(int num) {

	for (int i = 1; i <= 1000000; i++) {
		if (P1(i) == num) {
			return i;
		}
	}

	return 0;
}




int main() {

	int N;
	cin >> N;

	cout << P2(N) << endl;
}