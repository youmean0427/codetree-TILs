#include <stdio.h>

int main() {
    while(1) {
        int a;
        scanf("%d", &a);

        if (a == 0) {
            break;
        }
        printf("%d\n", a);
    }
    return 0;
}