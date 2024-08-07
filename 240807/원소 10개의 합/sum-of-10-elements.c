#include <stdio.h>

int main() {
    int arr[10], sum_val = 0;

    for (int i = 0; i < 10; i++) {
        int a;
        scanf("%d", &a);
        arr[i] = a;
        sum_val += arr[i];
    }

    printf("%d", sum_val);
    return 0;
}