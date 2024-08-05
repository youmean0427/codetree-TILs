#include <stdio.h>

int main() {
    int n, ans = 0;
    scanf("%d", &n);

    for (int i = 1; i <= n; i++) {
        int a;
        scanf("%d", &a);
        ans += a;
    }

    printf("%d %.1lf", ans, (double)ans / n);

    return 0;
}