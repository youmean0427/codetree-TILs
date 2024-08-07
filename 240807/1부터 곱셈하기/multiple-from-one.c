#include <stdio.h>

int main() {
    int n, prod = 1;
    scanf("%d", &n);

    for (int i = 1; i <= 10; i++) {
        prod *= i;
        if (prod >= n) {
            printf("%d", i);
            break;
        }
    }

    return 0;
}