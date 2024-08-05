#include <stdio.h>

int main() {
    int n, ans = 0;
    scanf("%d", &n);

    for (int i = 0; i < n; i++) {
        int a;
        scanf("%d", &a);
        
        if (a % 2 != 0 && a % 3 == 0) {
            ans += a;
        }
    }

    printf("%d", ans);

    return 0;
}