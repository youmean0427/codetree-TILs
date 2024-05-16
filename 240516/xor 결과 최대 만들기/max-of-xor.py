n, m = map(int, input().split())
arr = list(map(int, input().split()))

def xor(arr):
    start = arr[0]
    for i in range(1, len(arr)):
        start = start ^ arr[i]
    return start

ans = 0
def back(cnt, sm):
    global ans

    if cnt >= n:
        if len(sm) == m:
            ans = max(ans, xor(sm))
        return

    back(cnt+1, sm+[arr[cnt]])
    back(cnt+1, sm)

back(0, [])
print(ans)