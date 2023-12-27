#include <iostream>
#include <string>
#include <sstream>
#include <iomanip>
#include <map>
#include <tuple>
#include <vector>

using namespace std;

tuple<int, int, int> parseDate(const string& date) {
    stringstream ss(date);
    string tmp = "";
    vector<int> tmp_result;

    while (getline(ss, tmp, '.')) {
        tmp_result.push_back(stoi(tmp));
    }

    return make_tuple(tmp_result[0], tmp_result[1], tmp_result[2]);
}

string makeDate(tuple<int, int, int> date, int term) {
    int getYear = get<0>(date);
    int getMonth = get<1>(date);
    int getDay = get<2>(date);
    
    //날짜 구하는 로직
    getMonth = getMonth + term;
    getYear += (getMonth - 1) / 12;
    getMonth = (getMonth - 1) % 12 + 1;

    //string 출력
    stringstream ss;
    ss << setfill('0') << setw(4) << getYear << "." << setw(2) << getMonth << "."
        << setw(2) << getDay;

    return ss.str();
}


vector<int> solution(string today, vector<string> terms, vector<string> privacies) {
    vector<int> answer;

    // term 매핑
    map<char, int> termsMap;
    for (string term : terms) {
        termsMap.insert(make_pair(term.front(), stoi(term.substr(2))));
    }

    int idx = 0;
    // privacies 계산
    for (string privacy : privacies) {
        tuple<int, int, int> getDate = parseDate(privacy.substr(0, 10));
        int getTerm = termsMap.at(privacy.back());

        string renewalDate = makeDate(getDate, getTerm);
        idx++;
        if (renewalDate <= today)
            answer.push_back(idx);
    }

    return answer;
}