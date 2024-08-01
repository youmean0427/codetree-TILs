#include <stdio.h>

int main() {
    int a;
    scanf("%d", &a);
    
    for (int i = 1; i <= a; i++) {
        if (i % 3 == 0) {
            printf("%d ", 0);
        } else if (i / 10 == 3 || i / 10 == 6 || i / 10 == 9) {
            printf("%d ", 0);
        } else if (i % 10 == 3 || i % 10 == 6 || i % 10 == 9) {
            printf("%d ", 0);
        } else {
            printf("%d ", i);
        }
    }
    
    return 0;
}