#include <stdio.h>

int main() {
    while(1) {
        int a;
        scanf("%d", &a);

        if (a < 25) {
            printf("Higher\n");
        } else if (a > 25) {
            printf("Lower\n");
        } else {
            printf("Good");
            break;
        }
    }
    return 0;
}