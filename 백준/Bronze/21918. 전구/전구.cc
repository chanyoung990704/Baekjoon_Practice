#include <algorithm>
#include <iostream>
#include <vector>
#include <string>
#include <sstream>

using namespace std;

int main() {
    ios::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);


    int N;  cin >> N;
    int M;  cin >> M;

    cin.ignore();
    string s;
    getline(cin, s);

    stringstream ss(s);
    string token;
    vector<int> num_arr;

    while(getline(ss, token, ' ')){
        if(!token.empty())
            num_arr.push_back(stoi(token));
    }


    for(int i = 0 ; i < M ; i++){

        int op, l, r;
        cin >> op >> l >> r;
        l--;
        r--;
        if(op == 1){
            r++;
            num_arr[l] = r;
        }else if(op == 2){
            for(int j = l ; j <= r ; j++){
                if(num_arr[j] == 0)
                    num_arr[j] = 1;
                else
                    num_arr[j] = 0;
            }
        }else if(op == 3){
            for(int j = l ; j <= r ;j++)
                num_arr[j] = 0;

        }else if(op == 4){
            for(int j = l ; j <= r ; j++)
                num_arr[j] = 1;
        }

    }
    
    for(int i = 0 ; i < num_arr.size() ; i++) {
        cout << num_arr[i];
        if(i != num_arr.size() - 1){
            cout << " ";
        }
    }
    
}