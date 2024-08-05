#include <stdio.h>

int main() {
    int a, b, ans =0 ;
    scanf("%d %d", &a, &b);

    
    if (a > b) {
        for (int i = a; i <= b; i++) {
            if (i % 5 == 0) {
                ans += i;
            }
        } 
    } else {
        for (int i = b; i <= a ; i++) {
            if (i% 5 == 0) {
                ans += i;
            }
        }
    }

    printf("%d", ans);
    return 0;
}