n = int(input())
arr = []
for _ in range(n):
    arr.append(list(map(int, input().split())))

def check(arr):

    visited = [0] * (1001)
    cnt = 0

    for s, e in arr:
        for i in range(s, e+1):
            if visited[i]:
                return 0
            visited[i] = 1
        cnt += 1
    return cnt

ans = 0
def back(cnt, sm):
    global ans

    if cnt >= n:
        ans = max(ans, check(sm))
        return
    
    back(cnt+1, sm + [arr[cnt]])
    back(cnt+1, sm)

back(0, [])
print(ans)