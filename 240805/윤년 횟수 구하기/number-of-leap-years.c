#include <stdio.h>

int main() {
    int n, ans = 0;
    scanf("%d", &n);
    

    for (int i = 1; i <= n; i++) {
        if (i % 4 == 0) {
            if (i % 100 == 0 && i % 400 != 0) {
                continue;
            } else {
                ans++;
            }
        }
    }

    printf("%d", ans); 
    return 0;
}