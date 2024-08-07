#include <stdio.h>

int main() {
    
    int n, cnt = 0;
    scanf("%d", &n);

    while(1) {

        if (n >= 1000) {
            printf("%d", cnt);
            break;
        }
        
        if (n % 2 == 0) {
            n *= 3;
            n++;
        } else {
            n *= 2;
            n += 2;
        }
        cnt++;

    }

    return 0;
}