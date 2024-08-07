#include <stdio.h>

int main() {
    int n, idx = 1, cnt = 0;
    scanf("%d", &n);

    while(n > 1) {
        n /= idx;
        idx++;
        cnt++;
    }
    printf("%d", cnt);
    return 0;
}