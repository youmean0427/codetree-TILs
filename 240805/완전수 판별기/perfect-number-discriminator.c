#include <stdio.h>

int main() {
    int n, ans = 0;
    scanf("%d", &n);

    for (int i = 1; i < n; i++) {
        if (n % i == 0) {
            ans+= i;
        }
    }

    if (ans == n) {
        printf("P");
    } else {
        printf("N");
    }
    
    return 0;
}