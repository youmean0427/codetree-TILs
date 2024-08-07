#include <stdio.h>

int main() {
    int n, k= 2, cnt = 0;
    scanf("%d", &n);

    while (1) {
        if (n == k) {
            break;
        }

        k *= 2;
        cnt++;
    }

    printf("%d", cnt+1);

    return 0;
}