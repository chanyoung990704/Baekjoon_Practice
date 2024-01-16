#include <iostream>
#include <map>
#include <vector>

using namespace std;

// 로마 숫자를 아라비아 숫자로 변환하는 함수
int romanToArabic(const string& roman) {
    map<char, int> romanValues = {
        {'I', 1}, {'V', 5}, {'X', 10}, {'L', 50},
        {'C', 100}, {'D', 500}, {'M', 1000}
    };
    int sum = 0;
    for (int i = 0; i < roman.size(); i++) {
        if (i + 1 < roman.size() && romanValues[roman[i]] < romanValues[roman[i + 1]]) {
            sum -= romanValues[roman[i]];
        }
        else {
            sum += romanValues[roman[i]];
        }
    }
    return sum;
}

// 아라비아 숫자를 로마 숫자로 변환하는 함수
string arabicToRoman(int number) {
    vector<pair<int, string>> values = {
        {1000, "M"}, {900, "CM"}, {500, "D"}, {400, "CD"},
        {100, "C"}, {90, "XC"}, {50, "L"}, {40, "XL"},
        {10, "X"}, {9, "IX"}, {5, "V"}, {4, "IV"}, {1, "I"}
    };
    string result;
    for (const auto& value : values) {
        while (number >= value.first) {
            result += value.second;
            number -= value.first;
        }
    }
    return result;
}

int main() {
    string roman1, roman2;
    cin >> roman1 >> roman2;
    int arabicSum = romanToArabic(roman1) + romanToArabic(roman2);

    cout << arabicSum << endl;
    cout << arabicToRoman(arabicSum) << endl;

    return 0;
}
