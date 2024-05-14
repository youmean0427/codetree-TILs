n = int(input())
arr = []
for _ in range(n):
    arr.append(list(map(int, input().split())))

def check(arr):

    visited = [0] * (16)
    cnt = 0

    for s, e in arr:
        if visited[s]:
            return 0
        if visited[e]:
            return 0

        visited[s] = 1
        visited[e] = 1
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