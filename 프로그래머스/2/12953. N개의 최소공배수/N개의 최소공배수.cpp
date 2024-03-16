#include <string>
#include <vector>

using namespace std;

int gcd(int a, int b) {
    if(b == 0)
        return a;
    return gcd(b, a % b);
}


int solution(vector<int> arr) {
    
    int result = 0;
    if(arr.size() == 1)
        result =  arr[0];
    if(arr.size() == 2) {
        int gcdVal = gcd(arr[0], arr[1]);
        result =  (arr[0] / gcdVal) * (arr[1] / gcdVal) * gcdVal;
    }
    if(arr.size() > 2) {
        int gcdVal = gcd(arr[0], arr[1]);
        int firstVal = (arr[0] / gcdVal) * (arr[1] / gcdVal) * gcdVal;
        
        for(int i = 2 ; i < arr.size() ; i++) {
            gcdVal = gcd(firstVal, arr[i]);
            firstVal = (firstVal / gcdVal) * (arr[i] / gcdVal) * gcdVal;
        }
        
        result = firstVal;
    }
        
    return result;
}