#include <iostream>
#include <vector>

using namespace std;

void merge(vector<int>& A, int left, int right, int mid) {

	int leftSize = mid - left + 1;
	int rightSize = right - mid;

	vector<int> leftA(leftSize);
	vector<int> rightA(rightSize);

	for (int i = 0; i < leftSize; i++)
		leftA[i] = A[left + i];
	for (int i = 0; i < rightSize; i++)
		rightA[i] = A[mid + 1 + i];

	int l = 0;	int r = 0;	int k = left;
	while (l < leftSize && r < rightSize)
	{
		if (leftA[l] < rightA[r]) {
			A[k] = leftA[l];
			l++;
		}
		else {
			A[k] = rightA[r];
			r++;
		}
		k++;
	}


	while (l < leftSize)
	{
		A[k] = leftA[l];
		l++;
		k++;
	}

	while (r < rightSize)
	{
		A[k] = rightA[r];
		r++;
		k++;
	}

}

void mergeSort(vector<int>& A, int left, int right) {
	if (left < right) {
		int mid = (left + right) / 2;
		mergeSort(A, left, mid);
		mergeSort(A, mid + 1, right);
		merge(A, left, right, mid);
	}
}

int main() {

	ios::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);

	int N;	cin >> N;
	int K;	cin >> K;
	vector<int> A(N);

	for (int i = 0; i < N; i++)
		cin >> A[i];

	int left = 0;
	int right = A.size() - 1;
	mergeSort(A, left, right);

	cout << A[K - 1] << "\n";
}