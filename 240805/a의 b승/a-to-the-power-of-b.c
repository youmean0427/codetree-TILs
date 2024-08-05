#include <stdio.h>

int main() {
    int a, b, ans = 1;
    scanf("%d %d", &a, &b);
    for (int i = 1; i <= b; i++) {
        ans *= a;
    }
    printf("%d", ans);
    return 0;
}