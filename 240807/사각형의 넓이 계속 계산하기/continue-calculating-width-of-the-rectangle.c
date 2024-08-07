#include <stdio.h>

int main() {
    int a, b;
    char c;


    while(1) {
        int a, b;
        char c;

        scanf("%d %d %c", &a, &b, &c);
        if (c != 'C') {
            printf("%d\n", a * b);
        } else {
            printf("%d\n", a * b);
            break;
        }
    }


    return 0;
}