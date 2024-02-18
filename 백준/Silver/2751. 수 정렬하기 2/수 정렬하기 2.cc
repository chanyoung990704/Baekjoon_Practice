#include <iostream>
#include <vector>
#include <algorithm> // std::swap 사용을 위해 추가

using namespace std;

void merge(vector<int>& arr, int left, int right, int mid) {
    int leftSize = mid - left + 1;
    int rightSize = right - mid;

    vector<int> leftArr(leftSize);
    vector<int> rightArr(rightSize);

    for (int i = 0; i < leftSize; i++)
        leftArr[i] = arr[left + i];
    for (int i = 0; i < rightSize; i++)
        rightArr[i] = arr[mid + 1 + i];

    int l = 0;
    int r = 0;
    int k = left;

    while (l < leftSize && r < rightSize) {
        if (leftArr[l] > rightArr[r]) {
            arr[k] = rightArr[r];
            k++;
            r++;
        } else {
            arr[k] = leftArr[l];
            k++;
            l++;
        }
    }

    while (l < leftSize) {
        arr[k] = leftArr[l];
        k++;
        l++;
    }

    while (r < rightSize) {
        arr[k] = rightArr[r];
        k++;
        r++;
    }
}

void mergeSort(vector<int>& arr, int left, int right) {
    if (left < right) {
        int mid = left + (right - left) / 2;
        mergeSort(arr, left, mid);
        mergeSort(arr, mid + 1, right);
        merge(arr, left, right, mid);
    }
}

int main() {
    ios::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);

    int N;
    scanf("%d", &N); // 입력 부분 수정

    vector<int> arr(N);

    for (int i = 0; i < N; i++)
        scanf("%d", &arr[i]); // 입력 부분 수정

    mergeSort(arr, 0, arr.size() - 1);

    for (int n : arr)
        printf("%d\n", n); // 출력 부분 수정

    return 0;
}
