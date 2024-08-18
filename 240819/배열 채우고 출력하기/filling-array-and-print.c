#include <stdio.h>

int main() {
    
    int idx;
    char arr[10];
    
    idx = 0;
    while (idx <= 9)
    {
        scanf("%c ", &arr[idx]);
        idx++;
    }
    idx = 9;
    while (idx >= 0)
    {
        printf("%c", arr[idx]);
        idx--;
    }
    return 0;
}