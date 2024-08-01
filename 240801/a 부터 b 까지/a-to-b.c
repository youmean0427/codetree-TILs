#include <stdio.h>

int main() {
    int a, b, i;
    scanf("%d %d", &a, &b);
    i = a;
    while (i <= b) {
        printf("%d ", i);
        if (i % 2 == 0 ){
            i += 3;
        } else {
            i *= 2;
        }
    } 
    
    return 0;
}