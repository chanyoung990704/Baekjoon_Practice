#include <string>
#include <vector>
#include <map>

using namespace std;

int score[8] = {0, 3, 2, 1, 0, 1, 2, 3};

string solution(vector<string> survey, vector<int> choices) {
    string answer = "";
    map<char, int> surv_elm;

    for(int i =0; i<survey.size(); i++)
        surv_elm[survey[i][choices[i]/4]] += score[choices[i]];

    answer += surv_elm['R'] >= surv_elm['T'] ? "R" : "T";
    answer += surv_elm['C'] >= surv_elm['F'] ? "C" : "F";
    answer += surv_elm['J'] >= surv_elm['M'] ? "J" : "M";
    answer += surv_elm['A'] >= surv_elm['N'] ? "A" : "N";

    return answer;
}
