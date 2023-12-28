#include <string>
#include <vector>

using namespace std;

vector<int> solution(vector<vector<int>> users, vector<int> emoticons) {
    vector<int> answer;

    int maxSubscriber = 0; // 플러스 서비스 가입자
    int maxPrice = 0; // 이모티콘 총 판매액
    int size = emoticons.size();

    // 비트마스크 로직
    for (int i = 0; i < (1 << (size * 2)); i++) {
        int price = 0;
        int subscriber = 0;

        for (vector<int> user : users) {
            bool isSubscribe = false;
            int userDiscount = user[0]; // 사용자가 원하는 할인액
            int userPrice = user[1]; // 사용자가 원하는 가격
            int userTotalPrice = 0;

            // 각 이모티콘 별로 가격 탐색
            for (int j = 0; j < size; j++) {
                int discountRate = (((i >> (j * 2)) & 3) + 1) * 10;
                int discountedPrice = emoticons[j] * (100 - discountRate) / 100;

                // 초과 할인율
                if (userDiscount <= discountRate) {
                    userTotalPrice += discountedPrice;
                }

                // 총합 금액이 가격보다 높을 경우
                if (userPrice <= userTotalPrice) {
                    isSubscribe = true;
                    break;
                }
            }

            // 구독자이면 구독자 ++ 아니면 가격 증가
            if (isSubscribe) {
                subscriber++;
            }
            else {
                price += userTotalPrice;
            }
        }

        // 갱신 로직
        if (maxSubscriber < subscriber || (maxSubscriber == subscriber) && maxPrice < price ) {
            maxSubscriber = subscriber;
            maxPrice = price;
        }
    }

    answer.push_back(maxSubscriber);
    answer.push_back(maxPrice);
    return answer;
}