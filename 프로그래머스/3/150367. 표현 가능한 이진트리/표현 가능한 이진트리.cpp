#include <string>
#include <vector>
#include <cmath>

using namespace std;

string getBinary(long long number) {
    string binary = "";
    while(number > 0) {
        binary = (number % 2 == 1 ? '1' : '0') + binary;
        number /= 2;
    }
    return binary;
}

string getBinaryTree(long long number) {
    string binary = getBinary(number);
    
    int height = ceil(log2(binary.length() + 1));
    int size = (1 << height) - 1;
    int dummy = size - binary.length();
    
    string tree(dummy, '0');
    tree += binary;
    return tree;
}

bool checkTree(const string& binaryTree) {
    if (binaryTree.length() <= 1) return true;

    int midIndex = binaryTree.length() / 2;
    string leftTree = binaryTree.substr(0, midIndex);
    string rightTree = binaryTree.substr(midIndex + 1);

    char root = binaryTree[midIndex];
    char leftTreeRoot = leftTree.empty() ? '0' : leftTree[leftTree.length() / 2];
    char rightTreeRoot = rightTree.empty() ? '0' : rightTree[rightTree.length() / 2];

    if (root == '0' && (leftTreeRoot == '1' || rightTreeRoot == '1'))
        return false;
    else
        return checkTree(leftTree) && checkTree(rightTree);
}

vector<int> solution(vector<long long> numbers) {
    vector<int> answer;
    for(long long number : numbers) {
        string binaryTree = getBinaryTree(number);
        answer.push_back(checkTree(binaryTree) ? 1 : 0);
    }
    return answer;
}