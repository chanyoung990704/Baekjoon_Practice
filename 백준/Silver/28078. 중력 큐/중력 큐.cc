#include <iostream>
#include <vector>
#include <string>
#include <deque>
#include <algorithm>
#define FASTIO cin.tie(0); cout.tie(0); ios::sync_with_stdio(false);

using namespace std;
int Q, Dir, B, W;
deque<char> DQ;
string S;
char C;

void input() {
    cin >> Q;
    while (Q--) {
        cin >> S;
        if (S == "push") {
            cin >> C;
            if ((Dir == 0) || (Dir == 2)) {
                DQ.push_front(C);
                if (C == 'b') {
                    B++;
                }
                else if (C == 'w') {
                    W++;
                }
            }
            else if (Dir == 1) {
                if (C == 'b') {
                    if (!DQ.empty()) {
                        if (DQ.back() == 'w') {
                            B++;
                            DQ.push_front(C);
                        }
                    }
                }
                else if (C == 'w') {
                    W++;
                    DQ.push_front(C);
                }
            }
            else if (Dir == 3) {
                if (C == 'w') {
                    W++;
                    DQ.push_front(C);
                }
            }
        }
        else if (S == "pop") {
            if (!DQ.empty()) {
                if (Dir == 1) {
                    if (DQ.back() == 'w') {
                        DQ.pop_back();
                        W--;
                        while (!DQ.empty()) {
                            if (DQ.back() == 'b') {
                                DQ.pop_back();
                                B--;
                            }
                            else {
                                break;
                            }
                        };
                    }
                }
                else {
                    if (DQ.back() == 'b') {
                        B--;
                    }
                    else if (DQ.back() == 'w') {
                        W--;
                    }
                    DQ.pop_back();
                }
            }
        }
        else if (S == "rotate") {
            cin >> C;
            if (C == 'l') {
                Dir--;
                if (Dir == -1) {
                    Dir = 3;
                }
            }
            else if (C == 'r') {
                Dir++;
                if (Dir == 4) {
                    Dir = 0;
                }
            }
            if (Dir == 1) {
                while (!DQ.empty()) {
                    if (DQ.back() == 'b') {
                        DQ.pop_back();
                        B--;
                    }
                    else {
                        break;
                    }
                };
            }
            else if (Dir == 3) {
                while (!DQ.empty()) {
                    if (DQ.front() == 'b') {
                        DQ.erase(DQ.begin());
                        B--;
                    }
                    else {
                        break;
                    }
                };
            }
        }
        else if (S == "count") {
            cin >> C;
            if (C == 'b') {
                cout << B << "\n";
            }
            else if (C == 'w') {
                cout << W << "\n";
            }
        }
    };
}

int main() {
    FASTIO
    input();

    return 0;
}