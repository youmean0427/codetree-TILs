#include <stdio.h>

int main() {
    int i = 1, ans = 0, cnt = 0;

    while (i <= 10) {
        int a;
        scanf("%d", &a);

        if (0 <= a && a <= 200) {
            cnt++;
            ans+=a;
        }
        i++;
    }

    printf("%d %.1lf", ans, (double)ans/cnt);

    return 0;
}