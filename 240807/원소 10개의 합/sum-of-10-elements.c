#include <stdio.h>

int main() {
    int arr[10], sum_val = 0;

    for (int i = 0; i < 10; i++) {
        int a;
        scanf("%d", &arr[i]);
    }

    for (int idx = 0; idx < 10; idx++) {
        sum_val += arr[idx];
    }

    printf("%d", sum_val);
    return 0;
}