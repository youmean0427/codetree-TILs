#include <stdio.h>

int main() {
    
    int arr[10];
    int idx;
    int cnt;
    int sum;

    idx = 0;
    sum = 0;
    while (idx < 10)
    {
        scanf("%d ", &arr[idx]);
        idx++;
    }

    cnt = 0;
    while (arr[cnt] < 250) {
        sum += arr[cnt];
        cnt++;
    }
    double avg;
    avg = (double)sum / (cnt);
    printf("%d %.1lf", sum, avg);
    return 0;
}