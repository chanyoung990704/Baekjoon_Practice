#include <cstdio>
#include <algorithm>
#include <cstring>
using namespace std;

template <typename T>
inline T abs(T a) { return (a < 0 ? -a : a); }

int n, m, boy[1001], girl[1001], D[1001][1001];

int dp(int i, int j) {
    if (i == 0 || j == 0)
        return 0;
    if (D[i][j] != -1)
        return D[i][j];

    D[i][j] = abs(boy[i] - girl[j]) + dp(i - 1, j - 1);
    if (i > j)
        D[i][j] = min(D[i][j], dp(i - 1, j));
    if (i < j)
        D[i][j] = min(D[i][j], dp(i, j - 1));

    return D[i][j];
}

int main()
{
    memset(D, -1, sizeof(D));
    scanf("%d %d", &n, &m);
    for (int i = 1; i <= n; ++i)
        scanf("%d", &boy[i]);
    for (int i = 1; i <= m; ++i)
        scanf("%d", &girl[i]);
    sort(boy + 1, boy + n + 1), sort(girl + 1, girl + m + 1);

    printf("%d\n", dp(n, m));
    return 0;
}
