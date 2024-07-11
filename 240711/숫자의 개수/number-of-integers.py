n, m = map(int, input().split())
arr = list(map(int, input().split()))


def bisect_left(x):

    start = 0
    end = n-1
    idx = n

    while start <= end:
        mid = (start + end) // 2

        if arr[mid] >= x:
            idx = min(idx, mid)
            end = mid - 1
        else:
            start = mid + 1
    return idx
            
def bisect_right(x):
    start = 0
    end = n-1
    idx = n

    while start <= end:
        mid = (start + end) // 2

        if arr[mid] > x:
            idx = min(idx, mid)
            end = mid - 1
        else:
            start = mid + 1
    return idx        


def custom(x):
    start = 0
    end = n-1
    idx = 0

    while start <= end:
        mid = (start + end) // 2

        if arr[mid] <= x:
            idx = max(idx, mid)
            start = mid + 1
        else:
            end = mid - 1
    return idx        

for i in range(m):
    x = int(input())
    if bisect_right(x) == bisect_left(x):
        print(0)
    else:
        print(bisect_right(x) - bisect_left(x))