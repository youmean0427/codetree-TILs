n, m = map(int, input().split())
arr = list(map(int, input().split()))
targets = list(map(int, input().split()))


# 최초로 등장하는 위치 : Lower Bound
def binary_search(arr, target):
    
    left = 0
    right = n-1
    min_idx = n

    while left <= right:
        mid = (left + right) // 2
        # arr[mid]는 target보다 크거나 같음 → 그 중에서 최소값
        if arr[mid] > target:
            right = mid - 1
        elif arr[mid] == target:
            right = mid - 1
            min_idx = min(min_idx, mid+1)
        else:
            left = mid + 1
    return min_idx


for i in targets:
    ans = binary_search(arr, i)
    if ans >= n:
        print(-1)
    else:
        print(ans)