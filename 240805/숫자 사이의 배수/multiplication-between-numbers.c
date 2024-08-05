#include <stdio.h>

int main() {
    int a, b, sum_val = 0, cnt = 0;
    scanf("%d %d", &a, &b);

    for (int i = a; i <= b; i++) {
        if (i % 5 == 0 || i % 7 == 0) {
            sum_val += i;
            cnt += 1; 
        }
    }

    printf("%d %.1lf", sum_val, (double)sum_val / cnt );

    return 0;
}