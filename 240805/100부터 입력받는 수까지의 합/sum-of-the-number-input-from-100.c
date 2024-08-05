#include <stdio.h>

int main() {
    int n, ans = 0;
    scanf("%d", &n);

    for (int i = n; i<= 100; i++) {
        ans += i;
    }

    printf("%d", ans);
    return 0;
}