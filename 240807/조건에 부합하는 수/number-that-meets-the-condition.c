#include <stdio.h>

int main() {
    int a;
    scanf("%d", &a);

    for (int i = 1; i <= a; i++) {

        if (i % 2 == 0 && i % 4 != 0) {
            continue;
        } else if ((i / 8) % 2 == 0 ) {
            continue;
        } else if (i % 7 < 4) {
            continue;
        }

        printf("%d ", i);
    }

    return 0;
}