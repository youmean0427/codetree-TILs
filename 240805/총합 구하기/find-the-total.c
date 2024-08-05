#include <stdio.h>

int main() {
    int a, b, ans = 0;
    scanf("%d %d", &a, &b);

    for (int i=a; i <=b ;i++) {
        if (i % 6 == 0 && i % 8 != 0) {
            ans += i;
        }
    }
    printf("%d", ans);
    return 0;
}