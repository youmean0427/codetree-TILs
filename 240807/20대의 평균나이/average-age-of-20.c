#include <stdio.h>

int main() {
    int sum_val = 0;
    int cnt = 0;
    while (1) {
        int a;
        scanf("%d", &a);

        if (a >= 30 || a < 20) {
            break;
        }
        
        sum_val += a;
        cnt++;
    }

    printf("%.2lf", (double)sum_val / cnt);
    return 0;
}