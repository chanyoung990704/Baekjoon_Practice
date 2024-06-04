#include <stdio.h>
#include <math.h>

int main()
{
    unsigned long long n, r;
    scanf("%lld",&n);
    r = (long long)sqrt((double)n); r-=(r>0);
    while(r*r < n) r++;
    printf("%llu\n", r);
}