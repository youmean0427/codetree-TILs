n = int(input())
arr = list(map(int, input().split()))

merged_arr = [0 for _ in range(n)]
def merge(arr, start, mid, end):

    i = start
    j = mid + 1
    k = start

    while (i <= mid and j <= end):
        if (arr[i] <= arr[j]):
            merged_arr[k] = arr[i]
            i += 1
            k += 1
        else:
            merged_arr[k] = arr[j]
            j += 1
            k += 1
    
    while (i <= mid):
        merged_arr[k] = arr[i]
        k += 1
        i += 1
    
    while (j <= end):
        merged_arr[k] = arr[j]
        k += 1
        j += 1
    
    for i in range(start, end+1):
        arr[i] = merged_arr[i]
    
def merge_sort(arr, start, end):
    if start < end:
        mid = (start + end) // 2
        merge_sort(arr, start, mid)
        merge_sort(arr, mid + 1, end)
        merge(arr, start, mid, end)
  
merge_sort(arr, 0, len(arr) - 1)
print(*arr)