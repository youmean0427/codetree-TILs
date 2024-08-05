#include <stdio.h>

int main() {
    int cnt = 0;
    for (int i = 0; i < 10; i++) {
        int a;
        scanf("%d", &a);

        if (a % 2 != 0) {
            cnt++;
        }
    }

    printf("%d", cnt);

    return 0;
}