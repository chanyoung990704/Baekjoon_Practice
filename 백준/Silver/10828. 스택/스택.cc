#include<iostream>
using namespace std;


class arrStack {
private:
	int* arr;
	int capacity;
	int t;

public:
	arrStack(int capacity) {
		this->capacity = capacity;
		this->t = -1;
		this->arr = new int[capacity];
	}

	int size() {
		return t + 1;
	}

	bool empty() {
		return t == -1;
	}

	int top() {
		if (empty())
			return -1;
		else
			return arr[t];
	}

	void push(int e)
	{
		if (size() == capacity)
			return;
		else
		{
			t = t + 1;
			arr[t] = e;
		}
	}

	void pop() {
		if (empty())
			cout << "-1" << endl;
		else
		{
			cout << arr[t] << endl;
			t = t - 1;
		}
	}

};





int main() {
	int N;
	cin >> N;

	arrStack arrStack(N);

	for (int i = 0; i < N; i++)
	{
		string op;
		cin >> op;

		if (op == "push")
		{
			int val;
			cin >> val;
			arrStack.push(val);
		}

		if (op == "top")
			cout << arrStack.top() << endl;

		if (op == "size")
			cout << arrStack.size() << endl;

		if (op == "pop")
			arrStack.pop();
		if (op == "empty")
		{
			if (arrStack.empty())
				cout << "1" << endl;
			else
				cout << "0" << endl;
		}


	}

}