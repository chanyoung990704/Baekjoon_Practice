#include <algorithm>
#include <iostream>
#include <math.h>
#include <vector>

using namespace std;

int getGCD(int num1, int num2) {
	if (num2 == 0)
		return num1;
	return getGCD(num2, num1 % num2);
}

int getLCM(int num1, int num2, int gcd) {
	return (num1 / gcd) * (num2 / gcd) * gcd;
}

int main() {
	ios::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);

	int num1;	cin >> num1;
	int num2;   cin >> num2;

	cout << getGCD(num1, num2) << "\n";
	cout << getLCM(num1, num2, getGCD(num1, num2)) << "\n";
}