#include <stdio.h>

int main() {
    int cnt = 0;
    while(1) {
        int a;
        scanf("%d", &a);

        if (cnt >= 3) {
            break;
        }

        if (a % 2 == 0) {
            printf("%d\n", a / 2);
            cnt++;
        }

 
    }
    return 0;
}