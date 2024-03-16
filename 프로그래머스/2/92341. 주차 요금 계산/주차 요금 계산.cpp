#include <string>
#include <algorithm>
#include <vector>
#include <map>
#include <sstream>
#include <set>
using namespace std;

int calTime(string in, string out) {

	// 시간 계산
	string outHour = out.substr(0, out.find(':'));
	string inHour = in.substr(0, in.find(':'));
	// 분 계산
	string outMinute = out.substr(out.find(':') + 1);
	string inMinute = in.substr(in.find(':') + 1);

	int oh = stoi(outHour);	int ih = stoi(inHour);
	int om = stoi(outMinute); int im = stoi(inMinute);

	int o = oh * 60 + om;
	int i = ih * 60 + im;

	return o - i;

}

vector<int> solution(vector<int> fees, vector<string> records) {

	// 차량이 입차되었는지 확인 
	map<string, bool> isIn;
	// 차량이 언제 입차되었는지 확인
	map<string, string> carTime;
	set<string> cars;
	map<string, int> carTotalTime; // 누적 주차 시간

	for (string record : records) {
		// 띄어쓰기 별로 분할
		vector<string> v;
		stringstream ss(record);
		string tmp;

		while (getline(ss, tmp, ' ')) {
			v.push_back(tmp);
		}

		cars.insert(v[1]);
		// 입차 상태일 때
		if (v[2] == "IN") {
			carTime[v[1]] = v[0];
			isIn[v[1]] = true;
		}

		// 출차 상태일 때 
		if (v[2] == "OUT") {
			int t = calTime(carTime[v[1]], v[0]);
			carTotalTime[v[1]] += t;
			isIn[v[1]] = false;
		}

	}

	vector<int> result;
	// 출차 안된차들 확인
	for(string car : cars)
		if (isIn[car]) {
			int t = calTime(carTime[car], "23:59");
			carTotalTime[car] += t;
		}


	// 가격 정산
	for (string car : cars) {
		if (carTotalTime[car] <= fees[0])
			result.push_back(fees[1]);
		else
		{
			int additionalTime = carTotalTime[car] - fees[0];
			int additionalFee = ((additionalTime - 1) / fees[2] + 1) * fees[3];
			int totalFee = fees[1] + additionalFee;
			result.push_back(totalFee);
		}
	}

	return result;
}