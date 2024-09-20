#include <stdio.h>
#include <stdlib.h>

int quick_sort(int *arr, int start, int end)
{
    int pivot;
    pivot = arr[end];

    int i = start - 1;
    int temp;

    for (int j = start; j < end; j++)
    {
        if (arr[j] <= pivot)
        {
            i++;
            temp = arr[j];
            arr[j] = arr[i];
            arr[i] = temp; 
        }
    }
    temp = arr[end];
    arr[end] = arr[i+1];
    arr[i+1] = temp;
    return (i+1);
}

void    quick(int *arr, int start, int end)
{
    int mid; 
    if (start < end)
    {
        mid = quick_sort(arr, start, end);

        quick(arr, start, mid - 1);
        quick(arr, mid + 1, end); 
    }
}

int main() {
    
    int n;
    int *arr;
    
    scanf("%d", &n);
    arr = (int *)malloc(sizeof(int) * n);

    for (int i = 0; i < n; i++)
    {
        int x;
        x = 0;
        scanf("%d", &x);

        arr[i] = x;
    }

    quick(arr, 0, n - 1);
    for (int i = 0; i < n; i++)
        printf("%d ", arr[i]);
    return 0;
}