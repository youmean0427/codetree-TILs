#include <stdio.h>

int main() {
    
    int arr[10];
    int idx;
    int total;
    int cnt;

    idx = 0;
    while (idx < 10)
    {
        scanf("%d", &arr[idx]);
        idx++;
    }
    idx = 0;
    cnt = 0;
    total = 0;
    while (idx < 10)
    {
        if (arr[idx] >= 250)
        {
            break;
        }
        total += arr[idx];
        cnt += 1;
        idx++;
    }

    printf("%d %.1lf", total, (double)total/cnt);
}