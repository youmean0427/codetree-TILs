n = int(input())
arr = list(map(int, input().split()))

def partition(start, end):

    pivot = arr[end]
    i = start - 1

    for j in range(start, end):
        if (arr[j] < pivot):
            i += 1
            arr[i], arr[j] = arr[j], arr[i]
    
    arr[i + 1], arr[end] = arr[end], arr[i + 1]
    return i + 1

def quick(start, end):

    if start < end:
        pos = partition(start, end)

        quick(start, pos - 1)
        quick(pos + 1, end)

quick(0, n - 1)
print(*arr)