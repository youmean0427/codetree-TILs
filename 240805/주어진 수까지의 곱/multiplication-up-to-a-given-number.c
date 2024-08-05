#include <stdio.h>

int main() {
    int a, b, ans = 1;
    scanf("%d %d", &a, &b);

    for (int i = a; i <= b; i++) {
        ans *= i;
    }

    printf("%d", ans);
    return 0;
}