n = int(input())
arr = list(map(int, input().split()))

ans = float('inf')
def back(cnt, sm, sm2):
    global ans
    if cnt >= len(arr):
        if len(sm) == n:
            ans = min(ans, abs(sum(sm) - sum(sm2)))
        return

    back(cnt+1, sm + [arr[cnt]], sm2)
    back(cnt+1, sm, sm2 + [arr[cnt]])

back(0, [], [])
print(ans)