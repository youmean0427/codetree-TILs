#include <stdio.h>

int main() {
    int n, prod = 0;
    scanf("%d", &n);

    for (int i = 1; i <= 100; i++) {
        prod += i;

        if (prod >= n) {
            printf("%d", i);
            break;
        }
    }

    return 0;
}