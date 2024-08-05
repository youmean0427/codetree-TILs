#include <stdio.h>

int main() {
    
    int three = 0;
    int five = 0;

    for (int i = 1; i <= 10; i++) {
        int a;
        scanf("%d", &a);

        if (a % 3 == 0) {
            three++;
        } 
        if (a % 5 == 0) {
            five++;
        }
    }

    printf("%d %d", three, five);
    return 0;
}